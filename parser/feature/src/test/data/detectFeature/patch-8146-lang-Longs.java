@@ -89,6 +89,22 @@ public void toStringBig(Blackhole bh) {
         }
     }
 
+    /** Performs expand on small values */
+    @Benchmark
+    public void expand(Blackhole bh) {
+        for (long i : longArraySmall) {
+            bh.consume(Long.expand(i, 0xFF00F0F0F0000000L));
+        }
+    }
+
+    /** Performs compress on large values */
+    @Benchmark
+    public void compress(Blackhole bh) {
+        for (long i : longArrayBig) {
+            bh.consume(Long.compress(i, 0x000000000F0F0F1FL));
+        }
+    }
+
     /*
      * Have them public to avoid total unrolling
      */