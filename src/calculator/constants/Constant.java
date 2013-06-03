package calculator.constants;

import tree.Tree;
import tree.Type;

public class Constant extends Tree {
    private final Type<?> value;

    private String capturesValueString(){
        return value.getValue().toString();
    }
    
    public Constant(Type<?> value) {
        this.value = value;
    }

    @Override
    public Type<?> evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return capturesValueString();
    }
}
