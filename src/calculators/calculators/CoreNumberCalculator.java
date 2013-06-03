package calculators.calculators;

import calculators.annotations.Constant;
import calculators.annotations.Function;
import calculators.annotations.Operation;
import types.Double;
import types.Integer;

public class CoreNumberCalculator implements Calculator {

    public CoreNumberCalculator() {
    }
    @Constant
    public static final double PI = Math.PI;
    @Constant
    public static final double E = Math.E;

    @Operation("+")
    public static Double add(Double operand1, Double operand2) {
        return new Double(operand1.getValue() + operand2.getValue());
    }

    @Operation("+")
    public static Double add(Double operand1, Integer operand2) {
        return new Double(operand1.getValue() + operand2.getValue());
    }

    @Operation("+")
    public static Double add(Integer operand1, Double operand2) {
        return new Double(operand1.getValue() + operand2.getValue());
    }

    @Operation("+")
    public static Integer add(Integer operand1, Integer operand2) {
        return new Integer(operand1.getValue() + operand2.getValue());
    }

    @Operation("-")
    public static Double substract(Double operand1, Double operand2) {
        return new Double(operand1.getValue() - operand2.getValue());
    }

    @Operation("-")
    public static Double substract(Double operand1, Integer operand2) {
        return new Double(operand1.getValue() - operand2.getValue());
    }

    @Operation("-")
    public static Double substract(Integer operand1, Double operand2) {
        return new Double(operand1.getValue() - operand2.getValue());
    }

    @Operation("-")
    public static Integer substract(Integer operand1, Integer operand2) {
        return new Integer(operand1.getValue() - operand2.getValue());
    }

    @Operation("*")
    public static Double mul(Double operand1, Double operand2) {
        return new Double(operand1.getValue() * operand2.getValue());
    }

    @Operation("*")
    public static Double mul(Double operand1, Integer operand2) {
        return new Double(operand1.getValue() * operand2.getValue());
    }

    @Operation("*")
    public static Double mul(Integer operand1, Double operand2) {
        return new Double(operand1.getValue() * operand2.getValue());
    }

    @Operation("*")
    public static Integer mul(Integer operand1, Integer operand2) {
        return new Integer(operand1.getValue() * operand2.getValue());
    }

    @Operation("/")
    public static Double div(Double operand1, Double operand2) {
        return new Double(operand1.getValue() / operand2.getValue());
    }

    @Operation("/")
    public static Double div(Double operand1, Integer operand2) {
        return new Double(operand1.getValue() / operand2.getValue());
    }

    @Operation("/")
    public static Double div(Integer operand1, Double operand2) {
        return new Double(operand1.getValue() / operand2.getValue());
    }

    @Operation("/")
    public static Integer div(Integer operand1, Integer operand2) {
        return new Integer(operand1.getValue() / operand2.getValue());
    }

    @Function
    public static double abs(Double operand) {
        return Math.abs(operand.getValue());
    }

    @Function("sqrt")
    public static double sqrt(Double operand) {
        return Math.sqrt(operand.getValue());
    }

    @Function("sin")
    public static double sin(Double operand) {
        return Math.sin(operand.getValue());
    }

    @Function("cos")
    public static double cos(Double operand) {
        return Math.cos(operand.getValue());
    }

    @Function("tan")
    public static double tan(Double operand) {
        return Math.tan(operand.getValue());
    }

    @Function("sinh")
    public static double sinh(Double operand) {
        return Math.sinh(operand.getValue());
    }

    @Function("cosh")
    public static double cosh(Double operand) {
        return Math.cosh(operand.getValue());
    }

    @Function("tanh")
    public static double tanh(Double operand) {
        return Math.tanh(operand.getValue());
    }
}

