@@ -140,33 +140,40 @@ static CompletableFuture<Integer> completion(long pid, boolean shouldReap) {
                 processReaperExecutor.execute(new Runnable() {
                     // Use inner class to avoid lambda stack overhead
                     public void run() {
-                        int exitValue = waitForProcessExit0(pid, shouldReap);
-                        if (exitValue == NOT_A_CHILD) {
-                            // pid not alive or not a child of this process
-                            // If it is alive wait for it to terminate
-                            long sleep = 300;     // initial milliseconds to sleep
-                            int incr = 30;        // increment to the sleep time
-
-                            long startTime = isAlive0(pid);
-                            long origStart = startTime;
-                            while (startTime >= 0) {
-                                try {
-                                    Thread.sleep(Math.min(sleep, 5000L)); // no more than 5 sec
-                                    sleep += incr;
-                                } catch (InterruptedException ie) {
-                                    // ignore and retry
-                                }
-                                startTime = isAlive0(pid);  // recheck if it is alive
-                                if (startTime > 0 && origStart > 0 && startTime != origStart) {
-                                    // start time changed (and is not zero), pid is not the same process
-                                    break;
+                        String threadName = Thread.currentThread().getName();
+                        Thread.currentThread().setName("process reaper (pid " + pid + ")");
+                        try {
+                            int exitValue = waitForProcessExit0(pid, shouldReap);
+                            if (exitValue == NOT_A_CHILD) {
+                                // pid not alive or not a child of this process
+                                // If it is alive wait for it to terminate
+                                long sleep = 300;     // initial milliseconds to sleep
+                                int incr = 30;        // increment to the sleep time
+
+                                long startTime = isAlive0(pid);
+                                long origStart = startTime;
+                                while (startTime >= 0) {
+                                    try {
+                                        Thread.sleep(Math.min(sleep, 5000L)); // no more than 5 sec
+                                        sleep += incr;
+                                    } catch (InterruptedException ie) {
+                                        // ignore and retry
+                                    }
+                                    startTime = isAlive0(pid);  // recheck if it is alive
+                                    if (startTime > 0 && origStart > 0 && startTime != origStart) {
+                                        // start time changed (and is not zero), pid is not the same process
+                                        break;
+                                    }
                                 }
+                                exitValue = 0;
                             }
-                            exitValue = 0;
+                            newCompletion.complete(exitValue);
+                            // remove from cache afterwards
+                            completions.remove(pid, newCompletion);
+                        } finally {
+                            // Restore thread name
+                            Thread.currentThread().setName(threadName);
                         }
-                        newCompletion.complete(exitValue);
-                        // remove from cache afterwards
-                        completions.remove(pid, newCompletion);
                     }
                 });
             }