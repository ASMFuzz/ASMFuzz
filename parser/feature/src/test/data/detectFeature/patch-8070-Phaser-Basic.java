@@ -440,7 +440,7 @@ static void dumpTestThreads() {
             if ("Finalizer".equals(name)
                 && info.getLockName().startsWith("java.lang.ref.ReferenceQueue$Lock"))
                 continue;
-            if ("process reaper".equals(name))
+            if (name.startsWith("process reaper"))
                 continue;
             if (name != null && name.startsWith("ForkJoinPool.commonPool-worker"))
                 continue;