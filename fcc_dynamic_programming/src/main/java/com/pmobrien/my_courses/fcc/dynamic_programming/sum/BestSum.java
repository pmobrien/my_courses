package com.pmobrien.my_courses.fcc.dynamic_programming.sum;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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

  public List<Long> bestSum(long targetSum, List<Long> numbers) {
    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    List<Long> best = null;
    for (long number : numbers) {
      List<Long> result = bestSum(targetSum - number, numbers);
      if (result != null) {
        List<Long> newResult = Lists.newArrayList();
        newResult.addAll(result);
        newResult.add(number);

        if (best == null || newResult.size() < best.size()) {
          best = newResult;
        }
      }
    }

    return best;
  }

  public List<Long> memoizedBestSum(long targetSum, List<Long> numbers) {
    return _memoizedBestSum(targetSum, numbers, Maps.newHashMap());
  }

  public List<Long> _memoizedBestSum(long targetSum, List<Long> numbers, Map<Long, List<Long>> memo) {
    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    if (targetSum == 0) {
      return Lists.newArrayList();
    }

    if (targetSum < 0) {
      return null;
    }

    List<Long> best = null;
    for (long number : numbers) {
      List<Long> result = _memoizedBestSum(targetSum - number, numbers, memo);
      if (result != null) {
        List<Long> newResult = Lists.newArrayList();
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
}
