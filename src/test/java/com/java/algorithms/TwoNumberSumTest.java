package com.java.algorithms;

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
        int targetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.bruteForceSolution1(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution1_IntegerCacheCase() {
        Integer[] input = { 400, 200, 300, 800, 700, 100, 900, 1200, 600, 1400 };
        int targetSum = 1500;
        
        Integer[] expectedResult = { 300, 1200 };
        
        Integer[] result = TwoNumberSum.bruteForceSolution1(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution2_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.bruteForceSolution2(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testFindingDifferenceBruteForceSolution3_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.findingDifferenceBruteForceSolution3(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testFindingDifferenceSolution4_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;
        
        Integer[] expectedResult = { 11, -1 };
        
        Integer[] result = TwoNumberSum.findingDifferenceSolution4(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
    
    @Test
    void testByCursorMovement_NormalCase() {
        Integer[] input = { 3, 5, -4, 8, 11, 1, -1, 6 };
        int targetSum = 10;
        
        Integer[] expectedResult = { -1, 11 }; // Since the input is sorted
        
        Integer[] result = TwoNumberSum.byCursorMovement(input, targetSum);
        Assertions.assertArrayEquals(expectedResult, result, "The result is not matching");
    }
}
