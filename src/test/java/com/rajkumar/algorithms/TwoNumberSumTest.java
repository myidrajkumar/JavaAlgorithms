package com.rajkumar.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is to test TwoNumberSum problem <br/>
 * Please view respective class to understand the feature
 * 
 * @author Rajkumar. S
 *
 */
class TwoNumberSumTest {
    
    @Test
    void testBruteForceSolution1_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int tagetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.bruteForceSolution1(input, tagetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution2_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int tagetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.bruteForceSolution2(input, tagetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testFindingDifferenceBruteForceSolution3_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int tagetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.findingDifferenceBruteForceSolution3(input, tagetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testFindingDifferenceSolution4_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int tagetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.findingDifferenceSolution4(input, tagetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testByCursorMovement_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int tagetSum = 10;
        
        Integer[] expectedResult = { -1, 11 }; // Since the input is sorted
        
        Integer[] result = TwoNumberSum.byCursorMovement(input, tagetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
}
