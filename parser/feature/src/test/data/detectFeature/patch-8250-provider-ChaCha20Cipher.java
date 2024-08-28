@@ -874,7 +874,7 @@ private static void chaCha20Block(int[] initState, long counter,
         int ws14 = initState[14];
         int ws15 = initState[15];
 
-        // Peform 10 iterations of the 8 quarter round set
+        // Perform 10 iterations of the 8 quarter round set
         for (int round = 0; round < 10; round++) {
             ws00 += ws04;
             ws12 = Integer.rotateLeft(ws12 ^ ws00, 16);