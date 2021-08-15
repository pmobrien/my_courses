package com.pmobrien.my_courses.fcc.dynamic_programming.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  public Fibonacci() {}

  public long fibonacci(long i) {
    if (i <= 2) {
      return 1;
    }

    return fibonacci(i - 2) + fibonacci(i - 1);
  }

  public long memoizedFibonacci(long i) {
    return memoizedFibonacci(i, new HashMap<>());
  }

  private long memoizedFibonacci(long i, Map<Long, Long> memo) {
    if (memo.containsKey(i)) {
      return memo.get(i);
    }

    if (i <= 2) {
      return 1;
    }

    memo.put(i, memoizedFibonacci(i - 2, memo) + memoizedFibonacci(i - 1, memo));

    return memo.get(i);
  }
}
