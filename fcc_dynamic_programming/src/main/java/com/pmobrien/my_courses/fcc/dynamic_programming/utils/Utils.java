package com.pmobrien.my_courses.fcc.dynamic_programming.utils;

import java.util.function.Supplier;

public final class Utils {

  private Utils() {}

  public static <T> T timed(Supplier<T> function) {
    long start = System.currentTimeMillis();
    T result = function.get();

    StackTraceElement ste = Thread.currentThread().getStackTrace()[2];

    System.out.printf(
        "Operation at %s.%s (line %s) took %s ms.%n",
        ste.getClassName(),
        ste.getMethodName(),
        ste.getLineNumber(),
        System.currentTimeMillis() - start
    );

    return result;
  }
}
