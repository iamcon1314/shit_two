//package assembly.operand;
package src.ASM.assembly.operand;

//全局变量
//包括全局String和value
public abstract class Global extends Reg {
  public String name;
  public Global(String name) {
    this.name = name;
  }
  public Global(){}
}