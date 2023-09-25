//package assembly.inst;
package src.ASM.assembly.inst;
import src.ASM.assembly.operand.*;

public class ASMStoreInst extends ASMInst {
  int size;
  // size : 1 -> sb, 4 -> sw
  public ASMStoreInst(int size, Reg rs1, Reg rs2, Imm imm) {
    //return (size == 1 ? "sb" : "sw") + " " + rs2 + ", " + imm + "(" + rs1 + ")";
    this.size = size;
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.imm = imm;
  }
  public ASMStoreInst(int size, Reg rs1, Reg rs2) {
    //return (size == 1 ? "sb" : "sw") + " " + rs2 + ", " + imm + "(" + rs1 + ")";
    this(size, rs1, rs2, new Imm(0));
  }

  @Override
  public String toString() {
    return (size == 1 ? "sb" : "sw") + " " + rs2 + ", " + imm + "(" + rs1 + ")";
  }
}