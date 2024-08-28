@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -85,19 +85,6 @@ public static boolean isNullConversion(Class<?> src, Class<?> dst, boolean keepI
         return dw.bitWidth() > sw.bitWidth();
     }
 
-    /**
-     * Specialization of isNullConversion to reference types.
-     * @param src the type of a stacked value
-     * @param dst the reference type by which we'd like to treat it
-     * @return whether the retyping can be done without a cast
-     */
-    public static boolean isNullReferenceConversion(Class<?> src, Class<?> dst) {
-        assert(!dst.isPrimitive());
-        if (dst.isInterface())  return true;   // verifier allows this
-        if (isNullType(src))    return true;
-        return dst.isAssignableFrom(src);
-    }
-
     /**
      * Is the given type java.lang.Null or an equivalent null-only type?
      */
@@ -128,75 +115,4 @@ public static boolean isNullConversion(MethodType call, MethodType recv, boolean
                 return false;
         return isNullConversion(recv.returnType(), call.returnType(), keepInterfaces);
     }
-
-    /**
-     * Determine if the JVM verifier allows a value of type call to be
-     * passed to a formal parameter (or return variable) of type recv.
-     * Returns 1 if the verifier allows the types to match without conversion.
-     * Returns -1 if the types can be made to match by a JVM-supported adapter.
-     * Cases supported are:
-     * <ul><li>checkcast
-     * </li><li>conversion between any two integral types (but not floats)
-     * </li><li>unboxing from a wrapper to its corresponding primitive type
-     * </li><li>conversion in either direction between float and double
-     * </li></ul>
-     * (Autoboxing is not supported here; it must be done via Java code.)
-     * Returns 0 otherwise.
-     */
-    public static int canPassUnchecked(Class<?> src, Class<?> dst) {
-        if (src == dst)
-            return 1;
-
-        if (dst.isPrimitive()) {
-            if (dst == void.class)
-                // Return anything to a caller expecting void.
-                // This is a property of the implementation, which links
-                // return values via a register rather than via a stack push.
-                // This makes it possible to ignore cleanly.
-                return 1;
-            if (src == void.class)
-                return 0;  // void-to-something?
-            if (!src.isPrimitive())
-                // Cannot pass a reference to any primitive type (exc. void).
-                return 0;
-            Wrapper sw = Wrapper.forPrimitiveType(src);
-            Wrapper dw = Wrapper.forPrimitiveType(dst);
-            if (sw.isSubwordOrInt() && dw.isSubwordOrInt()) {
-                if (sw.bitWidth() >= dw.bitWidth())
-                    return -1;   // truncation may be required
-                if (!dw.isSigned() && sw.isSigned())
-                    return -1;   // sign elimination may be required
-                return 1;
-            }
-            if (src == float.class || dst == float.class) {
-                if (src == double.class || dst == double.class)
-                    return -1;   // floating conversion may be required
-                else
-                    return 0;    // other primitive conversions NYI
-            } else {
-                // all fixed-point conversions are supported
-                return 0;
-            }
-        } else if (src.isPrimitive()) {
-            // Cannot pass a primitive to any reference type.
-            // (Maybe allow null.class?)
-            return 0;
-        }
-
-        // Handle reference types in the rest of the block:
-
-        // The verifier treats interfaces exactly like Object.
-        if (isNullReferenceConversion(src, dst))
-            // pass any reference to object or an arb. interface
-            return 1;
-        // else it's a definite "maybe" (cast is required)
-        return -1;
-    }
-
-    public static boolean isSpreadArgType(Class<?> spreadArg) {
-        return spreadArg.isArray();
-    }
-    public static Class<?> spreadArgElementType(Class<?> spreadArg, int i) {
-        return spreadArg.getComponentType();
-    }
 }