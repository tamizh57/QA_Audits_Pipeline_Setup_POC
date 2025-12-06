package com.example.unit.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.Calculator;
import org.junit.jupiter.api.Test;

/** Unit tests to test Calculator class */
public class CalculatorTest {
  private final Calculator calculator = new Calculator();

  /** Test add functionality */
  @Test
  public void testAdd() {
    assertEquals(5, calculator.add(3, 2));
  }

  /** Test subtract functionality */
  @Test
  public void testSubtract() {
    assertEquals(1, calculator.subtract(3, 2));
  }

  /** Test multiply functionality */
  @Test
  public void testMultiply() {
    assertEquals(6, calculator.multiply(2, 3));
  }

  /** Test divide functionality */
  @Test
  public void testDivide() {
    assertEquals(2, calculator.divide(6, 3));
  }

  /** Test divide by 0 exception */
  @Test
  public void testDivideByZero() {
    assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
  }
}
