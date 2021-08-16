package com.pmobrien.my_courses.fcc.dynamic_programming.bestsum;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.howsum.HowSum;
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
  public void testBestSum(long targetSum, List<Long> numbers, List<Long> expected) {
    if (targetSum > 50) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new BestSum().bestSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testBestSumSource")
  public void testMemoizedBestSum(long targetSum, List<Long> numbers, List<Long> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new BestSum().memoizedBestSum(targetSum, numbers)));
  }

  private static Stream<Arguments> testBestSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(5L, 3L, 4L, 7L), Lists.newArrayList(7L)),
        Arguments.of(8, Lists.newArrayList(2L, 3L, 5L), Lists.newArrayList(5L, 3L)),
        Arguments.of(8, Lists.newArrayList(1L, 4L, 5L), Lists.newArrayList(4L, 4L)),
        Arguments.of(100, Lists.newArrayList(1L, 2L, 5L, 25L), Lists.newArrayList(25L, 25L, 25L, 25L))
    );
  }
}
