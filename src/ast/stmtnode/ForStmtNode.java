package src.ast.stmtnode;

import src.MXIR.IRBasicBlock;
import src.ast.*;
import src.ast.ExprNode;
import src.ast.StmtNode;
import src.ast.othernode.VarDefNode;
import src.util.*;

import java.util.ArrayList;

public class ForStmtNode extends LoopStmtNode {
  public VarDefNode varDef;
  public ExprNode init, step;
  public IRBasicBlock stepBlock;

  public Node getVarDefNode(){
    if(varDef!=null){
      return varDef;
    }
    return null;
  }

  public int model(){
    if(varDef==null){
      return 0;
      //0表示定义了新变量
    }
    return 1;
    //1表示未定义新变量
  }
  public ForStmtNode(Position pos) {
    super(pos);
  }

  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}