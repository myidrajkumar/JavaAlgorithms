package com.java.algorithms.benchmarks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(3)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class TournamentWinner {
    
    public static void main(String[] args) throws RunnerException {
        
        Options opts = new OptionsBuilder().include("TournamentWinner").warmupIterations(5)
                .warmupTime(TimeValue.seconds(1)).measurementIterations(5).measurementTime(TimeValue.seconds(1))
                .mode(Mode.AverageTime).forks(3).build();
        
        new Runner(opts).run();
    }
    
    private static String[] competitors = { "Java", "HTML", "C#", "Python", "Javascript", "Go", "Scala", "Ruby",
            "Typescript", "Haskell", "JQuery", "ReactJS", "Angular", "Kotlin", "R", "Pascal" };
    
    private static List<List<String>> matchesList = null;
    private static List<Integer> matchWinningStatusList = null;
    static {
        matchesList = new ArrayList<>();
        for (int i = 0; i < competitors.length - 1; i++) {
            for (int j = i + 1; j < competitors.length; j++) {
                matchesList.add(new ArrayList<>(Arrays.asList(competitors[i], competitors[j])));
            }
        }
        
        Random random = new Random();
        matchWinningStatusList = random.ints(matchesList.size(), 0, 2).boxed().collect(Collectors.toList());
    }
    
    @Benchmark
    public String findTheBruteForceSolution1() {
        return com.java.algorithms.TournamentWinner.bruteForceSolution1(matchesList, matchWinningStatusList);
    }
    
    @Benchmark
    public String findTheBruteForceSolution2() {
        return com.java.algorithms.TournamentWinner.bruteForceSolution2(matchesList, matchWinningStatusList);
    }
    
    @Benchmark
    public String findTheBruteForceSolution3() {
        
        return com.java.algorithms.TournamentWinner.bruteForceSolution3(matchesList, matchWinningStatusList);
    }
    
    @Benchmark
    public String findTheBruteForceSolution4() {
        return com.java.algorithms.TournamentWinner.bruteForceSolution4(matchesList, matchWinningStatusList);
    }
    
    @Benchmark
    public String findTheBruteForceSolution5() {
        return com.java.algorithms.TournamentWinner.bruteForceSolution5(matchesList, matchWinningStatusList);
    }
}
