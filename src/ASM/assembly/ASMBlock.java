package src.ASM.assembly;

import src.ASM.assembly.inst.*;
import src.ASM.assembly.operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;

public class ASMBlock {
  public String name; // do not print when null
  public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();
  public LinkedList<ASMBlock> succ = new LinkedList<ASMBlock>(), pred = new LinkedList<ASMBlock>();
  public HashSet<Reg> liveIn = new HashSet<Reg>(), liveOut = new HashSet<Reg>();
  public HashSet<Reg> use = new HashSet<Reg>(), def = new HashSet<Reg>();
  public ASMBlock(String name) {
    this.name = name;
  }

  public void addInst(ASMInst inst) {
    insts.add(inst);
  }

  public String toString() {
    String shit_ins = "";
    if (name != null) shit_ins += name + ":\n";
    for (ASMInst inst : insts)
      shit_ins += "  " + inst + "\n";
    return shit_ins;
  }
}