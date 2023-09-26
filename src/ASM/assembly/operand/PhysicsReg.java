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
    regMap.put("gp", new PhysicsReg("gp"));
    regMap.put("tp", new PhysicsReg("tp"));
    regMap.put("t0", new PhysicsReg("t0"));
    regMap.put("t1", new PhysicsReg("t1"));
    regMap.put("t2", new PhysicsReg("t2"));
    regMap.put("s0", new PhysicsReg("s0"));
    regMap.put("s1", new PhysicsReg("s1"));
    regMap.put("s2", new PhysicsReg("s2"));
    regMap.put("s3", new PhysicsReg("s3"));
    regMap.put("s4", new PhysicsReg("s4"));
    regMap.put("s5", new PhysicsReg("s5"));
    regMap.put("s6", new PhysicsReg("s6"));
    regMap.put("s7", new PhysicsReg("s7"));
    regMap.put("s8", new PhysicsReg("s8"));
    regMap.put("s9", new PhysicsReg("s9"));
    regMap.put("s10", new PhysicsReg("s10"));
    regMap.put("s11", new PhysicsReg("s11"));
    regMap.put("t3", new PhysicsReg("t3"));
    regMap.put("t4", new PhysicsReg("t4"));
    regMap.put("t5", new PhysicsReg("t5"));
    regMap.put("t6", new PhysicsReg("t6"));
    regMap.put("a0", new PhysicsReg("a0"));
    regMap.put("a1", new PhysicsReg("a1"));
    regMap.put("a2", new PhysicsReg("a2"));
    regMap.put("a3", new PhysicsReg("a3"));
    regMap.put("a4", new PhysicsReg("a4"));
    regMap.put("a5", new PhysicsReg("a5"));
    regMap.put("a6", new PhysicsReg("a6"));
    regMap.put("a7", new PhysicsReg("a7"));
  }
//  static {
//
//  }

  public static PhysicsReg get(String name) {
    return regMap.get(name);
  }
}