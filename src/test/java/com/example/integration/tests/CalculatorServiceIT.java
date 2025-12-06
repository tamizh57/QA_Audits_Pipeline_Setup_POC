package com.example.integration.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.Calculator;
import com.example.CalculatorService;
import org.junit.jupiter.api.Test;

class CalculatorServiceIT {
  // Use the real Calculator and CalculatorService
  CalculatorService service = new CalculatorService(new Calculator());

  @Test
  void testAddition() {
    assertEquals(10, service.calculate("+", 7, 3));
  }

  @Test
  void testDivisionByZeroThrows() {
    assertThrows(IllegalArgumentException.class, () -> service.calculate("/", 8, 0));
  }
}
