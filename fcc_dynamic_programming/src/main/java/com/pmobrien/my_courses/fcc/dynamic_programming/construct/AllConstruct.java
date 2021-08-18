package com.pmobrien.my_courses.fcc.dynamic_programming.construct;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a function allConstruct(target, wordBank) that accepts a target string and an array of strings.
 *
 * The function should return a 2d array containing all of the ways the target can be constructed by concatenating
 * elements of the wordBank array. Each element of the 2d array should represent one combination that constructs the
 * target.
 *
 * You may reuse elements of wordBank as many times as needed.
 */
public class AllConstruct {

  public AllConstruct() {}

  public List<LinkedList<String>> allConstruct(String target, List<String> wordBank) {
    if (target == null) {
      return Lists.newArrayList();
    }

    if ("".equals(target)) {
      return new ArrayList<LinkedList<String>>() {{
        add(new LinkedList<>());
      }};
    }

    List<LinkedList<String>> result = Lists.newArrayList();
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        result.addAll(
            allConstruct(target.substring(word.length()), wordBank).stream()
                .peek(ll -> ll.addFirst(word))
                .collect(Collectors.toList())
        );
      }
    }

    return result;
  }

  public List<LinkedList<String>> memoizedAllConstruct(String target, List<String> wordBank) {
    return _memoizedAllConstruct(target, wordBank, Maps.newHashMap());
  }

  private List<LinkedList<String>> _memoizedAllConstruct(String target, List<String> wordBank, Map<String, List<LinkedList<String>>> memo) {
    if (memo.containsKey(target)) {
      System.out.println(memo);
      return memo.get(target);
    }

    if (target == null) {
      return Lists.newArrayList();
    }

    if ("".equals(target)) {
      return new ArrayList<LinkedList<String>>() {{
        add(new LinkedList<>());
      }};
    }

    List<LinkedList<String>> result = new ArrayList<>();
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        result.addAll(
            _memoizedAllConstruct(target.substring(word.length()), wordBank, memo).stream()
                .peek(ll -> ll.addFirst(word))
                .collect(Collectors.toList())
        );
      }
    }

    memo.put(target, result);
    return result;
  }
}
