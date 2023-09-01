//package assembly.inst;
package src.ASM.assembly.inst;
import src.ASM.assembly.operand.*;

public class ASMBinaryInst extends ASMInst {
  String op;

  public ASMBinaryInst(String op, Reg rd, Reg rs1, Reg rs2) {

//    sdiv：表示有符号整数除法。在RISC-V指令集中，该操作符被转换为div指令，用于将源寄存器1(rs1)的值除以源寄存器2(rs2)的值，并将结果保存到目标寄存器(rd)中。
//
//srem：表示有符号整数取余。在RISC-V指令集中，该操作符被转换为rem指令，用于计算源寄存器1(rs1)的值除以源寄存器2(rs2)的值的余数，并将结果保存到目标寄存器(rd)中。
//
//shl：表示逻辑左移。在RISC-V指令集中，该操作符被转换为sll指令，用于将源寄存器1(rs1)的值向左移动源寄存器2(rs2)个位置，并将结果保存到目标寄存器(rd)中。
//
//ashr：表示算术右移。在RISC-V指令集中，该操作符被转换为sra指令，用于将源寄存器1(rs1)的值进行算术右移，位数由源寄存器2(rs2)指定，并将结果保存到目标寄存器(rd)中。


    this.op = op;
    this.rd = rd;
    this.rs1 = rs1;
    this.rs2 = rs2;
  }

  @Override
  public String toString() {
    return op + " " + rd + ", " + rs1 + ", " + rs2;
  }
}
