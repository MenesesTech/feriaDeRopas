
package com.mycompany.presupuestoferias.ejercicios;
import java.util.Scanner;

public class PostFija {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la expresión infija: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = convertToPostfix(infixExpression);

        System.out.println("Expresión postfija: " + postfixExpression);
    }

    public static String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.append(c);
            } else if (c == ')') {
                while (stack.length() > 0 && stack.charAt(stack.length() - 1) != '(') {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }

                if (stack.length() > 0 && stack.charAt(stack.length() - 1) != '(') {
                    throw new IllegalArgumentException("Expresión inválida");
                }

                stack.deleteCharAt(stack.length() - 1);
            } else {
                while (stack.length() > 0 && precedence(c) <= precedence(stack.charAt(stack.length() - 1))) {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }

                stack.append(c);
            }

            System.out.println("Paso " + (i + 1) + ":");
            System.out.println("Expresión postfija: " + postfix.toString());
            System.out.println("Pila: " + stack.toString());
            System.out.println("-------------------------------------------------------------------------");
        }

        while (stack.length() > 0) {
            if (stack.charAt(stack.length() - 1) == '(') {
                throw new IllegalArgumentException("Expresión inválida");
            }

            postfix.append(stack.charAt(stack.length() - 1));
            stack.deleteCharAt(stack.length() - 1);
        }

        System.out.println("Resultado final:");
        System.out.println("Expresión postfija: " + postfix.toString());
        System.out.println("Pila: " + stack.toString());
        System.out.println("-------------------------------------------------------------------------");

        return postfix.toString();
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }

        return -1;
    }
}
