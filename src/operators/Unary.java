package operators;

import calculators.calculators.Calculate;
import tree.Operation;
import tree.Operator;
import tree.Tree;
import tree.Type;

public class Unary extends Operation {
 
    private Calculate calculatorEvaluator = new Calculate();
    private final Operator unary;
    private final Tree info;

    public Unary(Operator unary, Tree info) {
        this.unary = unary;
        this.info = info;
    }

    public Tree getInfo() {
        return info;
    }
    
    public Operator getOperator() {
        return unary;
    }

    @Override
    public Type evaluate() {
        return calculatorEvaluator.captureType(unary, new Type[]{info.evaluate()});
    }

    @Override
    public String toString() {
        return info.toString() + unary.captureInfo();
    }
}
