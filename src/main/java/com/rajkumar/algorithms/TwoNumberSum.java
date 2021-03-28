package com.rajkumar.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * From the array of distinct integers find the 2 numbers which matches the
 * expected sum <br />
 * <ul>
 * <li>The result numbers can be in any order</li>
 * <li>If no two number matches the expected sum, the empty array should be
 * returned</li>
 * <li>The number should not be added itself to reach the sum</li>
 * </ul>
 * 
 * <p>
 * The functions defined here can be executed through unit tests defined or jmh
 * performance
 * </p>
 * 
 * @author Rajkumar. S
 *
 */
public class TwoNumberSum {
    
    /**
     * Brute force solution with 2 inner loops <br/>
     * If both loop has same indices, then ignore. <br/>
     * <br/>
     * Time Complexity: O(N^2) - Since iterating twice <br/>
     * Space Complexity: O(1) - Since new array will be containing 2 numbers
     * 
     * @param input       Given numbers array
     * @param expectedSum the expected sum
     * @return if any two numbers matches the expected sum return those 2 numbers
     *         else empty array
     */
    public static Integer[] bruteForceSolution1(Integer[] input, int expectedSum) {
        
        int inputArrayLength = input.length;
        for (int i = 0; i < inputArrayLength; i++) {
            for (int j = 0; j < inputArrayLength; j++) {
                if (i == j) {
                    continue;
                }
                
                if (input[i] + input[j] == expectedSum) {
                    return new Integer[] { input[i], input[j] };
                }
            }
        }
        return new Integer[0];
    }
    
    /**
     * Brute force solution with 2 inner loops <br/>
     * This solution is similar to the above but inner loop will be checked from the
     * next element <br/>
     * The operations performed will be less <br/>
     * <br/>
     * Time Complexity: O(N^2) - Since iterating twice <br/>
     * Space Complexity: O(1) - Since new array will be containing 2 numbers
     * 
     * @param input       Given numbers array
     * @param expectedSum the expected sum
     * @return if any two numbers matches the expected sum return those 2 numbers
     *         else empty array
     */
    public static Integer[] bruteForceSolution2(Integer[] input, int expectedSum) {
        
        int inputArrayLength = input.length;
        for (int i = 0; i < inputArrayLength - 1; i++) {
            for (int j = i + 1; j < inputArrayLength; j++) {
                if (input[i] + input[j] == expectedSum) {
                    return new Integer[] { input[i], input[j] };
                }
            }
        }
        return new Integer[0];
    }
    
    /**
     * Subtract the current element from target sum and see whether the number exist
     * or not <br/>
     * This solution is better than earlier since the loops will be running twice
     * <br/>
     * <ul>
     * <li>Whether subtracted element present in the list or not</li>
     * <li>This will be performed for all the elements index</li>
     * </ul>
     * Time Complexity: O(N^2) - Though iterating twice only, the operations
     * performed are in inner loop <br/>
     * Space Complexity: O(1) - Since new array will be containing 2 numbers <br/>
     * <br/>
     * 
     * @param input       Given numbers array
     * @param expectedSum the expected sum
     * @return if any two numbers matches the expected sum return those 2 numbers
     *         else empty array
     */
    public static Integer[] findingDifferenceBruteForceSolution3(Integer[] input, int expectedSum) {
        
        int inputArrayLength = input.length;
        for (int i = 0; i < inputArrayLength - 1; i++) {
            Integer subtractedResult = expectedSum - input[i];
            for (int j = i + 1; j < inputArrayLength; j++) {
                if (subtractedResult.equals(input[j])) {
                    return new Integer[] { input[i], input[j] };
                }
            }
        }
        return new Integer[0];
    }
    
    /**
     * Subtract the current element from target sum and see whether the number exist
     * or not from the saved values <br/>
     * This solution is better than earlier <br/>
     * <br/>
     * Time Complexity: O(N) - To check all elements <br/>
     * Space Complexity: O(N) - Saving in memory
     * 
     * @param input       Given numbers array
     * @param expectedSum the expected sum
     * @return if any two numbers matches the expected sum return those 2 numbers
     *         else empty array
     */
    public static Integer[] findingDifferenceSolution4(Integer[] input, int expectedSum) {
        
        Set<Integer> containsMap = new HashSet<>();
        for (Integer currentNum : input) {
            Integer subtractedResult = expectedSum - currentNum;
            if (containsMap.contains(subtractedResult)) {
                return new Integer[] { subtractedResult, currentNum };
            }
            containsMap.add(currentNum);
        }
        return new Integer[0];
    }
    
    /**
     * This solution consumes more time than previous but space will much less<br/>
     * Following steps should be performed
     * <ol>
     * <li>Sort the elements</li>
     * <li>Maintain 2 cursors which should reside at leftmost and rightmost</li>
     * <li>Add both cursors</li>
     * <li>If result is higher, then move right cursor to left(i.e to the previous
     * element)</li>
     * <li>If result is lower, then move left cursor to right(i.e to the next
     * element)</li>
     * <li>Continue this until expected sum matches or left equals to right</li>
     * </ol>
     * <br/>
     * Time Complexity: O(NLogN) - Sorting elements <br/>
     * Space Complexity: O(1) - Only result is stored
     * 
     * @param input       Given numbers array
     * @param expectedSum the expected sum
     * @return if any two numbers matches the expected sum return those 2 numbers
     *         else empty array
     */
    public static Integer[] byCursorMovement(Integer[] input, int expectedSum) {
        Arrays.sort(input);
        
        int leftCursorPosition = 0;
        int rightCursorPosition = input.length - 1;
        
        while (leftCursorPosition != rightCursorPosition) {
            Integer result = input[leftCursorPosition] + input[rightCursorPosition];
            if (result.equals(expectedSum)) {
                return new Integer[] { input[leftCursorPosition], input[rightCursorPosition] };
            }
            
            if (result > expectedSum) {
                rightCursorPosition--;
            } else {
                leftCursorPosition++;
            }
        }
        return new Integer[0];
    }
    
}
