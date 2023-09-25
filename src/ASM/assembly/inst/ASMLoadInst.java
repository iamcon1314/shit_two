//package assembly.inst;
package src.ASM.assembly.inst;
import src.ASM.assembly.operand.*;

public class ASMLoadInst extends ASMInst {
  int size;
  // size : 1 -> load_bite, 4 -> load_word

  public ASMLoadInst(int size, Reg rd, Reg rs1, Imm imm) {
    //    return "l" + (size == 1 ? "b" : "w") + " " + rd + ", " + imm + "(" + rs1 + ")";
    this.size = size;
    this.rd = rd;
    this.rs1 = rs1;
    this.imm = imm;
  }
  public ASMLoadInst(int size, Reg rd, Reg rs1) {
    this(size, rd, rs1, new Imm(0));
  }

  @Override
  public String toString() {
    return (size == 1 ? "lb" : "lw") + " " + rd + ", " + imm + "(" + rs1 + ")";
  }
}