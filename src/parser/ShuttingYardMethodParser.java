package parser;

import tree.Tree;
import tree.Type;
import java.util.*;

public class ShuttingYardMethodParser extends Tree {


    private static final int LEFT_ASSOC = 0;
    private static final int RIGHT_ASSOC = 1;

 
    private static final Map<String, int[]> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put("+", new int[]{0, LEFT_ASSOC});
        OPERATORS.put("-", new int[]{0, LEFT_ASSOC});
        OPERATORS.put("*", new int[]{5, LEFT_ASSOC});
        OPERATORS.put("/", new int[]{5, LEFT_ASSOC});
    }
  
    private static boolean isOperator(String token) {
        return OPERATORS.containsKey(token);
    }

    private static boolean isAssociative(String token, int type) {
        ifNotIsOperator(token);
        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }
 
    private static final int cmpPrecedence(String token1, String token2) {
        isNotAreOperator(token1, token2);
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    public static String[] infixToRPN(String[] inputTokens) {
        ArrayList<String> out = CaptureOut(inputTokens);
        String[] output = new String[out.size()];
        return out.toArray(output);
    }

    public static double RPNtoDouble(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        tourStringVerific(tokens, stack);
        return Double.valueOf(stack.pop());
    }

    public static void tourString(Stack<String> stack, String token, ArrayList<String> out) {
        // While stack not empty AND stack top element   
        // is an operator  
        while (!stack.empty() && isOperator(stack.peek())) {
            if (isAssociativeTrue(token, stack, out)) continue;
            break;
        }
    }

    public static void result(Stack<String> stack, String token) throws NumberFormatException {
        Double d2 = Double.valueOf(stack.pop());
        Double d1 = Double.valueOf(stack.pop());
        Double result = resultOperatorExpresion(token, d1, d2);
        stack.push(String.valueOf(result));
    }

    public static boolean isAssociativeTrue(String token, Stack<String> stack, ArrayList<String> out) {
        if ((isAssociative(token, LEFT_ASSOC)
                && cmpPrecedence(token, stack.peek()) <= 0)
                || (isAssociative(token, RIGHT_ASSOC)
                && cmpPrecedence(token, stack.peek()) < 0)) {
            out.add(stack.pop());
            return true;
        }
        return false;
    }

    private static void ifNotIsOperator(String token) throws IllegalArgumentException {
        if (!isOperator(token)) {
            throw new IllegalArgumentException("Invalid token: " + token);
        }
    }

    private static void isNotAreOperator(String token1, String token2) throws IllegalArgumentException {
        if (!isOperator(token1) || !isOperator(token2)) {
            throw new IllegalArgumentException("Invalid tokens: " + token1
                    + " " + token2);
        }
    }

    private static void tourStringVerific(String[] tokens, Stack<String> stack) throws NumberFormatException {
        for (String token : tokens)  verificIsoperatorpila(token, stack);              
    }

    private static void touraddString(Stack<String> stack, ArrayList<String> out) {
        while (!stack.empty()) {
            out.add(stack.pop());
        }
    }

    private static void tourStringexpresion(String[] inputTokens, Stack<String> stack, ArrayList<String> out) {  
        for (String token : inputTokens) {
            if (isOperator(token)) isoperatorenlastring(stack, token, out);           
            else conditionParenthesis(token, stack, out);              
        }
    }

    private static void touraddParenthesis(Stack<String> stack, ArrayList<String> out) {
        while (!stack.empty() && !stack.peek().equals("(")) {
            out.add(stack.pop());
        }
        stack.pop();
    }

    private static void conditionParenthesis(String token, Stack<String> stack, ArrayList<String> out) {
        if (token.equals("(")) stack.push(token);     
        else if (token.equals(")")) {touraddParenthesis(stack, out);} 
        else out.add(token);
    }

    private static void isoperatorenlastring(Stack<String> stack, String token, ArrayList<String> out) {
        tourString(stack, token, out);              
        stack.push(token);
    }

    private static void verificIsoperatorpila(String token, Stack<String> stack) throws NumberFormatException {
        if (!isOperator(token)) stack.push(token);
        else result(stack, token);
    }

    private static Double resultOperatorExpresion(String token, Double d1, Double d2) {
        Double result = token.compareTo("+") == 0 ? d1 + d2
                : token.compareTo("-") == 0 ? d1 - d2
                : token.compareTo("*") == 0 ? d1 * d2
                : d1 / d2;
        return result;
    }

    private static ArrayList<String> CaptureOut(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        tourStringexpresion(inputTokens, stack, out);
        touraddString(stack, out);
        return out;
    }
    
    @Override
    public Type evaluate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}




