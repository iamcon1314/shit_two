//package assembly.inst;
package src.ASM.assembly.inst;
import src.ASM.assembly.operand.*;

public class ASMMvInst extends ASMInst {
  public ASMMvInst(Reg rd, Reg rs) {
    //return "mv " + rd + ", " + rs1
    this.rd = rd;
    this.rs1 = rs;
  }
//
  @Override
  public String toString() {
    return "mv " + rd + ", " + rs1;
  }
}