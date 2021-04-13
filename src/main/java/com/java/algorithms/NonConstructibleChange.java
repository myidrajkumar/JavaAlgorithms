package com.java.algorithms;

import java.util.Arrays;

/**
 * From the positive integers representing the coins, find the minimum amount of
 * change which cannot be created from the coins <br />
 * <ul>
 * <li>The numbers will be positive</li>
 * <li>The numbers can be duplicated</li>
 * <li>If no numbers, return 1</li>
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
public class NonConstructibleChange {
    
    private NonConstructibleChange() {
        throw new IllegalStateException("Utility Class");
    }
    
    /**
     * Naive solution <br/>
     * Sort the elements first and figure out by adding previous elements <br/>
     * <ol>
     * <li>If no elements, return 1</li>
     * <li>Else sort the elements</li>
     * <li>Initialize minChange as = 0</li>
     * <li>For every number in the input, follow the below
     * <ol type="A">
     * <li>Add the minChange and the number</li>
     * <li>If the added value is equal to minChange + 1, then go the next
     * number</li>
     * <li>Else minChange + 1 is the non constructible change</li>
     * </ol>
     * </li>
     * </ol>
     * 
     * <b>This solution is invalid since if 1 duplicated multiple, then this will
     * not work</b> <br/>
     * </br>
     * <b>Time Complexity:</b> O(NLogN) - Since sorting and may need to look up all
     * elements <br/>
     * <b>Space Complexity:</b> O(1) - Just result
     * 
     * @param input Given numbers coins
     * @return the change which cannot be created from the input
     */
    public static int bruteForceSolution1(int[] input) {
        
        if (input.length == 0) {
            return 1;
        }
        
        Arrays.sort(input);
        
        int minChange = 0;
        for (int eachCoin : input) {
            int sum = minChange + eachCoin;
            if (sum > minChange + 1 && eachCoin != minChange + 1) {
                return minChange + 1;
            }
            minChange += eachCoin;
        }
        
        return minChange + 1;
    }
    
    /**
     * This solution is closer to the above <br/>
     * <b>Time Complexity:</b> O(NLogN) - Since sorting and may need to look up all
     * elements <br/>
     * <b>Space Complexity:</b> O(N) - Just result
     * 
     * @param input Given numbers coins
     * @return the change which cannot be created from the input
     */
    public static int optimalSolution1(int[] input) {
        
        Arrays.sort(input);
        
        int changeCanBeCreated = 0;
        for (int num : input) {
            if (num > changeCanBeCreated + 1) {
                return changeCanBeCreated + 1;
            }
            changeCanBeCreated += num;
        }
        return changeCanBeCreated + 1;
    }
    
}
