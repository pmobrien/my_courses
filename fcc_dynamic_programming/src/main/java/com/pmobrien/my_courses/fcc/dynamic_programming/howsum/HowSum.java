package com.pmobrien.my_courses.fcc.dynamic_programming.howsum;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing any combination of elements that add up exactly to targetSum. If there
 * is no combination that adds up to the targetSum, then return null.
 *
 * If there are multiple combinations possible, you may return any single one.
 */
public class HowSum {

  public HowSum() {}

  public List<Long> howSum(long targetSum, List<Long> numbers) {
    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    for (long number : numbers) {
      List<Long> result = howSum(targetSum - number, numbers);
      if (result != null) {
        result.add(number);
        return result;
      }
    }

    return null;
  }

  public List<Long> memoizedHowSum(long targetSum, List<Long> numbers) {
    return _memoizedHowSum(targetSum, numbers, new HashMap<>());
  }

  private List<Long> _memoizedHowSum(long targetSum, List<Long> numbers, Map<Long, List<Long>> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    for (long number : numbers) {
      List<Long> result = _memoizedHowSum(targetSum - number, numbers, memo);
      if (result != null) {
        result.add(number);
        memo.put(targetSum, result);
        return result;
      }
    }

    memo.put(targetSum, null);
    return null;
  }
}
