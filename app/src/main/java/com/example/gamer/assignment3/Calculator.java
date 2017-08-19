package com.example.gamer.assignment3;

public class Calculator {
    // Available operations
    public enum Operator {ADD, SUB, DIV, MUL, POW}

    /**
     * Addition operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtract operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divide operation
     */
    public double div(double firstOperand, double secondOperand) {
        if (secondOperand == 0 ) {
            throw new IllegalArgumentException("You cannot divide by zero");
        }
        return firstOperand / secondOperand;
    }

    /**
     * Multiply operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    /**
     * Power operation
     */
    public double pow (double firstOperand, double secondOperand) {
        if(firstOperand ==0 && secondOperand<0){throw new  ArithmeticException ("Infinite Value");}
        if(firstOperand ==-0 && secondOperand<0){throw new  ArithmeticException ("Infinite Value");}
        return  Math.pow(firstOperand,  secondOperand);
    }
}