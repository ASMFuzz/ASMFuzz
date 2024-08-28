@@ -34,6 +34,7 @@
 import java.util.Optional;
 
 import jdk.internal.misc.CDS;
+import jdk.internal.vm.annotation.ForceInline;
 import jdk.internal.vm.annotation.IntrinsicCandidate;
 
 import static java.lang.String.COMPACT_STRINGS;
@@ -1934,12 +1935,7 @@ public static long compress(long i, long mask) {
         for (int j = 0; j < 6; j++) {
             // Parallel prefix
             // Mask prefix identifies bits of the mask that have an odd number of 0's to the right
-            long maskPrefix = maskCount  ^ (maskCount  << 1);
-            maskPrefix = maskPrefix ^ (maskPrefix << 2);
-            maskPrefix = maskPrefix ^ (maskPrefix << 4);
-            maskPrefix = maskPrefix ^ (maskPrefix << 8);
-            maskPrefix = maskPrefix ^ (maskPrefix << 16);
-            maskPrefix = maskPrefix ^ (maskPrefix << 32);
+            long maskPrefix = parallelSuffix(maskCount);
             // Bits to move
             long maskMove = maskPrefix & mask;
             // Compress mask
@@ -1973,37 +1969,77 @@ public static long compress(long i, long mask) {
      */
     // @IntrinsicCandidate
     public static long expand(long i, long mask) {
-        long[] array = new long[6];
         // Save original mask
         long originalMask = mask;
         // Count 0's to right
         long maskCount = ~mask << 1;
-        for (int j = 0; j < 6; j++) {
-            // Parallel suffix
-            long maskPrefix = maskCount ^ (maskCount << 1);
-            maskPrefix = maskPrefix ^ (maskPrefix << 2);
-            maskPrefix = maskPrefix ^ (maskPrefix << 4);
-            maskPrefix = maskPrefix ^ (maskPrefix << 8);
-            maskPrefix = maskPrefix ^ (maskPrefix << 16);
-            maskPrefix = maskPrefix ^ (maskPrefix << 32);
-            // Bits to move
-            long maskMove = maskPrefix & mask;
-            array[j] = maskMove;
-            // Compress mask
-            mask = (mask ^ maskMove) | (maskMove >>> (1 << j));
-            maskCount = maskCount & ~maskPrefix;
-        }
-
-        for (int j = 5; j >= 0; j--) {
-            long maskMove = array[j];
-            long t = i << (1 << j);
-            i = (i & ~maskMove) | (t & maskMove);
-        }
+        long maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove1 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove1) | (maskMove1 >>> (1 << 0));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove2 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove2) | (maskMove2 >>> (1 << 1));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove3 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove3) | (maskMove3 >>> (1 << 2));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove4 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove4) | (maskMove4 >>> (1 << 3));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove5 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove5) | (maskMove5 >>> (1 << 4));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        long maskMove6 = maskPrefix & mask;
+
+        long t = i << (1 << 5);
+        i = (i & ~maskMove6) | (t & maskMove6);
+        t = i << (1 << 4);
+        i = (i & ~maskMove5) | (t & maskMove5);
+        t = i << (1 << 3);
+        i = (i & ~maskMove4) | (t & maskMove4);
+        t = i << (1 << 2);
+        i = (i & ~maskMove3) | (t & maskMove3);
+        t = i << (1 << 1);
+        i = (i & ~maskMove2) | (t & maskMove2);
+        t = i << (1 << 0);
+        i = (i & ~maskMove1) | (t & maskMove1);
 
         // Clear irrelevant bits
         return i & originalMask;
     }
 
+    @ForceInline
+    private static long parallelSuffix(long maskCount) {
+        long maskPrefix = maskCount ^ (maskCount << 1);
+        maskPrefix = maskPrefix ^ (maskPrefix << 2);
+        maskPrefix = maskPrefix ^ (maskPrefix << 4);
+        maskPrefix = maskPrefix ^ (maskPrefix << 8);
+        maskPrefix = maskPrefix ^ (maskPrefix << 16);
+        maskPrefix = maskPrefix ^ (maskPrefix << 32);
+        return maskPrefix;
+    }
+
     /**
      * Returns the signum function of the specified {@code long} value.  (The
      * return value is -1 if the specified value is negative; 0 if the