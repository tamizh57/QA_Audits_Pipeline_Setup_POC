package com.example.unit.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.Calculator;
import com.example.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
  private Calculator calculator;
  private CalculatorService service;

  @BeforeEach
  public void setUp() {
    calculator = mock(Calculator.class);
    service = new CalculatorService(calculator);
  }

  @Test
  public void testCalculateAddService() {
    when(calculator.add(2, 3)).thenReturn(5); // weird value just to prove it's a mock
    int result = service.calculate("+", 2, 3);
    assertEquals(5, result);
    verify(calculator).add(2, 3);
  }

  @Test
  public void testCalculateSubtractService() {
    when(calculator.subtract(3, 2)).thenReturn(1); // weird value just to prove it's a mock
    int result = service.calculate("-", 3, 2);
    assertEquals(1, result);
    verify(calculator).subtract(3, 2);
  }

  @Test
  public void testCalculateMultiplyService() {
    when(calculator.multiply(2, 3)).thenReturn(6); // weird value just to prove it's a mock
    int result = service.calculate("*", 2, 3);
    assertEquals(6, result);
    verify(calculator).multiply(2, 3);
  }

  @Test
  public void testCalculateDivideService() {
    when(calculator.divide(6, 3)).thenReturn(2); // weird value just to prove it's a mock
    int result = service.calculate("/", 6, 3);
    assertEquals(2, result);
    verify(calculator).divide(6, 3);
  }

  @Test
  public void testCalculateDivideByZero() {
    when(calculator.divide(2, 0)).thenThrow(new IllegalArgumentException("Division by zero!"));
    Exception e = assertThrows(IllegalArgumentException.class, () -> service.calculate("/", 2, 0));
    verify(calculator).divide(2, 0);
  }

  @Test
  public void testUnknownOperationThrows() {
    Exception e = assertThrows(IllegalArgumentException.class, () -> service.calculate("%", 2, 3));
    assertTrue(e.getMessage().contains("Unknown operation "));
    verifyNoInteractions(calculator);
  }
}
