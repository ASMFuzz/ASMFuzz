@@ -27,6 +27,7 @@
 
 import jdk.internal.misc.CDS;
 import jdk.internal.misc.VM;
+import jdk.internal.vm.annotation.ForceInline;
 import jdk.internal.vm.annotation.IntrinsicCandidate;
 
 import java.lang.annotation.Native;
@@ -1795,11 +1796,7 @@ public static int compress(int i, int mask) {
         for (int j = 0; j < 5; j++) {
             // Parallel prefix
             // Mask prefix identifies bits of the mask that have an odd number of 0's to the right
-            int maskPrefix = maskCount  ^ (maskCount  << 1);
-            maskPrefix = maskPrefix ^ (maskPrefix << 2);
-            maskPrefix = maskPrefix ^ (maskPrefix << 4);
-            maskPrefix = maskPrefix ^ (maskPrefix << 8);
-            maskPrefix = maskPrefix ^ (maskPrefix << 16);
+            int maskPrefix = parallelSuffix(maskCount);
             // Bits to move
             int maskMove = maskPrefix & mask;
             // Compress mask
@@ -1833,36 +1830,67 @@ public static int compress(int i, int mask) {
      */
     // @IntrinsicCandidate
     public static int expand(int i, int mask) {
-        int[] array = new int[5];
         // Save original mask
         int originalMask = mask;
         // Count 0's to right
         int maskCount = ~mask << 1;
-        for (int j = 0; j < 5; j++) {
-            // Parallel suffix
-            int maskPrefix = maskCount ^ (maskCount << 1);
-            maskPrefix = maskPrefix ^ (maskPrefix << 2);
-            maskPrefix = maskPrefix ^ (maskPrefix << 4);
-            maskPrefix = maskPrefix ^ (maskPrefix << 8);
-            maskPrefix = maskPrefix ^ (maskPrefix << 16);
-            // Bits to move
-            int maskMove = maskPrefix & mask;
-            array[j] = maskMove;
-            // Compress mask
-            mask = (mask ^ maskMove) | (maskMove >>> (1 << j));
-            maskCount = maskCount & ~maskPrefix;
-        }
-
-        for (int j = 4; j >= 0; j--) {
-            int maskMove = array[j];
-            int t = i << (1 << j);
-            i = (i & ~maskMove) | (t & maskMove);
-        }
+        int maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        int maskMove1 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove1) | (maskMove1 >>> (1 << 0));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        int maskMove2 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove2) | (maskMove2 >>> (1 << 1));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        int maskMove3 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove3) | (maskMove3 >>> (1 << 2));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        int maskMove4 = maskPrefix & mask;
+        // Compress mask
+        mask = (mask ^ maskMove4) | (maskMove4 >>> (1 << 3));
+        maskCount = maskCount & ~maskPrefix;
+
+        maskPrefix = parallelSuffix(maskCount);
+        // Bits to move
+        int maskMove5 = maskPrefix & mask;
+
+        int t = i << (1 << 4);
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
+    private static int parallelSuffix(int maskCount) {
+        int maskPrefix = maskCount ^ (maskCount << 1);
+        maskPrefix = maskPrefix ^ (maskPrefix << 2);
+        maskPrefix = maskPrefix ^ (maskPrefix << 4);
+        maskPrefix = maskPrefix ^ (maskPrefix << 8);
+        maskPrefix = maskPrefix ^ (maskPrefix << 16);
+        return maskPrefix;
+    }
+
     /**
      * Returns the signum function of the specified {@code int} value.  (The
      * return value is -1 if the specified value is negative; 0 if the