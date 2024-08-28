@@ -731,7 +731,7 @@ public void filter(Instant begin, Instant end, Long maxSize) {
                     result = reduceFromEnd(maxSize, result);
                 }
             }
-            int size = 0;
+            long size = 0;
             for (RepositoryChunk r : result) {
                 size += r.getSize();
                 r.use();