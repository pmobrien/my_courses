package com.pmobrien.my_courses.fcc.dynamic_programming.fibonacci;

import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FibonacciTest {

  @ParameterizedTest
  @MethodSource("testFibonacciSource")
  public void testFibonacci(long index, long expected) {
    if (index > 10) {
      Assertions.assertTrue(true); // don't run bigger inputs for this case; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new Fibonacci().fibonacci(index)));
  }

  @ParameterizedTest
  @MethodSource("testFibonacciSource")
  public void testMemoizedFibonacci(long index, long expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new Fibonacci().memoizedFibonacci(index)));
  }

  private static Stream<Arguments> testFibonacciSource() {
    return Stream.of(
        Arguments.of(0, 1),
        Arguments.of(1, 1),
        Arguments.of(2, 1),
        Arguments.of(3, 2),
        Arguments.of(4, 3),
        Arguments.of(5, 5),
        Arguments.of(6, 8),
        Arguments.of(7, 13),
        Arguments.of(50, 12_586_269_025L)
    );
  }
}
