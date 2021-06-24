package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(s -> System.out.println(s));
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }
}
