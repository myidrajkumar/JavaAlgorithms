/**
 * 
 */
package com.java.algorithms;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Find the tournament winner by using the following rules. <br />
 * 
 * <ol>
 * <li>Each team will compete with all other teams</li>
 * <li>At a time, only 2 teams complete against each other</li>
 * <li>Each match has always one winner and one loser; There will be no tie</li>
 * <li>The winner receives 3 points and the loser gets 0 points</li>
 * <li>The team who has more points is Tournament winner</li>
 * </ol>
 * 
 * <p>
 * The following will be input arguments explanation. <br/>
 * <b>Competitions</b> input array contains each element in the form of
 * [homeTeam, awayTeam]. <br/>
 * <b>Results</b> input array contains each match result. If 'result' is '1',
 * then 'home team' won. If '0', 'away team' won
 * </p>
 * <p>
 * The functions defined here can be executed through unit tests defined or jmh
 * performance
 * </p>
 * 
 * @author Rajkumar. S
 *
 */
public class TournamentWinner {
    
    private TournamentWinner() {
        throw new IllegalStateException("Utility Class");
    }
    
    /**
     * Following is the logic
     * 
     * <ol>
     * <li>Both 'competitions' & 'results' will be having same length</li>
     * <li>For each competition, Read home team and away team and corresponding
     * result</li>
     * <li>If not in the map, add the both elements and assign the points</li>
     * <li>If in the map, increment the value</li>
     * <li>Sort the map based on the value and identify the winner</li>
     * </ol>
     * 
     * <br/>
     * <b>Time Complexity:</b> O(NLogN) - Since each element needs to be checked and
     * to be sorted <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param competitions the teams which participated in each match
     * @param results      each match result
     * 
     * @return the tournament winner
     */
    public static String bruteForceSolution1(List<List<String>> competitions, List<Integer> results) {
        int totalMatchCount = results.size();
        
        Map<String, Integer> totalTeamPoints = new HashMap<>();
        for (int i = 0; i < totalMatchCount; i++) {
            List<String> matchParticipants = competitions.get(i);
            Integer matchResult = results.get(i);
            int winnerIndex;
            int loserIndex;
            if (matchResult == 1) {
                winnerIndex = 0;
                loserIndex = 1;
            } else {
                winnerIndex = 1;
                loserIndex = 0;
            }
            totalTeamPoints.compute(matchParticipants.get(winnerIndex), (key, value) -> value == null ? 3 : value + 3);
            totalTeamPoints.compute(matchParticipants.get(loserIndex), (key, value) -> value == null ? 0 : value + 0);
        }
        
        LinkedHashMap<String, Integer> sortedTeams = totalTeamPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        Entry<String, Integer> winnerTeamEntry = sortedTeams.entrySet().iterator().next();
        return winnerTeamEntry.getKey();
    }
    
    /**
     * This logic is same as earlier but instead of sorting at the end, just looping
     * and finding the max
     * 
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked and
     * from the result it needs to identify the max <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param competitions the teams which participated in each match
     * @param results      each match result
     * 
     * @return the tournament winner
     */
    public static String bruteForceSolution2(List<List<String>> competitions, List<Integer> results) {
        int totalMatchCount = results.size();
        
        Map<String, Integer> totalTeamPoints = new HashMap<>();
        for (int i = 0; i < totalMatchCount; i++) {
            List<String> matchParticipants = competitions.get(i);
            Integer matchResult = results.get(i);
            int winnerIndex;
            int loserIndex;
            if (matchResult == 1) {
                winnerIndex = 0;
                loserIndex = 1;
            } else {
                winnerIndex = 1;
                loserIndex = 0;
            }
            totalTeamPoints.compute(matchParticipants.get(winnerIndex), (key, value) -> value == null ? 3 : value + 3);
            totalTeamPoints.compute(matchParticipants.get(loserIndex), (key, value) -> value == null ? 0 : value + 0);
        }
        
        return totalTeamPoints.entrySet().stream().max((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1)
                .orElse(Map.entry("", 0)).getKey();
        
    }
    
    /**
     * This logic is same as earlier but losing team points will not persisted as it
     * is not needed
     * 
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked and
     * from the result it needs to identify the max <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param competitions the teams which participated in each match
     * @param results      each match result
     * 
     * @return the tournament winner
     */
    public static String bruteForceSolution3(List<List<String>> competitions, List<Integer> results) {
        int totalMatchCount = results.size();
        
        Map<String, Integer> totalTeamPoints = new HashMap<>();
        for (int i = 0; i < totalMatchCount; i++) {
            List<String> matchParticipants = competitions.get(i);
            Integer matchResult = results.get(i);
            int winnerIndex;
            if (matchResult == 1) {
                winnerIndex = 0;
            } else {
                winnerIndex = 1;
            }
            totalTeamPoints.compute(matchParticipants.get(winnerIndex), (key, value) -> value == null ? 3 : value + 3);
        }
        
        return totalTeamPoints.entrySet().stream().max((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1)
                .orElse(Map.entry("", 0)).getKey();
        
    }
    
    /**
     * This logic is same as earlier but removing the unnecessary variable
     * winningIndex
     * 
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked and
     * from the result it needs to identify the max <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param competitions the teams which participated in each match
     * @param results      each match result
     * 
     * @return the tournament winner
     */
    public static String bruteForceSolution4(List<List<String>> competitions, List<Integer> results) {
        int totalMatchCount = results.size();
        
        Map<String, Integer> totalTeamPoints = new HashMap<>();
        for (int i = 0; i < totalMatchCount; i++) {
            List<String> matchParticipants = competitions.get(i);
            totalTeamPoints.compute(matchParticipants.get(results.get(i) == 1 ? 0 : 1),
                    (key, value) -> value == null ? 3 : value + 3);
        }
        
        return totalTeamPoints.entrySet().stream().max((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1)
                .orElse(Map.entry("", 0)).getKey();
        
    }
    
    /**
     * This logic is same as earlier but second looping is avoided by keeping the
     * bestTeam always
     * 
     * <br/>
     * <b>Time Complexity:</b> O(N) - Since each element needs to be checked and
     * from the result it needs to identify the max <br/>
     * <b>Space Complexity:</b> O(N) - Since each element need to be persisted
     * 
     * @param competitions the teams which participated in each match
     * @param results      each match result
     * 
     * @return the tournament winner
     */
    public static String bruteForceSolution5(List<List<String>> competitions, List<Integer> results) {
        int totalMatchCount = results.size();
        
        Map<String, Integer> totalTeamPoints = new HashMap<>();
        totalTeamPoints.put("", 0);
        String bestTeam = "";
        for (int i = 0; i < totalMatchCount; i++) {
            List<String> matchParticipants = competitions.get(i);
            totalTeamPoints.compute(matchParticipants.get(results.get(i) == 1 ? 0 : 1),
                    (key, value) -> value == null ? 3 : value + 3);
            if (totalTeamPoints.get(bestTeam) < totalTeamPoints
                    .get(matchParticipants.get(results.get(i) == 1 ? 0 : 1))) {
                bestTeam = matchParticipants.get(results.get(i) == 1 ? 0 : 1);
            }
        }
        
        return bestTeam;
        
    }
    
}
