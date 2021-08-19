package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function canSum(targetSum, numbers) that takes in a targetSum and an array of numbers as an argument.
 *
 * The function should return a boolean indicating whether or not it is possible to generate the target sum using
 * numbers from the array.
 *
 * You may use an element of the array as many times as needed.
 *
 * You may assume that all input numbers are nonnegative.
 */
public class CanSum {

  public CanSum() {}

  public boolean canSum(int targetSum, List<Integer> numbers) {
    if (targetSum < 0) {
      return false;
    }

    if (targetSum == 0) {
      return true;
    }

    for (int number : numbers) {
      if (canSum(targetSum - number, numbers)) {
        return true;
      }
    }

    return false;
  }

  public boolean memoizedCanSum(int targetSum, List<Integer> numbers) {
    return _memoizedCanSum(targetSum, numbers, new HashMap<>());
  }

  private boolean _memoizedCanSum(int targetSum, List<Integer> numbers, Map<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum < 0) {
      return false;
    }

    if (targetSum == 0) {
      return true;
    }

    for (int number : numbers) {
      if (_memoizedCanSum(targetSum - number, numbers, memo)) {
        memo.put(targetSum, true);
        return true;
      }
    }

    memo.put(targetSum, false);
    return false;
  }

  public boolean tabulatedCanSum(int targetSum, List<Integer> numbers) {
    if (targetSum < 0) {
      return false;
    }

    boolean[] dp = new boolean[targetSum + 1];
    dp[0] = true;

    for (int i = 1; i <= targetSum; ++i) {
      for (int number : numbers) {
        if (number <= i) {
          dp[i] = dp[i] || dp[i - number];
        }
      }
    }

    System.out.println(Arrays.toString(dp));

    return dp[targetSum];
  }
}
