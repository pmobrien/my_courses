package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Write a function bestSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing the shortest combination of numbers that add up to exactly the
 * targetSum.
 *
 * If there is a tie for the shortest combination, you may return any one of the shortest.
 */
public class BestSum {

  public BestSum() {}

  public List<Integer> bestSum(int targetSum, List<Integer> numbers) {
    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    List<Integer> best = null;
    for (int number : numbers) {
      List<Integer> result = bestSum(targetSum - number, numbers);
      if (result != null) {
        List<Integer> newResult = Lists.newArrayList();
        newResult.addAll(result);
        newResult.add(number);

        if (best == null || newResult.size() < best.size()) {
          best = newResult;
        }
      }
    }

    return best;
  }

  public List<Integer> memoizedBestSum(int targetSum, List<Integer> numbers) {
    return _memoizedBestSum(targetSum, numbers, Maps.newHashMap());
  }

  public List<Integer> _memoizedBestSum(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    List<Integer> best = null;
    for (int number : numbers) {
      List<Integer> result = _memoizedBestSum(targetSum - number, numbers, memo);
      if (result != null) {
        List<Integer> newResult = Lists.newArrayList();
        newResult.addAll(result);
        newResult.add(number);

        if (best == null || newResult.size() < best.size()) {
          best = newResult;
        }
      }
    }

    memo.put(targetSum, best);
    return best;
  }

  @SuppressWarnings("unchecked")  // ignore the warning about the ArrayList array
  public List<Integer> tabulatedBestSum(int targetSum, List<Integer> numbers) {
    if (targetSum < 0) {
      return null;
    }

    ArrayList<Integer>[] dp = new ArrayList[targetSum + 1];
    dp[0] = new ArrayList<>();

    for (int current = 1; current <= targetSum; ++current) {
      ArrayList<Integer> best = null;
      for (int number : numbers) {
        if (number <= current) {
          ArrayList<Integer> list = dp[current - number];
          if (list != null) {
            ArrayList<Integer> possible = new ArrayList<Integer>(list) {{ add(number); }};

            if (best == null || possible.size() < best.size()) {
              best = possible;
            }
          }
        }
      }

      dp[current] = best;
    }

    return dp[targetSum];
  }
}
