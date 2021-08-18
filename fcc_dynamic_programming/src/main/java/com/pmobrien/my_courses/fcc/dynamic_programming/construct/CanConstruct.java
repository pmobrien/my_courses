package com.pmobrien.my_courses.fcc.dynamic_programming.construct;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
 *
 * The function should contain a boolean indicating whether or not the target can be constructed by concatenating
 * elements of the wordBank array.
 *
 * You may reuse elements of wordBank as many times as needed.
 */
public class CanConstruct {

  public CanConstruct() {}

  public boolean canConstruct(String target, List<String> wordBank) {
    if (target == null) {
      return false;
    }

    if ("".equals(target)) {
      return true;
    }

    for (String word : wordBank) {
      if (target.startsWith(word)) {
        if (canConstruct(target.substring(word.length()), wordBank)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean memoizedCanConstruct(String target, List<String> wordBank) {
    return _memoizedCanConstruct(target, wordBank, Maps.newHashMap());
  }

  private boolean _memoizedCanConstruct(String target, List<String> wordBank, Map<String, Boolean> memo) {
    if (memo.containsKey(target)) {
      return memo.get(target);
    }

    if (target == null) {
      return false;
    }

    if ("".equals(target)) {
      return true;
    }

    for (String word : wordBank) {
      if (target.startsWith(word)) {
        if (_memoizedCanConstruct(target.substring(word.length()), wordBank, memo)) {
          memo.put(target, true);
          return true;
        }
      }
    }

    memo.put(target, false);
    return false;
  }
}
