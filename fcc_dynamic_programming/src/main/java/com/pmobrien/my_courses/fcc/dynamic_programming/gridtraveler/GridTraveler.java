package com.pmobrien.my_courses.fcc.dynamic_programming.gridtraveler;

import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are a traveler on a 2d grid. You begin in the top-left corner and your goal is to travel to the
 * bottom-right corner. You may only move down or right.
 *
 * In how many ways can you travel to the goal on a grid with dimensions m * n?
 *
 * Write a function gridTraveler(m, n) that calculates this.
 */
public class GridTraveler {

  public GridTraveler() {}

  public long gridTraveler(long m, long n) {
    if (m == 1 && n == 1) {
      return 1;
    }

    if (m == 0 || n == 0) {
      return 0;
    }

    return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
  }

  public long memoizedGridTraveler(long m, long n) {
    return memoizedGridTraveler(m, n, new HashMap<>());
  }

  private long memoizedGridTraveler(long m, long n, Map<String, Long> memo) {
    String k1 = m + "," + n;
    String k2 = n + "," + m;

    if (memo.containsKey(k1)) {
      return memo.get(k1);
    }

    if (memo.containsKey(k2)) {
      return memo.get(k2);
    }

    if (m == 1 && n == 1) {
      return 1;
    }

    if (m == 0 || n == 0) {
      return 0;
    }

    long result = memoizedGridTraveler(m - 1, n, memo) + memoizedGridTraveler(m, n - 1, memo);

    memo.put(k1, result);
    memo.put(k2, result);

    return result;
  }
}
