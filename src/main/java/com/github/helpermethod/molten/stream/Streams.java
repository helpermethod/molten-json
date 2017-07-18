package com.github.helpermethod.molten.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Streams {
    private Streams() {
    }

    public static Stream<Boolean> ofAll(boolean[] values) {
        return range(0, values.length).mapToObj(i -> values[i]);
    }

    public static Stream<Double> ofAll(double[] values) {
        return stream(values).boxed();
    }
}
