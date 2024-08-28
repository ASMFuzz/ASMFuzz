@@ -358,7 +358,7 @@
  * uses a large family of state cycles and makes some attempt to ensure that
  * distinct instances use different state cycles; but even if two instances
  * "accidentally" use the same state cycle, they are highly likely to traverse
- * different regions parts of that shared state cycle. This strategy is
+ * different regions of that shared state cycle. This strategy is
  * supported by the interface {@link RandomGenerator.SplittableGenerator}.
  * In this package, implementations of this interface include
  * "L32X64MixRandom",