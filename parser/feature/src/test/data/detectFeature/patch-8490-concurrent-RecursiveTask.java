@@ -38,30 +38,38 @@
 /**
  * A recursive result-bearing {@link ForkJoinTask}.
  *
- * <p>For a classic example, here is a task computing Fibonacci numbers:
+ * <p>For example, here is a task-based program for computing Factorials:
  *
  * <pre> {@code
- * class Fibonacci extends RecursiveTask<Integer> {
- *   final int n;
- *   Fibonacci(int n) { this.n = n; }
- *   protected Integer compute() {
- *     if (n <= 1)
- *       return n;
- *     Fibonacci f1 = new Fibonacci(n - 1);
- *     f1.fork();
- *     Fibonacci f2 = new Fibonacci(n - 2);
- *     return f2.compute() + f1.join();
+ * import java.util.concurrent.RecursiveTask;
+ * import java.math.BigInteger;
+ * public class Factorial {
+ *   static class FactorialTask extends RecursiveTask<BigInteger> {
+ *     private final int from, to;
+ *     FactorialTask(int from, int to) { this.from = from; this.to = to; }
+ *     protected BigInteger compute() {
+ *       int range = to - from;
+ *       if (range == 0) {                       // base case
+ *         return BigInteger.valueOf(from);
+ *       } else if (range == 1) {                // too small to parallelize
+ *         return BigInteger.valueOf(from).multiply(BigInteger.valueOf(to));
+ *       } else {                                // split in half
+ *         int mid = from + range / 2;
+ *         FactorialTask leftTask = new FactorialTask(from, mid);
+ *         leftTask.fork();         // perform about half the work locally
+ *         return new FactorialTask(mid + 1, to).compute()
+ *                .multiply(leftTask.join());
+ *       }
+ *     }
+ *   }
+ *   static BigInteger factorial(int n) { // uses ForkJoinPool.commonPool()
+ *     return (n <= 1) ? BigInteger.ONE : new FactorialTask(1, n).invoke();
+ *   }
+ *   public static void main(String[] args) {
+ *     System.out.println(factorial(Integer.parseInt(args[0])));
  *   }
  * }}</pre>
  *
- * However, besides being a dumb way to compute Fibonacci functions
- * (there is a simple fast linear algorithm that you'd use in
- * practice), this is likely to perform poorly because the smallest
- * subtasks are too small to be worthwhile splitting up. Instead, as
- * is the case for nearly all fork/join applications, you'd pick some
- * minimum granularity size (for example 10 here) for which you always
- * sequentially solve rather than subdividing.
- *
  * @param <V> the type of the result of the task
  *
  * @since 1.7