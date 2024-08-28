@@ -1230,7 +1230,7 @@ private static Runnable closerFor(FileDescriptor fd, boolean stream) {
     private static long tryLock(ReentrantLock lock, long timeout, TimeUnit unit) {
         assert timeout > 0;
         boolean interrupted = false;
-        long nanos = NANOSECONDS.convert(timeout, unit);
+        long nanos = unit.toNanos(timeout);
         long remainingNanos = nanos;
         long startNanos = System.nanoTime();
         boolean acquired = false;