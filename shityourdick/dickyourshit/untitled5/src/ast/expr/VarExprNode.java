package src.ast.expr;

import src.ast.*;
import src.ast.stmt.*;
import src.utils.*;

public class VarExprNode extends AtomExprNode {
  public VarExprNode(Position pos, String str) {
    super(pos, str);
  }


  @Override
  public boolean isLeftValue() {
    return true;
  }
  
  @Override
  public void accept(ASTVisitor visitor) {
    visitor.visit(this);
  }
}
