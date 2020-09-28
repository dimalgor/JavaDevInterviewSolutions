package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathSolutionsTest {

    MathSolutions mathSolutions = new MathSolutions();
    @Test
    void calculateSqrt() {
        assertEquals(3, mathSolutions.calculateSqrt(9));
        assertEquals(2, mathSolutions.calculateSqrt(4));
        assertEquals(2, mathSolutions.calculateSqrt(5));
        assertEquals(3, mathSolutions.calculateSqrt(11));
    }
}