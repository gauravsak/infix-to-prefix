package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefixConverter {

    public static String toPrefix(String infix) {
        String reverseInfix = new StringBuilder(infix).reverse().toString();

        Scanner scanner = new Scanner(reverseInfix);
        scanner.useDelimiter("");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        do {
            String stackTop;
            String currChar = scanner.next();
            switch (currChar) {
                case ")" :
                    stack.push(")");
                    sb.append(")");
                    break;
                case "(" :
                    while (!Objects.equals(stackTop = stack.pop(), ")")) {
                        sb.append(stackTop);
                    }
                    sb.append("( ");
                    break;
                case "+" :
                case "*":
                case "/":
                case "-":
                    while (!Objects.equals(stackTop = stack.peek(), ")") && hasSameOrHigherPrecedenceThen(stackTop, currChar)) {
                        sb.append(stack.pop());
                    }
                    stack.push(currChar);
                    break;
                case " ":
                    break;
                default:
                    sb.append(currChar).append(" ");
                    break;
            }
        } while (!stack.empty() && scanner.hasNext());
        return sb.reverse().toString().trim();
    }

    public static String toPrefixRecursive(String infix) {
        String reverseInfix = new StringBuilder(infix).reverse().toString();
        Stack<String> stack = new Stack<>();
        return toPrefixRecursive(stack, reverseInfix, "");
    }

    private static String toPrefixRecursive(Stack<String> stack, String reverseInfix, String result) {
        Scanner scanner = new Scanner(reverseInfix);
        scanner.useDelimiter("");
        String currChar = scanner.next();
        String stackTop;
        switch (currChar) {
            case ")" :
                stack.push(")");
                result = result + ")";
                break;
            case "(" :
                while (!Objects.equals(stackTop = stack.pop(), ")")) {
                    result = result + stackTop;
                }
                result = result + "( ";
                break;
            case "+" :
            case "*":
            case "/":
            case "-":
                while (!Objects.equals(stackTop = stack.peek(), ")") && hasSameOrHigherPrecedenceThen(stackTop, currChar)) {
                    result = result + stack.pop();
                }
                stack.push(currChar);
                break;
            case " ":
                break;
            default:
                result = result + currChar + " ";
                break;
        }
        if (!stack.empty() && scanner.hasNext()) {
            return toPrefixRecursive(stack, reverseInfix.substring(1), result);
        }
        return new StringBuilder(result).reverse().toString().trim();
    }

    private static boolean hasSameOrHigherPrecedenceThen(String firstOperator, String secondOperator) {
        return preference(firstOperator) >= preference(secondOperator);
    }

    private static int preference(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }
}
