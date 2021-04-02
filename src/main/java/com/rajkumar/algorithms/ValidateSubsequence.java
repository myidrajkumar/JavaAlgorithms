/**
 * 
 */
package com.rajkumar.algorithms;

/**
 * Identify whether second array is a subsequence of the first array <br />
 * <ul>
 * <li>The subsequence are not necessarily adjacent but has to appear in the
 * same order as first</li>
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
public class ValidateSubsequence {
    
    private ValidateSubsequence() {
        throw new IllegalStateException("Utility Class");
    }
    
    /**
     * Iterate the subsequence and identify the index in the sequence array from the
     * last index. <br/>
     * If the index appears in incremental, then this is valid; else not. <br/>
     * <br/>
     * Time Complexity: O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * Space Complexity: O(1) - Just result
     * 
     * @param sequence    Main array which contains all numbers
     * @param subSequence The second array which needs to be check for existence
     * 
     * @return true if exist else false
     */
    public static boolean bruteForceSolution1(Integer[] sequence, Integer[] subSequence) {
        int index = -1; // Setting the initial index
        for (Integer subSequenceValue : subSequence) {
            boolean found = false;
            for (int i = index + 1; i < sequence.length; i++) {
                if (subSequenceValue == sequence[i]) {  // NOSONAR
                    index = i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * This solution is same as earlier. <br/>
     * Due to Integer cache, the above solution is wrong which is fixed here <br/>
     * <br/>
     * Time Complexity: O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * Space Complexity: O(1) - Just result
     * 
     * @param sequence    Main array which contains all numbers
     * @param subSequence The second array which needs to be check for existence
     * 
     * @return true if exist else false
     */
    public static boolean bruteForceSolution2(Integer[] sequence, Integer[] subSequence) {
        int index = -1; // Setting the initial index
        for (Integer subSequenceValue : subSequence) {
            boolean found = false;
            for (int i = index + 1; i < sequence.length; i++) {
                if (subSequenceValue.equals(sequence[i])) {
                    index = i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
