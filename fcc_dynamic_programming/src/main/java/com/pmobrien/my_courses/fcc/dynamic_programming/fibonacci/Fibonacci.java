package com.pmobrien.my_courses.fcc.dynamic_programming.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function fibonacci(n) that takes in a number as an argument. The function should return the n-th number of
 * the Fibonacci sequence.
 *
 * The 1st and 2nd number of the sequence is 1. To generate the next number of the sequence, we sum the previous two.
 */
public class Fibonacci {

  public Fibonacci() {}

  public long fibonacci(long n) {
    if (n <= 2) {
      return 1;
    }

    return fibonacci(n - 2) + fibonacci(n - 1);
  }

  public long memoizedFibonacci(long n) {
    return _memoizedFibonacci(n, new HashMap<>());
  }

  private long _memoizedFibonacci(long n, Map<Long, Long> memo) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    if (n <= 2) {
      return 1;
    }

    memo.put(n, _memoizedFibonacci(n - 2, memo) + _memoizedFibonacci(n - 1, memo));

    return memo.get(n);
  }
}
