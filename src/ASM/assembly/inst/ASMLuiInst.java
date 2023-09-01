//package assembly.inst;
package src.ASM.assembly.inst;
import src.ASM.assembly.operand.*;

public class ASMLuiInst extends ASMInst {
  public ASMLuiInst(Reg dest, Imm imm) {
    this.rd = dest;
    this.imm = imm;
  }
//Lui是RISC-V指令集中的一条指令，用于将一个立即数的高位加载到目标寄存器中。它是 "Load Upper Immediate" 的缩写。
//
//该指令的语法如下：
//
//lui rd, imm
//rd 是目标寄存器，表示要将立即数的高位加载到的寄存器。
//imm 是一个立即数，表示要加载的值。
//lui 指令将 imm 的 20 位立即数左移 12 位，并将结果放入目标寄存器 rd 的高位（低位填充零）。这是一种加载大常量的有效方法，因为它可以直接加载高位并保留低位为零，而不需要多条指令。
//
//例如，以下指令将立即数 0x1234 的高位加载到目标寄存器 x1 中：
//
//lui x1, 0x1234
//注意：由于立即数只有 20 位长，所以不能加载超过 20 位的大常量。如果要加载超过 20 位的常量，可以使用其他指令或组合多条指令来实现。

  @Override
  public String toString() {
    return "lui " + rd + ", " + imm;
  }
}