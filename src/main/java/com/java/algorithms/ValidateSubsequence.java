/**
 * 
 */
package com.java.algorithms;

import java.util.Arrays;
import java.util.List;

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
     * <b>Time Complexity:</b> O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * <b>Space Complexity:</b> O(1) - Just result
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
     * <b>Time Complexity:</b> O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * <b>Space Complexity:</b> O(1) - Just result
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
    
    /**
     * This solution also similar to the above but uses single loop <br/>
     * <ol>
     * <li>Maintain 2 pointers for main sequence and subsequence</li>
     * <li>If matches, increment the pointer for subsequence</li>
     * <li>Always increment the pointer for sequence</li>
     * <li>If identified total subsequence index is equal to subsequence size, then
     * valid</li>
     * </ol>
     * <b>One Issue:</b> In case, even if subsequence is identified early, but the
     * entire array will be looked<br/>
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * <b>Space Complexity:</b> O(1) - Just result
     * 
     * @param sequence    Main array which contains all numbers
     * @param subSequence The second array which needs to be check for existence
     * 
     * @return true if exist else false
     */
    public static boolean bruteForceSolution3(Integer[] sequence, Integer[] subSequence) {
        List<Integer> seqList = Arrays.asList(sequence);
        List<Integer> subSeqList = Arrays.asList(subSequence);
        
        int seqIndex = 0;
        int subSeqIndex = 0;
        
        while (seqIndex < seqList.size() && subSeqIndex < subSeqList.size()) {
            if (seqList.get(seqIndex).equals(subSeqList.get(subSeqIndex))) {
                subSeqIndex++;
            }
            seqIndex++;
        }
        return subSeqIndex == subSeqList.size();
    }
    
    /**
     * This solution also similar to the above but fixes to return early if
     * identified <br/>
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element in the second array will be
     * checked in first array<br/>
     * <b>Space Complexity:</b> O(1) - Just result
     * 
     * @param sequence    Main array which contains all numbers
     * @param subSequence The second array which needs to be check for existence
     * 
     * @return true if exist else false
     */
    public static boolean bruteForceSolution4(Integer[] sequence, Integer[] subSequence) {
        List<Integer> seqList = Arrays.asList(sequence);
        List<Integer> subSeqList = Arrays.asList(subSequence);
        
        int seqIndex = 0;
        for (var value : seqList) {
            if (seqIndex == subSeqList.size()) {
                break;
            }
            
            if (subSeqList.get(seqIndex).equals(value)) {
                seqIndex++;
            }
        }
        return seqIndex == subSeqList.size();
    }
}
