package com.theironyard;

public class ReversePolishCalc {

    private int topOfStack = 0;

    private String[] tokens;

    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");

        stack = new String [tokens.length];

        for(int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                double number1 = pop();
                double number2 = pop();
                switch (tokens[i]) {
                    case "+":
                        push(number1 + number2);
                        break;
                    case "-":
                        push(number2 - number1);
                        break;
                    case "*":
                        push(number1 * number2);
                        break;
                    case "/":
                        push(number2 / number1);
                }
            } else {
                push(tokens[i]);
            }
        }
        return pop();
    }

    private void push(String number) {
        stack[topOfStack] = number;
        topOfStack += 1;
    }

    private void push(double d) {
        String temp = Double.toString(d);
        stack[topOfStack] = temp;
        topOfStack += 1;
    }

    private double pop() {
        double result = Double.parseDouble(stack[topOfStack - 1]);
        topOfStack -= 1;
        return result;
    }
}