@@ -129,7 +129,7 @@ protected int doSelect(Consumer<SelectionKey> action, long timeout)
                 if (numEntries == IOStatus.INTERRUPTED && timedPoll) {
                     // timed poll interrupted so need to adjust timeout
                     long adjust = System.nanoTime() - startTime;
-                    to -= TimeUnit.MILLISECONDS.convert(adjust, TimeUnit.NANOSECONDS);
+                    to -= TimeUnit.NANOSECONDS.toMillis(adjust);
                     if (to <= 0) {
                         // timeout expired so no retry
                         numEntries = 0;