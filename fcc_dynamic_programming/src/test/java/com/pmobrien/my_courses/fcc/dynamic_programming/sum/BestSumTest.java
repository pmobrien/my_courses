package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class BestSumTest {

  @ParameterizedTest
  @MethodSource("testBestSumSource")
  public void testBestSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    if (targetSum > 50) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new BestSum().bestSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testBestSumSource")
  public void testMemoizedBestSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new BestSum().memoizedBestSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testBestSumSource")
  public void testTabulatedBestSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new BestSum().tabulatedBestSum(targetSum, numbers)));
  }

  private static Stream<Arguments> testBestSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(5, 3, 4, 7), Lists.newArrayList(7)),
        Arguments.of(8, Lists.newArrayList(2, 3, 5), Lists.newArrayList(5, 3)),
        Arguments.of(8, Lists.newArrayList(1, 4, 5), Lists.newArrayList(4, 4)),
        Arguments.of(100, Lists.newArrayList(1, 2, 5, 25), Lists.newArrayList(25, 25, 25, 25))
    );
  }
}
