package src.ast.othernode;

import src.MXIR.IRFunction;
import src.ast.ASTVisitor;
import src.ast.Node;
import src.ast.StmtNode;
import src.util.*;
//package src.frontend;
//import grammar;
//package src.ast;
//import grammar;
//import javax.swing.text.Position;
import java.util.ArrayList;

public class FuncDefNode extends Node {
    public TypeNode returnType;
    public String name,className=null;
    public ParameterListNode params=null;
    public ArrayList<StmtNode> stmtnodes = new ArrayList<StmtNode>();
    public IRFunction irFunc = null;
    public FuncDefNode(Position pos, String name) {
        super(pos);
        this.name = name;
    }
    public FuncDefNode(Position pos, Type type, String name, String className, Type paramType, int cnt) {
        super(pos);
        this.returnType = new TypeNode(pos, type.typeName, type.dimension);
        this.name = name;
        this.className = className;
        if (paramType != null && cnt > 0)
            this.params = new ParameterListNode(pos, paramType, cnt);
    }
    public FuncDefNode(Position pos, Type type, String name, Type paramType, int cnt) {
        super(pos);
        this.returnType = new TypeNode(pos, type.typeName, type.dimension);
        this.name = name;
        if (paramType != null && cnt > 0) {
            this.params = new ParameterListNode(pos, paramType, cnt);
        }
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
