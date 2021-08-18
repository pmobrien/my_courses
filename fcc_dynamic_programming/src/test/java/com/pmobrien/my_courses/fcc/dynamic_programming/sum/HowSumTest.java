package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.sum.HowSum;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class HowSumTest {

  @ParameterizedTest
  @MethodSource("testHowSumSource")
  public void testHowSum(long targetSum, List<Long> numbers, List<Long> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new HowSum().howSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testHowSumSource")
  public void testMemoizedHowSum(long targetSum, List<Long> numbers, List<Long> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new HowSum().memoizedHowSum(targetSum, numbers)));
  }

  private static Stream<Arguments> testHowSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(2L, 3L), Lists.newArrayList(3L, 2L, 2L)),
        Arguments.of(7, Lists.newArrayList(5L, 3L, 4L, 7L), Lists.newArrayList(4L, 3L)),
        Arguments.of(7, Lists.newArrayList(2L, 4L), null),
        Arguments.of(8, Lists.newArrayList(2L, 3L, 5L), Lists.newArrayList(2L, 2L, 2L, 2L)),
        Arguments.of(300, Lists.newArrayList(7L, 14L), null)
    );
  }
}
