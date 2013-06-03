package testcalculator;

import calculator.constants.Constant;
import calculator.operators.OperatorBinary;
import junit.framework.Assert;
import operators.Binary;
import org.junit.Test;
import tree.Tree;
import types.Double;

public class TestCalculators {

    private Tree result;

    @Test
    public void doubleDoubleAdd() {
        result = new Binary(new Constant(new Double(2.0)), new Constant(new Double(1.0)), OperatorBinary.ADD);
        Assert.assertEquals(3.0, result.evaluate().getValue());
    }

    @Test
    public void doubleDoubleSubstract() {
        result = new Binary(new Constant(new Double(1.0)), new Constant(new Double(2.0)), OperatorBinary.SUBS);
        Assert.assertEquals(-1.0, result.evaluate().getValue());
    }

    @Test
    public void doubleDoubleMultiply() {
        result = new Binary(new Constant(new Double(2.0)), new Constant(new Double(0.0)), OperatorBinary.MUL);
        Assert.assertEquals(0.0, result.evaluate().getValue());
    }

    @Test
    public void doubleDoubleDivide() {
        result = new Binary(new Constant(new Double(5.0)), new Constant(new Double(1.0)), OperatorBinary.DIV);
        Assert.assertEquals(5.0, result.evaluate().getValue());
    }

    @Test
    public void integerDoubleAdd() {
        result = new Binary(new Constant(new types.Integer(2)), new Constant(new Double(1.0)), OperatorBinary.ADD);
        Assert.assertEquals(3.0, result.evaluate().getValue());
    }

    @Test
    public void integerDoubleSubstract() {
        result = new Binary(new Constant(new types.Integer(1)), new Constant(new Double(2.0)), OperatorBinary.SUBS);
        Assert.assertEquals(-1.0, result.evaluate().getValue());
    }

    @Test
    public void DoubleIntegerMultiply() {
        result = new Binary(new Constant(new Double(2.0)), new Constant(new types.Integer(0)), OperatorBinary.MUL);
        Assert.assertEquals(0.0, result.evaluate().getValue());
    }

    @Test
    public void integerintegerDivide() {
        result = new Binary(new Constant(new types.Integer(5)), new Constant(new types.Integer(1)), OperatorBinary.DIV);
        Assert.assertEquals(5, result.evaluate().getValue());
    }

}
