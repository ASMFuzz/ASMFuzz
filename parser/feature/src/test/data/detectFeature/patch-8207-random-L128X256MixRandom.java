@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -178,7 +178,7 @@ public L128X256MixRandom(long ah, long al, long sh, long sl, long x0, long x1, l
         this.x3 = x3;
         // If x0, x1, x2, and x3 are all zero, we must choose nonzero values.
         if ((x0 | x1 | x2 | x3) == 0) {
-       long v = sh;
+            long v = sh;
             // At least three of the four values generated here will be nonzero.
             this.x0 = RandomSupport.mixStafford13(v += RandomSupport.GOLDEN_RATIO_64);
             this.x1 = RandomSupport.mixStafford13(v += RandomSupport.GOLDEN_RATIO_64);
@@ -234,8 +234,8 @@ public L128X256MixRandom() {
      * @param seed the initial seed
      */
     public L128X256MixRandom(byte[] seed) {
-        // Convert the seed to 6 long values, of which the last 4 are not all zero.
-        long[] data = RandomSupport.convertSeedBytesToLongs(seed, 6, 4);
+        // Convert the seed to 8 long values, of which the last 4 are not all zero.
+        long[] data = RandomSupport.convertSeedBytesToLongs(seed, 8, 4);
         long ah = data[0], al = data[1], sh = data[2], sl = data[3],
              x0 = data[4], x1 = data[5], x2 = data[6], x3 = data[7];
         // Force a to be odd.
@@ -253,7 +253,7 @@ public L128X256MixRandom(byte[] seed) {
 
     @Override
     public SplittableGenerator split(SplittableGenerator source, long brine) {
-       // Pick a new instance "at random", but use the brine for (the low half of) `a`.
+        // Pick a new instance "at random", but use the brine for (the low half of) `a`.
         return new L128X256MixRandom(source.nextLong(), brine << 1,
                     source.nextLong(), source.nextLong(),
                     source.nextLong(), source.nextLong(),
@@ -262,18 +262,18 @@ public SplittableGenerator split(SplittableGenerator source, long brine) {
 
     @Override
     public long nextLong() {
-       // Compute the result based on current state information
-       // (this allows the computation to be overlapped with state update).
+        // Compute the result based on current state information
+        // (this allows the computation to be overlapped with state update).
         final long result = RandomSupport.mixLea64(sh + x0);
 
-       // Update the LCG subgenerator
+        // Update the LCG subgenerator
         // The LCG is, in effect, s = ((1LL << 64) + ML) * s + a, if only we had 128-bit arithmetic.
         final long u = ML * sl;
         sh = (ML * sh) + Math.unsignedMultiplyHigh(ML, sl) + sl + ah;
         sl = u + al;
         if (Long.compareUnsigned(sl, u) < 0) ++sh;  // Handle the carry propagation from low half to high half.
 
-       // Update the XBG subgenerator
+        // Update the XBG subgenerator
         long q0 = x0, q1 = x1, q2 = x2, q3 = x3;
         {   // xoshiro256 1.0
             long t = q1 << 17;