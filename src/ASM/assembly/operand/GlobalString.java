//package assembly.operand;
package src.ASM.assembly.operand;
public class GlobalString extends Global {
  public String glb_str;
  public GlobalString(String name, String glb_str) {
    super(name);
    this.glb_str = glb_str;
  }

  public String toString() {
    String ret = name + ":\n";
    ret += "  .string \"" + glb_str.replace("\\", "\\\\")
        .replace("\n", "\\n")
        .replace("\0", "")
        .replace("\t", "\\t")
        .replace("\"", "\\\"") + "\"\n";
    return ret;
  }
}