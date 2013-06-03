package parser;

import tree.Tree;
import tree.Type;

public class ParserTreeToString extends Tree{
    
    private Tree tree;

    public ParserTreeToString(Tree tree){
        this.tree = tree;
    }
    
    public Object getValue(){
        return evaluate().getValue();
    }
    
    @Override
    public Type evaluate() {
        return tree.evaluate();
    }

    @Override
    public String toString() {
        return tree.toString();
    }
    
}