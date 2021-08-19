package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.sum.CanSum;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CanSumTest {

  @ParameterizedTest
  @MethodSource("testCanSumSource")
  public void testCanSum(int targetSum, List<Integer> numbers, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanSum().canSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testCanSumSource")
  public void testMemoizedCanSum(int targetSum, List<Integer> numbers, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanSum().memoizedCanSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testCanSumSource")
  public void testTabulatedCanSum(int targetSum, List<Integer> numbers, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanSum().tabulatedCanSum(targetSum, numbers)));
  }

  private static Stream<Arguments> testCanSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(2, 3), true),
        Arguments.of(7, Lists.newArrayList(5, 3, 4, 7), true),
        Arguments.of(7, Lists.newArrayList(2, 4), false),
        Arguments.of(8, Lists.newArrayList(2, 3, 5), true),
        Arguments.of(300, Lists.newArrayList(7, 14), false)
    );
  }
}
