package com.rajkumar.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is to test SortedSquaredArray problem <br/>
 * Please view respective class to understand the feature
 * 
 * @author Rajkumar. S
 *
 */
class SortedSquaredArrayTest {
    
    @Test
    void testBruteForceSolution1_NormalCase() {
        
        Integer[] input = { 1, 2, 3, 5, 6, 8, 9 };
        Integer[] expected = { 1, 4, 9, 25, 36, 64, 81 };
        
        Assertions.assertArrayEquals(expected, SortedSquaredArray.bruteForceSolution1(input),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution2_NormalCase() {
        
        int[] input = { 1, 2, 3, 5, 6, 8, 9 };
        int[] expected = { 1, 4, 9, 25, 36, 64, 81 };
        
        Assertions.assertArrayEquals(expected, SortedSquaredArray.bruteForceSolution2(input),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution3_NormalCase() {
        
        int[] input = { -2, 1 };
        int[] expected = { 1, 4 };
        
        Assertions.assertArrayEquals(expected, SortedSquaredArray.bruteForceSolution3(input),
                "The result is not matching");
    }
    
    @Test
    void testOptimalSolution1_NormalCase() {
        
        int[] input = { 1, 2, 3, 5, 6, 8, 9 };
        int[] expected = { 1, 4, 9, 25, 36, 64, 81 };
        
        Assertions.assertArrayEquals(expected, SortedSquaredArray.optimalSolution(input), "The result is not matching");
        
        input = new int[] { -2, 1 };
        expected = new int[] { 1, 4 };
        
        Assertions.assertArrayEquals(expected, SortedSquaredArray.optimalSolution(input), "The result is not matching");
    }
}
