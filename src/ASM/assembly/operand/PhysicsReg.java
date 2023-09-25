//package assembly.operand;
package src.ASM.assembly.operand;
//import java.util.HashMap;
import java.util.LinkedHashMap;

public class PhysicsReg extends Reg {
  public String name;
//  public void putReg(){
//    regMap.put()
//  }
//public static LinkedHashMap<String, PhysicsReg> reg1Map = new LinkedHashMap<>(){
//
//};
  public static LinkedHashMap<String, PhysicsReg> regMap = new LinkedHashMap<>();
  public PhysicsReg(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  static {
    regMap.put("zero", new PhysicsReg("zero"));
    regMap.put("ra", new PhysicsReg("ra"));
    regMap.put("sp", new PhysicsReg("sp"));
    regMap.put("t0", new PhysicsReg("t0"));
    regMap.put("t1", new PhysicsReg("t1"));
    regMap.put("t2", new PhysicsReg("t2"));
    regMap.put("a0", new PhysicsReg("a0"));
    regMap.put("a1", new PhysicsReg("a1"));
    regMap.put("a2", new PhysicsReg("a2"));
    regMap.put("a3", new PhysicsReg("a3"));
    regMap.put("a4", new PhysicsReg("a4"));
    regMap.put("a5", new PhysicsReg("a5"));
    regMap.put("a6", new PhysicsReg("a6"));
    regMap.put("a7", new PhysicsReg("a7"));
  }
}