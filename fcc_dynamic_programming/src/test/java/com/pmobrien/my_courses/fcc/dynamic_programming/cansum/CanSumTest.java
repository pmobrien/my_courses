package com.pmobrien.my_courses.fcc.dynamic_programming.cansum;

import com.google.common.collect.Lists;
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
  public void testCanSum(long targetSum, List<Long> numbers, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanSum().canSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testCanSumSource")
  public void testMemoizedCanSum(long targetSum, List<Long> numbers, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanSum().memoizedCanSum(targetSum, numbers)));
  }

  private static Stream<Arguments> testCanSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(2L, 3L), true),
        Arguments.of(7, Lists.newArrayList(5L, 3L, 4L, 7L), true),
        Arguments.of(7, Lists.newArrayList(2L, 4L), false),
        Arguments.of(8, Lists.newArrayList(2L, 3L, 5L), true),
        Arguments.of(300, Lists.newArrayList(7L, 14L), false)
    );
  }
}
