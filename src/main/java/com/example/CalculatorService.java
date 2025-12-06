package com.example;

/** Creates a CalculatorService using the provided Calculator. */
public class CalculatorService {
  private final Calculator calculator;

  public CalculatorService(Calculator calculator) {
    this.calculator = calculator;
  }

  /** Calculates the result of an operation with two operands. */
  public int calculate(String op, int a, int b) {
    switch (op) {
      case "+":
        return calculator.add(a, b);
      case "-":
        return calculator.subtract(a, b);
      case "*":
        return calculator.multiply(a, b);
      case "/":
        return calculator.divide(a, b);
      default:
        throw new IllegalArgumentException("Unknown operation " + op);
    }
  }
}
