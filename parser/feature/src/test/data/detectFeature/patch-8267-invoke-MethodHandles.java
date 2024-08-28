@@ -5876,6 +5876,7 @@ private static void filterReturnValueChecks(MethodType targetType, MethodType fi
      * V adapter(A... a, B... b) {
      *     T t = target(a...);
      *     return filter(b..., t);
+     * }
      * }</pre></blockquote>
      * <p>
      * If the filter handle is a unary function, then this method behaves like {@link #filterReturnValue(MethodHandle, MethodHandle)}.