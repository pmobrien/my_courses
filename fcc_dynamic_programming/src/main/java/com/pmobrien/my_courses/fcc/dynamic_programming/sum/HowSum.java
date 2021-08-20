package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;

import java.util.ArrayList;
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

  public List<Integer> howSum(int targetSum, List<Integer> numbers) {
    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    for (int number : numbers) {
      List<Integer> result = howSum(targetSum - number, numbers);
      if (result != null) {
        result.add(number);
        return result;
      }
    }

    return null;
  }

  public List<Integer> memoizedHowSum(int targetSum, List<Integer> numbers) {
    return _memoizedHowSum(targetSum, numbers, new HashMap<>());
  }

  private List<Integer> _memoizedHowSum(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    for (int number : numbers) {
      List<Integer> result = _memoizedHowSum(targetSum - number, numbers, memo);
      if (result != null) {
        result.add(number);
        memo.put(targetSum, result);
        return result;
      }
    }

    memo.put(targetSum, null);
    return null;
  }

  @SuppressWarnings("unchecked")  // ignore the warning about the ArrayList array
  public List<Integer> tabulatedHowSum(int targetSum, List<Integer> numbers) {
    if (targetSum < 0) {
      return null;
    }

    ArrayList<Integer>[] dp = new ArrayList[targetSum + 1];
    dp[0] = new ArrayList<>();

    for (int current = 1; current <= targetSum; ++current) {
      for (int number : numbers) {
        if (number <= current) {
          List<Integer> list = dp[current - number];
          if (list != null) {
            dp[current] = new ArrayList<Integer>(list) {{ add(number); }};
          }
        }
      }
    }

    return dp[targetSum];
  }
}
