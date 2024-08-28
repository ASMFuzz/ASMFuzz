@@ -71,18 +71,15 @@ static LambdaFormEditor lambdaFormEditor(LambdaForm lambdaForm) {
             SPREAD_ARGS = 4,
             FILTER_ARG = 5,
             FILTER_RETURN = 6,
-            FILTER_RETURN_TO_ZERO = 7,
-            COLLECT_ARGS = 8,
-            COLLECT_ARGS_TO_VOID = 9,
-            COLLECT_ARGS_TO_ARRAY = 10,
-            FOLD_ARGS = 11,
-            FOLD_ARGS_TO_VOID = 12,
-            PERMUTE_ARGS = 13,
-            LOCAL_TYPES = 14,
-            FOLD_SELECT_ARGS = 15,
-            FOLD_SELECT_ARGS_TO_VOID = 16,
-            FILTER_SELECT_ARGS = 17,
-            REPEAT_FILTER_ARGS = 18;
+            COLLECT_ARGS = 7,
+            COLLECT_ARGS_TO_VOID = 8,
+            REPEAT_FILTER_ARGS = 9,
+            FOLD_ARGS = 10,
+            FOLD_ARGS_TO_VOID = 11,
+            PERMUTE_ARGS = 12,
+            LOCAL_TYPES = 13,
+            FILTER_SELECT_ARGS = 14,
+            FOLD_SELECT_ARGS = 15;
 
     /**
      * A description of a cached transform, possibly associated with the result of the transform.
@@ -154,11 +151,13 @@ private TransformKey(long packedBytes) {
         }
 
         private TransformKey(byte[] fullBytes) {
+            assert(packedBytes(fullBytes) == 0);
             this.fullBytes = fullBytes;
             this.packedBytes = 0;
         }
 
         private TransformKey(long packedBytes, byte[] fullBytes) {
+            assert(fullBytes == null || packedBytes == 0);
             this.fullBytes = fullBytes;
             this.packedBytes = packedBytes;
         }
@@ -167,6 +166,12 @@ private static byte bval(int b) {
             assert((b & 0xFF) == b);  // incoming value must fit in *unsigned* byte
             return (byte)b;
         }
+
+        private static int ival(int b) {
+            assert((b & 0xFF) == b);  // incoming value must fit in *unsigned* byte
+            return b;
+        }
+
         static TransformKey of(byte k, int b1) {
             byte b0 = bval(k);
             if (inRange(b0 | b1))
@@ -186,43 +191,44 @@ static TransformKey of(byte b0, int b1, int b2, int b3) {
             else
                 return new TransformKey(fullBytes(b0, b1, b2, b3));
         }
-        private static final byte[] NO_BYTES = {};
         static TransformKey of(byte kind, int... b123) {
-            return ofBothArrays(kind, b123, NO_BYTES);
+            long packedBytes = packedBytes(kind, b123);
+            if (packedBytes != 0) {
+                return new TransformKey(packedBytes);
+            }
+            byte[] fullBytes = new byte[b123.length + 1];
+            fullBytes[0] = kind;
+            for (int i = 0; i < b123.length; i++) {
+                fullBytes[i + 1] = TransformKey.bval(b123[i]);
+            }
+            return new TransformKey(fullBytes);
         }
-
-        static TransformKey of(byte kind, int b1, int[] b23456) {
-            byte[] fullBytes = new byte[b23456.length + 2];
+        static TransformKey of(byte kind, int b1, int... b234) {
+            long packedBytes = packedBytes(kind, b1, b234);
+            if (packedBytes != 0) {
+                return new TransformKey(packedBytes);
+            }
+            byte[] fullBytes = new byte[b234.length + 2];
             fullBytes[0] = kind;
             fullBytes[1] = bval(b1);
-            for (int i = 0; i < b23456.length; i++) {
-                fullBytes[i + 2] = TransformKey.bval(b23456[i]);
+            for (int i = 0; i < b234.length; i++) {
+                fullBytes[i + 2] = TransformKey.bval(b234[i]);
             }
-            long packedBytes = packedBytes(fullBytes);
-            if (packedBytes != 0)
-                return new TransformKey(packedBytes);
-            else
-                return new TransformKey(fullBytes);
-        }
-
-        static TransformKey of(byte kind, int b1, int b2, byte[] b345) {
-            return ofBothArrays(kind, new int[]{ b1, b2 }, b345);
+            return new TransformKey(fullBytes);
         }
-        private static TransformKey ofBothArrays(byte kind, int[] b123, byte[] b456) {
-            byte[] fullBytes = new byte[1 + b123.length + b456.length];
-            int i = 0;
-            fullBytes[i++] = bval(kind);
-            for (int bv : b123) {
-                fullBytes[i++] = bval(bv);
+        static TransformKey of(byte kind, int b1, int b2, int... b345) {
+            long packedBytes = packedBytes(kind, b1, b2, b345);
+            if (packedBytes != 0) {
+                return new TransformKey(packedBytes);
             }
-            for (byte bv : b456) {
-                fullBytes[i++] = bv;
+            byte[] fullBytes = new byte[b345.length + 3];
+            fullBytes[0] = kind;
+            fullBytes[1] = bval(b1);
+            fullBytes[2] = bval(b2);
+            for (int i = 0; i < b345.length; i++) {
+                fullBytes[i + 3] = TransformKey.bval(b345[i]);
             }
-            long packedBytes = packedBytes(fullBytes);
-            if (packedBytes != 0)
-                return new TransformKey(packedBytes);
-            else
-                return new TransformKey(fullBytes);
+            return new TransformKey(fullBytes);
         }
 
         private static final boolean STRESS_TEST = false; // turn on to disable most packing
@@ -231,6 +237,52 @@ private static TransformKey ofBothArrays(byte kind, int[] b123, byte[] b456) {
                 PACKED_BYTE_MASK = (1 << PACKED_BYTE_SIZE) - 1,
                 PACKED_BYTE_MAX_LENGTH = (STRESS_TEST ? 3 : 64 / PACKED_BYTE_SIZE);
 
+        private static long packedBytes(byte b0, int b1, int b2, int[] b345) {
+            if (b345.length + 3 > PACKED_BYTE_MAX_LENGTH)
+                return 0;
+            long pb = 0;
+            int bitset = b0 | b1 | b2;
+            for (int i = 0; i < b345.length; i++) {
+                int b = ival(b345[i]);
+                bitset |= b;
+                pb |= (long)b << ((i + 3) * PACKED_BYTE_SIZE);
+            }
+            if (!inRange(bitset))
+                return 0;
+            pb = pb | packedBytes(b0, b1, b2);
+            return pb;
+        }
+        private static long packedBytes(byte b0, int b1, int[] b234) {
+            if (b234.length + 2 > PACKED_BYTE_MAX_LENGTH)
+                return 0;
+            long pb = 0;
+            int bitset = b0 | b1;
+            for (int i = 0; i < b234.length; i++) {
+                int b = ival(b234[i]);
+                bitset |= b;
+                pb |= (long)b << ((i + 2) * PACKED_BYTE_SIZE);
+            }
+            if (!inRange(bitset))
+                return 0;
+            pb = pb | packedBytes(b0, b1);
+            return pb;
+        }
+        private static long packedBytes(byte b0, int[] b123) {
+            if (b123.length + 1 > PACKED_BYTE_MAX_LENGTH)
+                return 0;
+            long pb = 0;
+            int bitset = b0;
+            for (int i = 0; i < b123.length; i++) {
+                int b = ival(b123[i]);
+                bitset |= b;
+                pb |= (long)b << ((i + 1) * PACKED_BYTE_SIZE);
+            }
+            if (!inRange(bitset))
+                return 0;
+            pb = pb | b0;
+            return pb;
+        }
+
         private static long packedBytes(byte[] bytes) {
             if (!inRange(bytes[0]) || bytes.length > PACKED_BYTE_MAX_LENGTH)
                 return 0;
@@ -247,18 +299,18 @@ private static long packedBytes(byte[] bytes) {
         }
         private static long packedBytes(int b0, int b1) {
             assert(inRange(b0 | b1));
-            return (  (b0 << 0*PACKED_BYTE_SIZE)
+            return (  (b0)
                     | (b1 << 1*PACKED_BYTE_SIZE));
         }
         private static long packedBytes(int b0, int b1, int b2) {
             assert(inRange(b0 | b1 | b2));
-            return (  (b0 << 0*PACKED_BYTE_SIZE)
+            return (  (b0)
                     | (b1 << 1*PACKED_BYTE_SIZE)
                     | (b2 << 2*PACKED_BYTE_SIZE));
         }
         private static long packedBytes(int b0, int b1, int b2, int b3) {
             assert(inRange(b0 | b1 | b2 | b3));
-            return (  (b0 << 0*PACKED_BYTE_SIZE)
+            return (  (b0)
                     | (b1 << 1*PACKED_BYTE_SIZE)
                     | (b2 << 2*PACKED_BYTE_SIZE)
                     | (b3 << 3*PACKED_BYTE_SIZE));
@@ -320,7 +372,6 @@ private boolean equals(Transform that) {
         @Override
         public int hashCode() {
             if (packedBytes != 0) {
-                assert(fullBytes == null);
                 return Long.hashCode(packedBytes);
             }
             return Arrays.hashCode(fullBytes);
@@ -636,7 +687,7 @@ LambdaForm collectArgumentsForm(int pos, MethodType collectorType) {
         if (collectorArity == 1 && !dropResult) {
             return filterArgumentForm(pos, basicType(collectorType.parameterType(0)));
         }
-        byte[] newTypes = BasicType.basicTypesOrd(collectorType.ptypes());
+        int[] newTypes = BasicType.basicTypesOrd(collectorType.ptypes());
         byte kind = (dropResult ? COLLECT_ARGS_TO_VOID : COLLECT_ARGS);
         if (dropResult && collectorArity == 0)  pos = 1;  // pure side effect
         TransformKey key = TransformKey.of(kind, pos, collectorArity, newTypes);
@@ -887,8 +938,7 @@ private LambdaForm makeArgumentCombinationForm(int pos,
     }
 
     LambdaForm filterReturnForm(BasicType newType, boolean constantZero) {
-        byte kind = (constantZero ? FILTER_RETURN_TO_ZERO : FILTER_RETURN);
-        TransformKey key = TransformKey.of(kind, newType.ordinal());
+        TransformKey key = TransformKey.of(FILTER_RETURN, constantZero ? (byte) 1 : (byte)0, newType.ordinal());
         LambdaForm form = getInCache(key);
         if (form != null) {
             assert(form.arity == lambdaForm.arity);
@@ -1002,11 +1052,10 @@ LambdaForm foldArgumentsForm(int foldPos, boolean dropResult, MethodType combine
     }
 
     LambdaForm foldArgumentsForm(int foldPos, boolean dropResult, MethodType combinerType, int ... argPositions) {
-        byte kind = (dropResult ? FOLD_SELECT_ARGS_TO_VOID : FOLD_SELECT_ARGS);
-        TransformKey key = TransformKey.of(kind, foldPos, argPositions);
+        TransformKey key = TransformKey.of(FOLD_SELECT_ARGS, foldPos, dropResult ? 1 : 0, argPositions);
         LambdaForm form = getInCache(key);
         if (form != null) {
-            assert(form.arity == lambdaForm.arity - (kind == FOLD_SELECT_ARGS ? 1 : 0));
+            assert(form.arity == lambdaForm.arity - (dropResult ? 0 : 1));
             return form;
         }
         form = makeArgumentCombinationForm(foldPos, combinerType, argPositions, true, dropResult);