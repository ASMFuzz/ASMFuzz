@@ -506,12 +506,16 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
             }
         }
 
+        MethodHandle newString = newString();
+        // This disables automatic preparation of MethodHandles (and the bytecode compilation of their LambdaForms)
+        // until MethodHandle.enablePreparation is called
+        MethodHandle.deferPreparation();
         // Start building the combinator tree. The tree "starts" with (<parameters>)String, and "finishes"
         // with the (byte[], long)String shape to invoke newString in StringConcatHelper. The combinators are
         // assembled bottom-up, which makes the code arguably hard to read.
 
         // Drop all remaining parameter types, leave only helper arguments:
-        MethodHandle mh = MethodHandles.dropArguments(newString(), 2, ptypes);
+        MethodHandle mh = MethodHandles.dropArguments(newString, 2, ptypes);
 
         long initialLengthCoder = INITIAL_CODER;
 
@@ -538,9 +542,11 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
                 constant = el;
             } else {
                 // Add prepender, along with any prefix constant
+                MethodHandle prepend = prepender(constant, ptypes[pos]);
+                prepend.prepare();
                 mh = MethodHandles.filterArgumentsWithCombiner(
                         mh, 1,
-                        prepender(constant, ptypes[pos]),
+                        prepend,
                         1, 0, // indexCoder, storage
                         2 + pos  // selected argument
                 );
@@ -564,6 +570,7 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         } else {
             newArrayCombinator = newArray();
         }
+        newArrayCombinator.prepare();
         mh = MethodHandles.foldArgumentsWithCombiner(mh, 0, newArrayCombinator,
                 1 // index
         );
@@ -594,6 +601,7 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
             if (el == null) {
                     if (pos >= 0) {
                         // Compute new "index" in-place using old value plus the appropriate argument.
+                        mix.prepare();
                         mh = MethodHandles.filterArgumentsWithCombiner(mh, 0, mix,
                                 0, // old-index
                                 1 + pos // selected argument
@@ -608,7 +616,9 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         // Insert the initialLengthCoder value into the final mixer, then
         // fold that into the base method handle
         if (pos >= 0) {
+            mix.prepare();
             mix = MethodHandles.insertArguments(mix, 0, initialLengthCoder);
+            mix.prepare();
             mh = MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
                     1 + pos // selected argument
             );
@@ -623,7 +633,8 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         if (filters != null) {
             mh = MethodHandles.filterArguments(mh, 0, filters);
         }
-
+        mh.prepare();
+        MethodHandle.reEnablePreparation();
         return mh;
     }
 
@@ -653,8 +664,9 @@ public MethodHandle apply(Class<?> c) {
     private static final Function<Class<?>, MethodHandle> NULL_PREPEND = new Function<>() {
         @Override
         public MethodHandle apply(Class<?> c) {
-            return MethodHandles.insertArguments(
-                    PREPENDERS.computeIfAbsent(c, PREPEND), 3, (String)null);
+            MethodHandle prepend = PREPENDERS.computeIfAbsent(c, PREPEND);
+            prepend.prepare();
+            return MethodHandles.insertArguments(prepend, 3, (String)null);
         }
     };
 