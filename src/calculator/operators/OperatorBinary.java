package calculator.operators;
import tree.Operator;

public class OperatorBinary extends Operator {
    public static final OperatorBinary ADD = new OperatorBinary("+", "add", 1);
    public static final OperatorBinary SUBS = new OperatorBinary("-", "substract", 1);
    public static final OperatorBinary MUL = new OperatorBinary("*", "mul", 2);
    public static final OperatorBinary DIV = new OperatorBinary("/", "div", 2);
    
    private OperatorBinary(String info, String name, int order) {
        super(info, name, order);
    }
}