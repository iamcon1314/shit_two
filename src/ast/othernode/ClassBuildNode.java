package src.ast.othernode;

//package ast;

import src.ast.ASTVisitor;
import src.ast.Node;
import src.ast.stmtnode.*;
import src.util.*;
//package src.frontend;
//import grammar;
//package src.ast;
//import grammar;


//import javax.swing.text.Position;
public class ClassBuildNode extends Node {
    public String name;
    public SuiteNode suite;
    public FuncDefNode info;
    public FuncDefNode transToFuncDef() {
        FuncDefNode funcDef = new FuncDefNode(pos, name);
        funcDef.returnType = new TypeNode(pos, "void");
        funcDef.stmtnodes = suite.stmtnodes;
        return info = funcDef;
    }

    public ClassBuildNode(Position pos, String name, SuiteNode suite) {
        super(pos);
        this.name = name;
        this.suite = suite;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
