package org.springpattern.Lesson_14;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialCalculator {
public static BigInteger getFactorial(int f) {
    if (f < 0) {
        throw new IllegalArgumentException("Число должно быть неотрицательным");
    }
    if (f < 2) {
        return BigInteger.valueOf(1);
    }
    else {
        return IntStream.rangeClosed(2, f).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }
}
}
