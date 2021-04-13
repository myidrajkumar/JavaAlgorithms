/**
 * 
 */
package com.java.algorithms;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Take the sorted input array and return the squares of sorted input. <br />
 * 
 * <p>
 * The functions defined here can be executed through unit tests defined or jmh
 * performance
 * </p>
 * 
 * @author Rajkumar. S
 *
 */
public class SortedSquaredArray {
    
    private SortedSquaredArray() {
        throw new IllegalStateException("Utility Class");
    }
    
    /**
     * Iterate the array and square the numbers. <br/>
     * Though this solution is straight forward, this is incorrect as the squares of
     * the negative numbers will be positive<br/>
     * <p>
     * <b>This solution is incorrect. Please refer later solutions </b>
     * </p>
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param input Input which numbers to be squared
     * 
     * @return the squared numbers array
     */
    public static Integer[] bruteForceSolution1(Integer[] input) {
        return Stream.of(input).map(eachNum -> eachNum * eachNum).toArray(Integer[]::new);
    }
    
    /**
     * Same solution as above but using primitives. <br/>
     * <p>
     * <b>This solution is incorrect. Please refer later solutions </b>
     * </p>
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked<br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param input Input which numbers to be squared
     * 
     * @return the squared numbers array
     */
    public static int[] bruteForceSolution2(int[] input) {
        return Arrays.stream(input).map(eachNum -> eachNum * eachNum).toArray();
    }
    
    /**
     * Same solution as above but sorting the result. <br/>
     * <br/>
     * <b>Time Complexity:</b> O(NLogN) - Since each element needs to be checked and
     * sorted <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param input Input which numbers to be squared
     * 
     * @return the squared numbers array
     */
    public static int[] bruteForceSolution3(int[] input) {
        return Arrays.stream(input).map(eachNum -> eachNum * eachNum).sorted().toArray();
    }
    
    /**
     * Here we will do the following steps. <br/>
     * <ol>
     * <li>Maintain two pointers of low and high</li>
     * <li>The result filling will happen from the end of the array</li>
     * <li>Identify the absolute value of low and high. Here even negative will give
     * positive value</li>
     * <li>To the largest value, identify the square and fill at end of the
     * array</li>
     * <li>If the largest value is at low, then increment low pointer by 1</li>
     * <li>If the largest value is at high, then decrement high pointer by 1</li>
     * <li>The array filling pointer also should be decremented
     * <li>Continue these steps until low = high. At this stage, this will be the
     * last element to fill
     * </ol>
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param input Input which numbers to be squared
     * 
     * @return the squared numbers array
     */
    public static int[] optimalSolution(int[] input) {
        int[] result = new int[input.length];
        int low = 0, high = input.length - 1; // NOSONAR
        
        for (int i = input.length - 1; i >= 0; i--) {
            if (Math.abs(input[low]) > Math.abs(input[high])) {
                result[i] = input[low] * input[low];
                low++;
            } else {
                result[i] = input[high] * input[high];
                high--;
            }
            
        }
        return result;
    }
    
}
