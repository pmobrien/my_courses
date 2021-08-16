package com.pmobrien.my_courses.fcc.dynamic_programming.countconstruct;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CountConstructTest {

  @ParameterizedTest
  @MethodSource("testCountConstructSource")
  public void testCountConstruct(String target, List<String> words, long expected) {
    if (target.length() > 25) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new CountConstruct().countConstruct(target, words)));
  }

  @ParameterizedTest
  @MethodSource("testCountConstructSource")
  public void testMemoizedCountConstruct(String target, List<String> words, long expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CountConstruct().memoizedCountConstruct(target, words)));
  }

  private static Stream<Arguments> testCountConstructSource() {
    return Stream.of(
        Arguments.of("purple", Lists.newArrayList("purp", "p", "ur", "le", "purpl"), 2),
        Arguments.of("abcdef", Lists.newArrayList("ab", "abc", "cd", "def", "abcd"), 1),
        Arguments.of("skateboard", Lists.newArrayList("bo", "rd", "ate", "t", "ska", "sk", "boar"), 0),
        Arguments.of("enterapotentpot", Lists.newArrayList("a", "p", "ent", "enter", "ot", "o", "t"), 4),
        Arguments.of("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Lists.newArrayList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), 0)
    );
  }
}
