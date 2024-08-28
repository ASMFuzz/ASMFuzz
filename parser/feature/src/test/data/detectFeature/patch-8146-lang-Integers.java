@@ -109,4 +109,20 @@ public void toStringBig(Blackhole bh) {
             bh.consume(Integer.toString(i));
         }
     }
+
+    /** Performs expand on small values */
+    @Benchmark
+    public void expand(Blackhole bh) {
+        for (int i : intsSmall) {
+            bh.consume(Integer.expand(i, 0xFF00F0F0));
+        }
+    }
+
+    /** Performs compress on large values */
+    @Benchmark
+    public void compress(Blackhole bh) {
+        for (int i : intsBig) {
+            bh.consume(Integer.compress(i, 0x000F0F1F));
+        }
+    }
 }