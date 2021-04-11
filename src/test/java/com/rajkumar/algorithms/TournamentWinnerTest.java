package com.rajkumar.algorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is to test TournamentWinner problem <br/>
 * Please view respective class to understand the feature
 * 
 * @author Rajkumar. S
 *
 */
class TournamentWinnerTest {
    
    @Test
    void testBruteForceSolution1_NormalCase() {
        
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML", "C#"), Arrays.asList("C#", "PYTHON"),
                Arrays.asList("PYTHON", "HTML"));
        List<Integer> result = Arrays.asList(0, 0, 1);
        Assertions.assertEquals("PYTHON", TournamentWinner.bruteForceSolution1(competitions, result),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution2_NormalCase() {
        
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML", "C#"), Arrays.asList("C#", "PYTHON"),
                Arrays.asList("PYTHON", "HTML"));
        List<Integer> result = Arrays.asList(0, 0, 1);
        Assertions.assertEquals("PYTHON", TournamentWinner.bruteForceSolution2(competitions, result),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution3_NormalCase() {
        
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML", "C#"), Arrays.asList("C#", "PYTHON"),
                Arrays.asList("PYTHON", "HTML"));
        List<Integer> result = Arrays.asList(0, 0, 1);
        Assertions.assertEquals("PYTHON", TournamentWinner.bruteForceSolution3(competitions, result),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution4_NormalCase() {
        
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML", "C#"), Arrays.asList("C#", "PYTHON"),
                Arrays.asList("PYTHON", "HTML"));
        List<Integer> result = Arrays.asList(0, 0, 1);
        Assertions.assertEquals("PYTHON", TournamentWinner.bruteForceSolution4(competitions, result),
                "The result is not matching");
    }
    
    @Test
    void testBruteForceSolution5_NormalCase() {
        
        List<List<String>> competitions = Arrays.asList(Arrays.asList("HTML", "C#"), Arrays.asList("C#", "PYTHON"),
                Arrays.asList("PYTHON", "HTML"));
        List<Integer> result = Arrays.asList(0, 0, 1);
        Assertions.assertEquals("PYTHON", TournamentWinner.bruteForceSolution5(competitions, result),
                "The result is not matching");
    }
}
