package com.pmobrien.my_courses.fcc.dynamic_programming.gridtraveler;

import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GridTravelerTest {

  @ParameterizedTest
  @MethodSource("testGridTravelerSource")
  public void testGridTraveler(long m, long n, long expected) {
    if (m > 10 || n > 10) {
      Assertions.assertTrue(true); // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new GridTraveler().gridTraveler(m, n)));
  }

  @ParameterizedTest
  @MethodSource("testGridTravelerSource")
  public void testMemoizedGridTraveler(long m, long n, long expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new GridTraveler().memoizedGridTraveler(m, n)));
  }

  private static Stream<Arguments> testGridTravelerSource() {
    return Stream.of(
        Arguments.of(1, 1, 1),
        Arguments.of(2, 3, 3),
        Arguments.of(3, 2, 3),
        Arguments.of(3, 3, 6),
        Arguments.of(18, 18, 2_333_606_220L)
    );
  }
}
