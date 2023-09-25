package src.ASM.backend;

import java.util.LinkedList;

import src.ASM.assembly.*;
import src.ASM.assembly.operand.*;
import src.ASM.assembly.inst.*;

public class RegAllocator {
  ASMModule module;
  ASMBlock block;
  int totalStack;
  int virtualRegBegin;
  PhysicsReg Rega0 = PhysicsReg.regMap.get("a0");
  PhysicsReg Rega1 = PhysicsReg.regMap.get("a1");
  PhysicsReg Rega2 = PhysicsReg.regMap.get("a2");
  PhysicsReg Rega3 = PhysicsReg.regMap.get("a3");
  PhysicsReg Rega4 = PhysicsReg.regMap.get("a4");
  PhysicsReg Rega5 = PhysicsReg.regMap.get("a5");
  PhysicsReg Rega6 = PhysicsReg.regMap.get("a6");
  PhysicsReg Rega7 = PhysicsReg.regMap.get("a7");
  PhysicsReg Regt0 = PhysicsReg.regMap.get("t0");
  PhysicsReg Regt1 = PhysicsReg.regMap.get("t1");
  PhysicsReg Regt2 = PhysicsReg.regMap.get("t2");
  PhysicsReg Regsp = PhysicsReg.regMap.get("sp");
  LinkedList<ASMInst> workList;

  public RegAllocator(ASMModule module) {
    this.module = module;
  }
  public RegAllocator(){

  }
  public void visitBlock(ASMBlock block) {
    workList = new LinkedList<ASMInst>();
    for (ASMInst inst : block.insts) {
      if (inst.rs1 != null && !(inst.rs1 instanceof PhysicsReg)) {
        allocateSrc(Regt1, inst.rs1);
        inst.rs1 = Regt1;
      }
      if (inst.rs2 != null && !(inst.rs2 instanceof PhysicsReg)) {
        allocateSrc(Regt0, inst.rs2);
        inst.rs2 = Regt0;
      }
      workList.add(inst);
      if (inst.rd != null && !(inst.rd instanceof PhysicsReg)) {
        allocaDest(Regt0, inst.rd);
        inst.rd = Regt0;
      }
    }
    block.insts = workList;
  }

  void allocateSrc(PhysicsReg reg, Reg src) {
    if (src instanceof VirtualReg) {
      int offset = ((VirtualReg) src).id != -1
          ? virtualRegBegin + ((VirtualReg) src).id * 4
          : totalStack + ((VirtualReg) src).param_idx * 4;
      if (offset < 1 << 11)
        workList.add(new ASMLoadInst(((VirtualReg) src).size, reg, Regsp, new Imm(offset)));
      else {
        workList.add(new ASMLiInst(Regt2, new VirtualImm(offset)));
        workList.add(new ASMBinaryInst("add", Regt2, Regt2, Regsp));
        workList.add(new ASMLoadInst(((VirtualReg) src).size, reg, Regt2));
      }
    } else if (src instanceof VirtualImm) {
      workList.add(new ASMLiInst(reg, (VirtualImm) src));
    } else if (src instanceof Global) {
      workList.add(new ASMLuiInst(reg, new RelocationFunc(RelocationFunc.Type.hi, ((Global) src).name)));
      workList.add(new ASMUnaryInst("addi", reg, reg, new RelocationFunc(RelocationFunc.Type.lo, ((Global) src).name)));
    }
  }

  void allocaDest(PhysicsReg reg, Reg dest) {
    if (dest instanceof VirtualReg) {
      int offset = ((VirtualReg) dest).id != -1
          ? virtualRegBegin + ((VirtualReg) dest).id * 4
          : totalStack + ((VirtualReg) dest).param_idx * 4;
      if (offset < 1 << 11)
        workList.add(new ASMStoreInst(((VirtualReg) dest).size, Regsp, reg, new Imm(offset)));
      else {
        workList.add(new ASMLiInst(Regt2, new VirtualImm(offset)));
        workList.add(new ASMBinaryInst("add", Regt2, Regt2, Regsp));
        workList.add(new ASMStoreInst(((VirtualReg) dest).size, Regt2, reg));
      }
    }
  }

  public void work() {
    for (ASMFunction function : module.functions) {
      totalStack = function.totalStack;
      virtualRegBegin = function.paramUsed + function.allocaUsed;
      for (ASMBlock block : function.blocks) {
        visitBlock(block);
      }
    }
  }
}