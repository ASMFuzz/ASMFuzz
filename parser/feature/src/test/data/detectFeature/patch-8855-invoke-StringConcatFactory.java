@@ -31,12 +31,7 @@
 import sun.invoke.util.Wrapper;
 
 import java.lang.invoke.MethodHandles.Lookup;
-import java.util.ArrayList;
-import java.util.List;
 import java.util.Objects;
-import java.util.concurrent.ConcurrentHashMap;
-import java.util.concurrent.ConcurrentMap;
-import java.util.function.Function;
 
 import static java.lang.invoke.MethodType.methodType;
 
@@ -338,7 +333,7 @@ public static CallSite makeConcatWithConstants(MethodHandles.Lookup lookup,
                     lookup.lookupClass().getName());
         }
 
-        List<String> elements = parseRecipe(concatType, recipe, constants);
+        String[] constantStrings = parseRecipe(concatType, recipe, constants);
 
         if (!concatType.returnType().isAssignableFrom(String.class)) {
             throw new StringConcatException(
@@ -355,7 +350,7 @@ public static CallSite makeConcatWithConstants(MethodHandles.Lookup lookup,
 
         try {
             return new ConstantCallSite(
-                    generateMHInlineCopy(concatType, elements)
+                    generateMHInlineCopy(concatType, constantStrings)
                             .viewAsType(concatType, true));
         } catch (Error e) {
             // Pass through any error
@@ -365,15 +360,22 @@ public static CallSite makeConcatWithConstants(MethodHandles.Lookup lookup,
         }
     }
 
-    private static List<String> parseRecipe(MethodType concatType,
-                                            String recipe,
-                                            Object[] constants)
+    private static String[] parseRecipe(MethodType concatType,
+                                        String recipe,
+                                        Object[] constants)
         throws StringConcatException
     {
 
         Objects.requireNonNull(recipe, "Recipe is null");
-        // Element list containing String constants, or null for arguments
-        List<String> elements = new ArrayList<>();
+        int paramCount = concatType.parameterCount();
+        // Array containing interleaving String constants, starting with
+        // the first prefix and ending with the final prefix:
+        //
+        //   consts[0] + arg0 + consts[1] + arg 1 + ... + consts[paramCount].
+        //
+        // consts will be null if there's no constant to insert at a position.
+        // An empty String constant will be replaced by null.
+        String[] consts = new String[paramCount + 1];
 
         int cCount = 0;
         int oCount = 0;
@@ -392,31 +394,30 @@ private static List<String> parseRecipe(MethodType concatType,
                 // into the recipe
                 acc.append(constants[cCount++]);
             } else if (c == TAG_ARG) {
-                // Flush any accumulated characters into a constant
-                if (acc.length() > 0) {
-                    elements.add(acc.toString());
-                    acc.setLength(0);
+                // Check for overflow
+                if (oCount >= paramCount) {
+                    throw argumentMismatch(concatType, oCount);
                 }
-                elements.add(null);
-                oCount++;
+
+                // Flush any accumulated characters into a constant
+                consts[oCount++] = acc.length() > 0 ? acc.toString() : null;
+                acc.setLength(0);
             } else {
                 // Not a special character, this is a constant embedded into
                 // the recipe itself.
                 acc.append(c);
             }
         }
-
-        // Flush the remaining characters as constant:
-        if (acc.length() > 0) {
-            elements.add(acc.toString());
-        }
         if (oCount != concatType.parameterCount()) {
             throw argumentMismatch(concatType, oCount);
         }
         if (cCount < constants.length) {
             throw constantMismatch(constants, cCount);
         }
-        return elements;
+
+        // Flush the remaining characters as constant:
+        consts[oCount] = acc.length() > 0 ? acc.toString() : null;
+        return consts;
     }
 
     private static StringConcatException argumentMismatch(MethodType concatType,
@@ -445,49 +446,34 @@ private static StringConcatException constantMismatch(Object[] constants,
      * most notably, the private String constructor that accepts byte[] arrays
      * without copying.
      */
-    private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> elements) {
-
-        // Fast-path unary concatenations
-        if (elements.size() == 1) {
-            String s0 = elements.get(0);
-            if (s0 == null) {
-                return unaryConcat(mt.parameterType(0));
-            } else {
-                return MethodHandles.insertArguments(unaryConcat(Object.class), 0, s0);
-            }
-        }
-        // Fast-path binary concatenations
-        if (elements.size() == 2) {
-            // Two arguments
-            String s0 = elements.get(0);
-            String s1 = elements.get(1);
-
-            if (mt.parameterCount() == 2 &&
-                    !mt.parameterType(0).isPrimitive() &&
-                    !mt.parameterType(1).isPrimitive() &&
-                    s0 == null &&
-                    s1 == null) {
-                return simpleConcat();
-            } else if (mt.parameterCount() == 1) {
-                // One argument, one constant
-                String constant;
-                int constIdx;
-                if (s1 == null) {
-                    constant = s0;
-                    constIdx = 0;
-                } else {
-                    constant = s1;
-                    constIdx = 1;
-                }
-                if (constant.isEmpty()) {
+    private static MethodHandle generateMHInlineCopy(MethodType mt, String[] constants) {
+        int paramCount = mt.parameterCount();
+        String suffix = constants[paramCount];
+
+        // Fast-path trivial concatenations
+        if (paramCount == 0) {
+            return MethodHandles.insertArguments(newStringifier(), 0, suffix == null ? "" : suffix);
+        }
+        if (paramCount == 1) {
+            String prefix = constants[0];
+            // Empty constants will be
+            if (prefix == null) {
+                if (suffix == null) {
                     return unaryConcat(mt.parameterType(0));
-                } else if (!mt.parameterType(0).isPrimitive()) {
-                    // Non-primitive argument
-                    return MethodHandles.insertArguments(simpleConcat(), constIdx, constant);
-                }
-            }
-            // else... fall-through to slow-path
+                } else if (!mt.hasPrimitives()) {
+                    return MethodHandles.insertArguments(simpleConcat(), 1, suffix);
+                } // else fall-through
+            } else if (suffix == null && !mt.hasPrimitives()) {
+                // Non-primitive argument
+                return MethodHandles.insertArguments(simpleConcat(), 0, prefix);
+            } // fall-through if there's both a prefix and suffix
+        }
+        if (paramCount == 2 && !mt.hasPrimitives() && suffix == null
+                && constants[0] == null && constants[1] == null) {
+            // Two reference arguments, no surrounding constants
+            return simpleConcat();
         }
+        // else... fall-through to slow-path
 
         // Create filters and obtain filtered parameter types. Filters would be used in the beginning
         // to convert the incoming arguments into the arguments we can process (e.g. Objects -> Strings).
@@ -525,54 +511,31 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         // Drop all remaining parameter types, leave only helper arguments:
         MethodHandle mh = MethodHandles.dropArguments(newString(), 2, ptypes);
 
+        // Calculate the initialLengthCoder value by looking at all constant values and summing up
+        // their lengths and adjusting the encoded coder bit if needed
         long initialLengthCoder = INITIAL_CODER;
 
+        for (String constant : constants) {
+            if (constant != null) {
+                initialLengthCoder = JLA.stringConcatMix(initialLengthCoder, constant);
+            }
+        }
+
         // Mix in prependers. This happens when (byte[], long) = (storage, indexCoder) is already
         // known from the combinators below. We are assembling the string backwards, so the index coded
         // into indexCoder is the *ending* index.
-
-        // We need one prepender per argument, but also need to fold in constants. We do so by greedily
-        // create prependers that fold in surrounding constants into the argument prepender. This reduces
-        // the number of unique MH combinator tree shapes we'll create in an application.
-        String constant = null;
-        int pos = 0;
-        for (String el : elements) {
-            // Do the prepend, and put "new" index at index 1
-            if (el != null) {
-                // Constant element
-
-                // Eagerly update the initialLengthCoder value
-                initialLengthCoder = JLA.stringConcatMix(initialLengthCoder, el);
-
-                // Save the constant and fold it either into the next
-                // argument prepender, or into the newArray combinator
-                assert (constant == null);
-                constant = el;
-            } else {
-                // Add prepender, along with any prefix constant
-                mh = MethodHandles.filterArgumentsWithCombiner(
-                        mh, 1,
-                        prepender(constant, ptypes[pos]),
-                        1, 0, // indexCoder, storage
-                        2 + pos  // selected argument
-                );
-                constant = null;
-                pos++;
-            }
-        }
+        mh = filterInPrependers(mh, constants, ptypes);
 
         // Fold in byte[] instantiation at argument 0
         MethodHandle newArrayCombinator;
-        if (constant != null) {
-            // newArray variant that deals with prepending the trailing constant
+        if (suffix != null) {
+            // newArray variant that deals with prepending any trailing constant
             //
-            // initialLengthCoder has been adjusted to have the correct coder
-            // and length already, but to avoid binding an extra variable to
-            // the method handle we now adjust the length to be correct for the
-            // first prepender above, while adjusting for the missing length of
-            // the constant in StringConcatHelper
-            initialLengthCoder -= constant.length();
-            newArrayCombinator = newArrayWithSuffix(constant);
+            // initialLengthCoder is adjusted to have the correct coder
+            // and length: The newArrayWithSuffix method expects only the coder of the
+            // suffix to be encoded into indexCoder
+            initialLengthCoder -= suffix.length();
+            newArrayCombinator = newArrayWithSuffix(suffix);
         } else {
             newArrayCombinator = newArray();
         }
@@ -599,35 +562,7 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         // combined in as:
         //   (<args>)String = (<args>)
 
-        pos = -1;
-        MethodHandle mix = null;
-        for (String el : elements) {
-            // Constants already handled in the code above
-            if (el == null) {
-                    if (pos >= 0) {
-                        // Compute new "index" in-place using old value plus the appropriate argument.
-                        mh = MethodHandles.filterArgumentsWithCombiner(mh, 0, mix,
-                                0, // old-index
-                                1 + pos // selected argument
-                        );
-                    }
-
-                    Class<?> argClass = ptypes[++pos];
-                    mix = mixer(argClass);
-            }
-        }
-
-        // Insert the initialLengthCoder value into the final mixer, then
-        // fold that into the base method handle
-        if (pos >= 0) {
-            mix = MethodHandles.insertArguments(mix, 0, initialLengthCoder);
-            mh = MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
-                    1 + pos // selected argument
-            );
-        } else {
-            // No mixer (constants only concat), insert initialLengthCoder directly
-            mh = MethodHandles.insertArguments(mh, 0, initialLengthCoder);
-        }
+        mh = filterAndFoldInMixers(mh, initialLengthCoder, ptypes);
 
         // The method handle shape here is (<args>).
 
@@ -639,45 +574,247 @@ private static MethodHandle generateMHInlineCopy(MethodType mt, List<String> ele
         return mh;
     }
 
-    private static MethodHandle prepender(String prefix, Class<?> cl) {
-        if (prefix == null) {
-            return NULL_PREPENDERS.computeIfAbsent(cl, NULL_PREPEND);
+    // We need one prepender per argument, but also need to fold in constants. We do so by greedily
+    // creating prependers that fold in surrounding constants into the argument prepender. This reduces
+    // the number of unique MH combinator tree shapes we'll create in an application.
+    // Additionally we do this in chunks to reduce the number of combinators bound to the root tree,
+    // which simplifies the shape and makes construction of similar trees use less unique LF classes
+    private static MethodHandle filterInPrependers(MethodHandle mh, String[] constants, Class<?>[] ptypes) {
+        int pos;
+        int[] argPositions = null;
+        MethodHandle prepend;
+        for (pos = 0; pos < ptypes.length - 3; pos += 4) {
+            prepend = prepender(pos, constants, ptypes, 4);
+            argPositions = filterPrependArgPositions(argPositions, pos, 4);
+            mh = MethodHandles.filterArgumentsWithCombiner(mh, 1, prepend, argPositions);
+        }
+        if (pos < ptypes.length) {
+            int count = ptypes.length - pos;
+            prepend = prepender(pos, constants, ptypes, count);
+            argPositions = filterPrependArgPositions(argPositions, pos, count);
+            mh = MethodHandles.filterArgumentsWithCombiner(mh, 1, prepend, argPositions);
         }
-        return MethodHandles.insertArguments(
-                        PREPENDERS.computeIfAbsent(cl, PREPEND), 3, prefix);
+        return mh;
     }
 
-    private static MethodHandle mixer(Class<?> cl) {
-        return MIXERS.computeIfAbsent(cl, MIX);
+    static int[] filterPrependArgPositions(int[] argPositions, int pos, int count) {
+        if (argPositions == null || argPositions.length != count + 2) {
+            argPositions = new int[count + 2];
+            argPositions[0] = 1; // indexCoder
+            argPositions[1] = 0; // storage
+        }
+        int limit = count + 2;
+        for (int i = 2; i < limit; i++) {
+            argPositions[i] = i + pos;
+        }
+        return argPositions;
+    }
+
+
+    // We need one mixer per argument.
+    private static MethodHandle filterAndFoldInMixers(MethodHandle mh, long initialLengthCoder, Class<?>[] ptypes) {
+        int pos;
+        int[] argPositions = null;
+        for (pos = 0; pos < ptypes.length - 4; pos += 4) {
+            // Compute new "index" in-place pairwise using old value plus the appropriate arguments.
+            MethodHandle mix = mixer(ptypes[pos], ptypes[pos + 1], ptypes[pos + 2], ptypes[pos + 3]);
+            argPositions = filterMixerArgPositions(argPositions, pos, 4);
+            mh = MethodHandles.filterArgumentsWithCombiner(mh, 0,
+                    mix, argPositions);
+        }
+
+        if (pos < ptypes.length) {
+            // Mix in the last 1 to 4 parameters, insert the initialLengthCoder into the final mixer and
+            // fold the result into the main combinator
+            mh = foldInLastMixers(mh, initialLengthCoder, pos, ptypes, ptypes.length - pos);
+        } else if (ptypes.length == 0) {
+            // No mixer (constants only concat), insert initialLengthCoder directly
+            mh = MethodHandles.insertArguments(mh, 0, initialLengthCoder);
+        }
+        return mh;
+    }
+
+    static int[] filterMixerArgPositions(int[] argPositions, int pos, int count) {
+        if (argPositions == null || argPositions.length != count + 2) {
+            argPositions = new int[count + 1];
+            argPositions[0] = 0; // indexCoder
+        }
+        int limit = count + 1;
+        for (int i = 1; i < limit; i++) {
+            argPositions[i] = i + pos;
+        }
+        return argPositions;
+    }
+
+
+    private static MethodHandle foldInLastMixers(MethodHandle mh, long initialLengthCoder, int pos, Class<?>[] ptypes, int count) {
+        MethodHandle mix = switch (count) {
+            case 1 -> mixer(ptypes[pos]);
+            case 2 -> mixer(ptypes[pos], ptypes[pos + 1]);
+            case 3 -> mixer(ptypes[pos], ptypes[pos + 1], ptypes[pos + 2]);
+            case 4 -> mixer(ptypes[pos], ptypes[pos + 1], ptypes[pos + 2], ptypes[pos + 3]);
+            default -> throw new IllegalArgumentException("Unexpected count: " + count);
+        };
+        mix = MethodHandles.insertArguments(mix,0, initialLengthCoder);
+        // apply selected arguments on the 1-4 arg mixer and fold in the result
+        return switch (count) {
+            case 1 -> MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
+                    1 + pos);
+            case 2 -> MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
+                    1 + pos, 2 + pos);
+            case 3 -> MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
+                    1 + pos, 2 + pos, 3 + pos);
+            case 4 -> MethodHandles.foldArgumentsWithCombiner(mh, 0, mix,
+                    1 + pos, 2 + pos, 3 + pos, 4 + pos);
+            default -> throw new IllegalArgumentException();
+        };
     }
 
-    // These are deliberately not lambdas to optimize startup time:
-    private static final Function<Class<?>, MethodHandle> PREPEND = new Function<>() {
-        @Override
-        public MethodHandle apply(Class<?> c) {
-            MethodHandle prepend = JLA.stringConcatHelper("prepend",
+    // Simple prependers, single argument. May be used directly or as a
+    // building block for complex prepender combinators.
+    private static MethodHandle prepender(String prefix, Class<?> cl) {
+        MethodHandle prepend;
+        int idx = classIndex(cl);
+        if (prefix == null) {
+            prepend = NULL_PREPENDERS[idx];
+            if (prepend == null) {
+                NULL_PREPENDERS[idx] = prepend = MethodHandles.insertArguments(
+                                prepender(cl), 3, (String)null);
+            }
+        } else {
+            prepend = MethodHandles.insertArguments(
+                    prepender(cl), 3, prefix);
+        }
+        return prepend;
+    }
+
+    private static MethodHandle prepender(Class<?> cl) {
+        int idx = classIndex(cl);
+        MethodHandle prepend = PREPENDERS[idx];
+        if (prepend == null) {
+            PREPENDERS[idx] = prepend = JLA.stringConcatHelper("prepend",
                     methodType(long.class, long.class, byte[].class,
-                            Wrapper.asPrimitiveType(c), String.class));
-            return prepend.rebind();
+                            Wrapper.asPrimitiveType(cl), String.class)).rebind();
         }
-    };
+        return prepend;
+    }
+
+    private static final int INT_IDX = 0,
+            CHAR_IDX = 1,
+            LONG_IDX = 2,
+            BOOLEAN_IDX = 3,
+            STRING_IDX = 4,
+            TYPE_COUNT = 5;
+    private static int classIndex(Class<?> cl) {
+        if (cl == String.class)  return STRING_IDX;
+        if (cl == int.class)     return INT_IDX;
+        if (cl == boolean.class) return BOOLEAN_IDX;
+        if (cl == char.class)    return CHAR_IDX;
+        if (cl == long.class)    return LONG_IDX;
+        throw new IllegalArgumentException("Unexpected class: " + cl);
+    }
 
-    private static final Function<Class<?>, MethodHandle> NULL_PREPEND = new Function<>() {
-        @Override
-        public MethodHandle apply(Class<?> c) {
-            return MethodHandles.insertArguments(
-                    PREPENDERS.computeIfAbsent(c, PREPEND), 3, (String)null);
+    // Constant argument lists used by the prepender MH builders
+    private static final int[] PREPEND_FILTER_FIRST_ARGS  = new int[] { 0, 1, 2 };
+    private static final int[] PREPEND_FILTER_SECOND_ARGS = new int[] { 0, 1, 3 };
+    private static final int[] PREPEND_FILTER_THIRD_ARGS  = new int[] { 0, 1, 4 };
+    private static final int[] PREPEND_FILTER_FIRST_PAIR_ARGS  = new int[] { 0, 1, 2, 3 };
+    private static final int[] PREPEND_FILTER_SECOND_PAIR_ARGS = new int[] { 0, 1, 4, 5 };
+
+    // Base MH for complex prepender combinators.
+    private static final MethodHandle PREPEND_BASE = MethodHandles.dropArguments(
+            MethodHandles.identity(long.class), 1, byte[].class);
+
+    private static final @Stable MethodHandle[][] DOUBLE_PREPENDERS = new MethodHandle[TYPE_COUNT][TYPE_COUNT];
+
+    private static MethodHandle prepender(String prefix, Class<?> cl, String prefix2, Class<?> cl2) {
+        int idx1 = classIndex(cl);
+        int idx2 = classIndex(cl2);
+        MethodHandle prepend = DOUBLE_PREPENDERS[idx1][idx2];
+        if (prepend == null) {
+            prepend = DOUBLE_PREPENDERS[idx1][idx2] =
+                    MethodHandles.dropArguments(PREPEND_BASE, 2, cl, cl2);
+        }
+        prepend = MethodHandles.filterArgumentsWithCombiner(prepend, 0, prepender(prefix, cl),
+                PREPEND_FILTER_FIRST_ARGS);
+        return MethodHandles.filterArgumentsWithCombiner(prepend, 0, prepender(prefix2, cl2),
+                PREPEND_FILTER_SECOND_ARGS);
+    }
+
+    private static MethodHandle prepender(int pos, String[] constants, Class<?>[] ptypes, int count) {
+        // build the simple cases directly
+        if (count == 1) {
+            return prepender(constants[pos], ptypes[pos]);
+        }
+        if (count == 2) {
+            return prepender(constants[pos], ptypes[pos], constants[pos + 1], ptypes[pos + 1]);
+        }
+        // build a tree from an unbound prepender, allowing us to bind the constants in a batch as a final step
+        MethodHandle prepend = PREPEND_BASE;
+        if (count == 3) {
+            prepend = MethodHandles.dropArguments(prepend, 2,
+                    ptypes[pos], ptypes[pos + 1], ptypes[pos + 2]);
+            prepend = MethodHandles.filterArgumentsWithCombiner(prepend, 0,
+                    prepender(constants[pos], ptypes[pos], constants[pos + 1], ptypes[pos + 1]),
+                    PREPEND_FILTER_FIRST_PAIR_ARGS);
+            return MethodHandles.filterArgumentsWithCombiner(prepend, 0,
+                    prepender(constants[pos + 2], ptypes[pos + 2]),
+                    PREPEND_FILTER_THIRD_ARGS);
+        } else if (count == 4) {
+            prepend = MethodHandles.dropArguments(prepend, 2,
+                    ptypes[pos], ptypes[pos + 1], ptypes[pos + 2], ptypes[pos + 3]);
+            prepend = MethodHandles.filterArgumentsWithCombiner(prepend, 0,
+                    prepender(constants[pos], ptypes[pos], constants[pos + 1], ptypes[pos + 1]),
+                    PREPEND_FILTER_FIRST_PAIR_ARGS);
+            return MethodHandles.filterArgumentsWithCombiner(prepend, 0,
+                    prepender(constants[pos + 2], ptypes[pos + 2], constants[pos + 3], ptypes[pos + 3]),
+                    PREPEND_FILTER_SECOND_PAIR_ARGS);
+        } else {
+            throw new IllegalArgumentException("Unexpected count: " + count);
         }
-    };
+    }
 
-    private static final Function<Class<?>, MethodHandle> MIX = new Function<>() {
-        @Override
-        public MethodHandle apply(Class<?> c) {
-            MethodHandle mix = JLA.stringConcatHelper("mix",
-                    methodType(long.class, long.class, Wrapper.asPrimitiveType(c)));
-            return mix.rebind();
+    // Constant argument lists used by the mixer MH builders
+    private static final int[] MIX_FILTER_SECOND_ARGS = new int[] { 0, 2 };
+    private static final int[] MIX_FILTER_THIRD_ARGS  = new int[] { 0, 3 };
+    private static final int[] MIX_FILTER_SECOND_PAIR_ARGS = new int[] { 0, 3, 4 };
+    private static MethodHandle mixer(Class<?> cl) {
+        int index = classIndex(cl);
+        MethodHandle mix = MIXERS[index];
+        if (mix == null) {
+            MIXERS[index] = mix = JLA.stringConcatHelper("mix",
+                    methodType(long.class, long.class, Wrapper.asPrimitiveType(cl))).rebind();
         }
-    };
+        return mix;
+    }
+
+    private static final @Stable MethodHandle[][] DOUBLE_MIXERS = new MethodHandle[TYPE_COUNT][TYPE_COUNT];
+    private static MethodHandle mixer(Class<?> cl, Class<?> cl2) {
+        int idx1 = classIndex(cl);
+        int idx2 = classIndex(cl2);
+        MethodHandle mix = DOUBLE_MIXERS[idx1][idx2];
+        if (mix == null) {
+            mix = mixer(cl);
+            mix = MethodHandles.dropArguments(mix, 2, cl2);
+            DOUBLE_MIXERS[idx1][idx2] = mix = MethodHandles.filterArgumentsWithCombiner(mix, 0,
+                    mixer(cl2), MIX_FILTER_SECOND_ARGS);
+        }
+        return mix;
+    }
+
+    private static MethodHandle mixer(Class<?> cl, Class<?> cl2, Class<?> cl3) {
+        MethodHandle mix = mixer(cl, cl2);
+        mix = MethodHandles.dropArguments(mix, 3, cl3);
+        return MethodHandles.filterArgumentsWithCombiner(mix, 0,
+                mixer(cl3), MIX_FILTER_THIRD_ARGS);
+    }
+
+    private static MethodHandle mixer(Class<?> cl, Class<?> cl2, Class<?> cl3, Class<?> cl4) {
+        MethodHandle mix = mixer(cl, cl2);
+        mix = MethodHandles.dropArguments(mix, 3, cl3, cl4);
+        return MethodHandles.filterArgumentsWithCombiner(mix, 0,
+                mixer(cl3, cl4), MIX_FILTER_SECOND_PAIR_ARGS);
+    }
 
     private @Stable static MethodHandle SIMPLE_CONCAT;
     private static MethodHandle simpleConcat() {
@@ -740,17 +877,15 @@ private static MethodHandle objectStringifier() {
     private static MethodHandle floatStringifier() {
         MethodHandle mh = FLOAT_STRINGIFIER;
         if (mh == null) {
-            FLOAT_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, float.class);
+            FLOAT_STRINGIFIER = mh = stringValueOf(float.class);
         }
         return mh;
     }
     private @Stable static MethodHandle DOUBLE_STRINGIFIER;
     private static MethodHandle doubleStringifier() {
         MethodHandle mh = DOUBLE_STRINGIFIER;
         if (mh == null) {
-            DOUBLE_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, double.class);
+            DOUBLE_STRINGIFIER = mh = stringValueOf(double.class);
         }
         return mh;
     }
@@ -759,8 +894,7 @@ private static MethodHandle doubleStringifier() {
     private static MethodHandle intStringifier() {
         MethodHandle mh = INT_STRINGIFIER;
         if (mh == null) {
-            INT_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, int.class);
+            INT_STRINGIFIER = mh = stringValueOf(int.class);
         }
         return mh;
     }
@@ -769,8 +903,7 @@ private static MethodHandle intStringifier() {
     private static MethodHandle longStringifier() {
         MethodHandle mh = LONG_STRINGIFIER;
         if (mh == null) {
-            LONG_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, long.class);
+            LONG_STRINGIFIER = mh = stringValueOf(long.class);
         }
         return mh;
     }
@@ -779,8 +912,7 @@ private static MethodHandle longStringifier() {
     private static MethodHandle charStringifier() {
         MethodHandle mh = CHAR_STRINGIFIER;
         if (mh == null) {
-            CHAR_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, char.class);
+            CHAR_STRINGIFIER = mh = stringValueOf(char.class);
         }
         return mh;
     }
@@ -789,8 +921,7 @@ private static MethodHandle charStringifier() {
     private static MethodHandle booleanStringifier() {
         MethodHandle mh = BOOLEAN_STRINGIFIER;
         if (mh == null) {
-            BOOLEAN_STRINGIFIER = mh =
-                    lookupStatic(MethodHandles.publicLookup(), String.class, "valueOf", String.class, boolean.class);
+            BOOLEAN_STRINGIFIER = mh = stringValueOf(boolean.class);
         }
         return mh;
     }
@@ -825,22 +956,15 @@ private static MethodHandle unaryConcat(Class<?> cl) {
         }
     }
 
-    private static final ConcurrentMap<Class<?>, MethodHandle> PREPENDERS;
-    private static final ConcurrentMap<Class<?>, MethodHandle> NULL_PREPENDERS;
-    private static final ConcurrentMap<Class<?>, MethodHandle> MIXERS;
-    private static final long INITIAL_CODER;
-
-    static {
-        INITIAL_CODER = JLA.stringConcatInitialCoder();
-        PREPENDERS = new ConcurrentHashMap<>();
-        NULL_PREPENDERS = new ConcurrentHashMap<>();
-        MIXERS = new ConcurrentHashMap<>();
-    }
+    private static final @Stable MethodHandle[] NULL_PREPENDERS = new MethodHandle[TYPE_COUNT];
+    private static final @Stable MethodHandle[] PREPENDERS      = new MethodHandle[TYPE_COUNT];
+    private static final @Stable MethodHandle[] MIXERS          = new MethodHandle[TYPE_COUNT];
+    private static final long INITIAL_CODER = JLA.stringConcatInitialCoder();
 
-    private static MethodHandle lookupStatic(Lookup lookup, Class<?> refc, String name,
-                                     Class<?> rtype, Class<?>... ptypes) {
+    private static MethodHandle stringValueOf(Class<?> ptype) {
         try {
-            return lookup.findStatic(refc, name, MethodType.methodType(rtype, ptypes));
+            return MethodHandles.publicLookup()
+                .findStatic(String.class, "valueOf", MethodType.methodType(String.class, ptype));
         } catch (NoSuchMethodException | IllegalAccessException e) {
             throw new AssertionError(e);
         }