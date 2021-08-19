package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
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
  public void testHowSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    if (targetSum > 100) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new HowSum().howSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testHowSumSource")
  public void testMemoizedHowSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new HowSum().memoizedHowSum(targetSum, numbers)));
  }

  @ParameterizedTest
  @MethodSource("testHowSumSource")
  public void testTabulatedHowSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
    // results array won't be in the same order as the other methods, so compare by actually summing
    List<Integer> result = Utils.timed(() -> new HowSum().tabulatedHowSum(targetSum, numbers));
    if (expected == null) {
      Assertions.assertNull(result);
      return;
    }

    Integer sum = result.stream().reduce(0, Integer::sum);

    Assertions.assertEquals(targetSum, sum);
    Assertions.assertEquals(expected.stream().reduce(0, Integer::sum), sum);

  }

  private static Stream<Arguments> testHowSumSource() {
    return Stream.of(
        Arguments.of(7, Lists.newArrayList(2, 3), Lists.newArrayList(3, 2, 2)),
        Arguments.of(7, Lists.newArrayList(5, 3, 4, 7), Lists.newArrayList(4, 3)),
        Arguments.of(7, Lists.newArrayList(2, 4), null),
        Arguments.of(8, Lists.newArrayList(2, 3, 5), Lists.newArrayList(2, 2, 2, 2)),
        Arguments.of(300, Lists.newArrayList(7, 14), null)
    );
  }
}
