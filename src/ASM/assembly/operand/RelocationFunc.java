//package assembly.operand;
package src.ASM.assembly.operand;
//表示汇编指令中的重定位函数。
public class RelocationFunc extends Imm {
  public enum Type { hi, lo };
  public Type type;
  public String symbol;

  public RelocationFunc(Type type, String symbol) {
    super(0);
    this.type = type;
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return type == Type.hi ? "%hi(" + symbol + ")" : "%lo(" + symbol + ")";
  }
}