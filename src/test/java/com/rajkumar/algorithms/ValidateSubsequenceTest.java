package com.rajkumar.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is to test ValidateSubsequence problem <br/>
 * Please view respective class to understand the feature
 * 
 * @author Rajkumar. S
 *
 */
class ValidateSubsequenceTest {
    
    @Test
    void testBruteForceSolution1_NormalCase() {
        
        Integer[] sequence = { 1, 2, 3, 4 };
        Integer[] subSequence = { 1, 3, 4 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution1(sequence, subSequence),
                "The result is not matching");
        
        subSequence = new Integer[] { 2, 4 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution1(sequence, subSequence),
                "The result is not matching");
        
        sequence = new Integer[] { 5, 1, 22, 25, 6, -1, 8, 10 };
        subSequence = new Integer[] { 1, 6, -1, 10 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution1(sequence, subSequence),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution1_IntegerCacheCase() {
        
        Integer[] sequence = { 450, 650, 310, 440 };
        Integer[] subSequence = { 450, 310, 440 };
        Assertions.assertFalse(ValidateSubsequence.bruteForceSolution1(sequence, subSequence),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution2_IntegerCacheCase() {
        
        Integer[] sequence = { 450, 650, 310, 440 };
        Integer[] subSequence = { 450, 310, 440 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution2(sequence, subSequence),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution3_NormalCase() {
        
        Integer[] sequence = new Integer[] { 5, 1, 22, 25, 6, -1, 8, 10 };
        Integer[] subSequence = new Integer[] { 1, 6, -1, 10 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution3(sequence, subSequence),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution4_NormalCase() {
        
        Integer[] sequence = new Integer[] { 5, 1, 22, 25, 6, -1, 8, 10 };
        Integer[] subSequence = new Integer[] { 1, 6, -1, 10 };
        Assertions.assertTrue(ValidateSubsequence.bruteForceSolution4(sequence, subSequence),
                "The result is not matching");
    }
}
