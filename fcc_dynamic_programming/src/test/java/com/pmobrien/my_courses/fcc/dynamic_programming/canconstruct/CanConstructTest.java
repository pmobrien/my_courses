package com.pmobrien.my_courses.fcc.dynamic_programming.canconstruct;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.conconstruct.CanConstruct;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class CanConstructTest {

  @ParameterizedTest
  @MethodSource("testCanConstructSource")
  public void testCanConstruct(String target, List<String> words, boolean expected) {
    if (target.length() > 25) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new CanConstruct().canConstruct(target, words)));
  }

  @ParameterizedTest
  @MethodSource("testCanConstructSource")
  public void testMemoizedCanConstruct(String target, List<String> words, boolean expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new CanConstruct().memoizedCanConstruct(target, words)));
  }

  private static Stream<Arguments> testCanConstructSource() {
    return Stream.of(
        Arguments.of("abcdef", Lists.newArrayList("ab", "abc", "cd", "def", "abcd"), true),
        Arguments.of("skateboard", Lists.newArrayList("bo", "rd", "ate", "t", "ska", "sk", "boar"), false),
        Arguments.of("enterapotentpot", Lists.newArrayList("a", "p", "ent", "enter", "ot", "o", "t"), true),
        Arguments.of("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Lists.newArrayList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), false)
    );
  }
}
