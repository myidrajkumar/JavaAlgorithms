package com.java.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is to test NonConstructibleChange problem <br/>
 * Please view respective class to understand the feature
 * 
 * @author Rajkumar. S
 *
 */
class NonConstructibleChangeTest {
    
    @Test
    void testBruteForceSolution1_NormalCase() {
        int[] input = { 1, 2, 5 };
        int expectedMinChangecannotBeCreated = 4;
        
        int minChangecannotBeCreated = NonConstructibleChange.bruteForceSolution1(input);
        Assertions.assertEquals(expectedMinChangecannotBeCreated, minChangecannotBeCreated,
                "The result is not matching");
    }
    
    @Test
    void testOptimalSolution1_NormalCase() {
        int[] input = { 1, 2, 5 };
        int expectedMinChangecannotBeCreated = 4;
        
        int minChangecannotBeCreated = NonConstructibleChange.optimalSolution1(input);
        Assertions.assertEquals(expectedMinChangecannotBeCreated, minChangecannotBeCreated,
                "The result is not matching");
        
        input = new int[] { 5, 7, 1, 1, 2, 3, 22 };
        expectedMinChangecannotBeCreated = 20;
        
        minChangecannotBeCreated = NonConstructibleChange.optimalSolution1(input);
        Assertions.assertEquals(expectedMinChangecannotBeCreated, minChangecannotBeCreated,
                "The result is not matching");
    }
}
