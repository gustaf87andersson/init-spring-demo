package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExampleTests {

    Calculator sut;

    @BeforeEach
    void initTests(){
        sut = new Calculator();
    }

    @Test
    void Calculator_add_success(){
        // ARRANGE
        var a = 10;
        var b = 25;

        // ACT
        var result = sut.add(a, b);

        // ASSERT
        assertEquals(35, result);
    }

    @Test
    void Calculator_multiply_success(){
        // ARRANGE
        var a = 10;
        var b = 6;

        // ACT
        var result = sut.multiply(a, b);

        // ASSERT
        assertEquals(60, result);
    }

    @Test
    void Calculator_divide_success() {
        // ARRANGE
        var a = 40;
        var b = 5;

        // ACT
        var result = sut.divide(a, b);

        // ASSERT
        assertEquals(8, result);
    }

    @Test
    void Calculator_divide_ShouldThrowExceptionOnZero(){
        // ARRANGE
        var a = 100;
        var b = 0;

        // ACT
        Exception ex = assertThrows(ArithmeticException.class, () -> {
            sut.divide(a, b);
        });

        // ASSERT
        assertTrue(ex.getMessage().contains("/ by zero"));
    }
}


class Calculator{
    public int add(int a, int b){
        return a + b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double divide(int a, int b){
        return a / b;    
    }
}
