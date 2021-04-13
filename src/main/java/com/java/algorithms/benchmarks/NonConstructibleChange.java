package com.java.algorithms.benchmarks;

import java.util.concurrent.TimeUnit;

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
public class NonConstructibleChange {
    
    private static int[] input = { 1, 1, 2, 4, 1, 2362, 1200, 3, 2, 5, 8, 6, 3, 278, 301, 124, 7, 10, 11, 9, 7, 9, 10,
            20, 15, 31, 23, 5294, 28, 25, 6000, 300, 200, 4, 810, 777, 231, 78, 99, 378, 745, 450, 325, 123, 451, 754,
            981, 612, 210, 220, 17, 400, 981, 19, 781, 453, 302, 405, 8, 9, 12, 78, 56, 77, 887, 111, 2023, 4114, 6078,
            9, 8, 7, 13, 14, 1, 8, 9, 10, 2013, 8019, 20000, 12000, 23000, 34000, 12345, 23451, 78910, 67543 };
    
    @Benchmark
    public int findTheBruteForceSolution1() {
        return com.java.algorithms.NonConstructibleChange.bruteForceSolution1(input);
    }
    
    @Benchmark
    public int findTheBruteForceSolution2() {
        return com.java.algorithms.NonConstructibleChange.optimalSolution1(input);
    }
    
    public static void main(String[] args) throws RunnerException {
        
        Options opts = new OptionsBuilder().include("NonConstructibleChange").warmupIterations(5)
                .warmupTime(TimeValue.seconds(1)).measurementIterations(5).measurementTime(TimeValue.seconds(1))
                .mode(Mode.AverageTime).forks(3).build();
        
        new Runner(opts).run();
    }
    
}
