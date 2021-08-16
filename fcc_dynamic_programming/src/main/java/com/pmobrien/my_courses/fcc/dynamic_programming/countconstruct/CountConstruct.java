package com.pmobrien.my_courses.fcc.dynamic_programming.countconstruct;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Write a function countConstruct(target, wordBank) that accepts a target string and an array of strings.
 *
 * The function should return the number of ways that the target can be constructed by concatenating elements of the
 * wordBank array.
 *
 * You may reuse elements of wordBank as many times as needed.
 */
public class CountConstruct {

  public CountConstruct() {}

  public long countConstruct(String target, List<String> wordBank) {
    if (target == null) {
      return 0;
    }

    if ("".equals(target)) {
      return 1;
    }

    int count = 0;
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        count += countConstruct(target.substring(word.length()), wordBank);
      }
    }

    return count;
  }

  public long memoizedCountConstruct(String target, List<String> wordBank) {
    return _memoizedCountConstruct(target, wordBank, Maps.newHashMap());
  }

  private long _memoizedCountConstruct(String target, List<String> wordBank, Map<String, Integer> memo) {
    if (memo.containsKey(target)) {
      return memo.get(target);
    }

    if (target == null) {
      return 0;
    }

    if ("".equals(target)) {
      return 1;
    }

    int count = 0;
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        count += _memoizedCountConstruct(target.substring(word.length()), wordBank, memo);
      }
    }

    memo.put(target, count);
    return count;
  }
}
