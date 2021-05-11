package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lombok.var;

public class JUnitExampleTests {

    SomeLogicsExample sut;

    @BeforeEach
    void init() {
        sut = new SomeLogicsExample();
    }

    @Test
    void SomeLogicsExample_add_success() {
        // ARRANGE
        var a = 10;
        var b = 20;
        // ACT
        var result = sut.add(a, b);
        // ASSERT
        assertEquals(30, result);
    }

    @Test
    void SomeLogicsExample_divide_success() {
        // ARRANGE
        var a = 20;
        var b = 5;
        // ACT
        var result = sut.divide(a, b);
        // ASSERT
        assertEquals(4, result);
    } 

    @Test
    void SomeLogicsExample_divide_ShouldThrowException() {
        // ARRANGE
        var a = 20;
        var b = 0;

        // ACT
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            sut.divide(a, b);
        });
        
        // ASSERT
        assertTrue(exception.getMessage().contains("/ by zero"));
    }   
}

class SomeLogicsExample {
    public int add(int a, int b){
        return a + b;
    }

    public double divide(int a, int b){
        return a / b;
    }
}
