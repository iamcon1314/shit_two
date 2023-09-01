package src.ASM.assembly.inst;

import src.ASM.assembly.operand.*;
import src.ASM.assembly.*;

public class ASMBeqzInst extends ASMInst {
  ASMBlock toBlock;

  public ASMBeqzInst(Reg rs, ASMBlock toBlock) {
    this.rs1 = rs;
    this.toBlock = toBlock;
  }

//beqz是RISC-V指令集中的一条指令，用于在寄存器值等于零时执行条件跳转。它的全称是"branch if equal to zero"，表示如果某个寄存器的值为零，则跳转到目标地址执行程序。
//
//该指令的基本语法如下：
//
//beqz rs, label
//其中，rs是一个通用寄存器，用于比较其值是否为零。label是目标地址，在特定条件满足时跳转至该地址执行。如果rs寄存器的值为零，则控制流将跳转到label处执行指令；否则，程序将继续按顺序执行后续指令。
//
//需要注意的是，RISC-V采用相对跳转的方式，所以label通常表示相对于当前指令地址的偏移量。
//
//因此，beqz指令可用于根据寄存器值是否为零来实现条件跳转的程序控制。


  @Override
  public String toString() {
    return "beqz " + rs1 + ", " + toBlock.name;
  }
}