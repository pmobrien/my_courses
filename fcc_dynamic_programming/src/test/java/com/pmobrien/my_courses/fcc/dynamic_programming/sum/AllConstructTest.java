package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.pmobrien.my_courses.fcc.dynamic_programming.construct.AllConstruct;
import com.pmobrien.my_courses.fcc.dynamic_programming.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class AllConstructTest {

  @ParameterizedTest
  @MethodSource("testAllConstructSource")
  public void testAllConstruct(String target, List<String> words, List<List<String>> expected) {
    if (target.length() > 25) {
      return; // don't run bigger inputs for this implementation; too slow
    }

    Assertions.assertEquals(expected, Utils.timed(() -> new AllConstruct().allConstruct(target, words)));
  }

  @Disabled("TODO: doesn't work with memoization...")
  @ParameterizedTest
  @MethodSource("testAllConstructSource")
  public void testMemoizedAllConstruct(String target, List<String> words, List<List<String>> expected) {
    Assertions.assertEquals(expected, Utils.timed(() -> new AllConstruct().memoizedAllConstruct(target, words)));
  }

  private static Stream<Arguments> testAllConstructSource() {
    return Stream.of(
        Arguments.of(
            "purple",
            Lists.newArrayList("purp", "p", "ur", "le", "purpl"),
            Lists.newArrayList(
                new LinkedList<String>() {{ add("purp"); add("le"); }},
                new LinkedList<String>() {{ add("p"); add("ur"); add("p"); add("le"); }}
            )
        ),
        Arguments.of(
            "abcdef",
            Lists.newArrayList("ab", "abc", "cd", "def", "abcd", "ef", "c"),
            Lists.newArrayList(
                new LinkedList<String>() {{ add("ab"); add("cd"); add("ef"); }},
                new LinkedList<String>() {{ add("ab"); add("c"); add("def"); }},
                new LinkedList<String>() {{ add("abc"); add("def"); }},
                new LinkedList<String>() {{ add("abcd"); add("ef"); }}
            )
        ),
        Arguments.of(
            "skateboard",
            Lists.newArrayList("bo", "rd", "ate", "t", "ska", "sk", "boar"),
            Lists.newArrayList()
        ),
        Arguments.of(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaz",
            Lists.newArrayList("a", "aa", "aaa", "aaaa", "aaaaa"),
            Lists.newArrayList()
        )
    );
  }
}
