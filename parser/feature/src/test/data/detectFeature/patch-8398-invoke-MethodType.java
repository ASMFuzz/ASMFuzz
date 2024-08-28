@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -240,7 +240,7 @@ private static IndexOutOfBoundsException newIndexOutOfBoundsException(Object num
      * @throws IllegalArgumentException if any element of {@code ptypes} is {@code void.class}
      */
     public static MethodType methodType(Class<?> rtype, Class<?>[] ptypes) {
-        return makeImpl(rtype, ptypes, false);
+        return methodType(rtype, ptypes, false);
     }
 
     /**
@@ -254,7 +254,7 @@ public static MethodType methodType(Class<?> rtype, Class<?>[] ptypes) {
      */
     public static MethodType methodType(Class<?> rtype, List<Class<?>> ptypes) {
         boolean notrust = false;  // random List impl. could return evil ptypes array
-        return makeImpl(rtype, listToArray(ptypes), notrust);
+        return methodType(rtype, listToArray(ptypes), notrust);
     }
 
     private static Class<?>[] listToArray(List<Class<?>> ptypes) {
@@ -275,9 +275,23 @@ private static Class<?>[] listToArray(List<Class<?>> ptypes) {
      * @throws IllegalArgumentException if {@code ptype0} or {@code ptypes} or any element of {@code ptypes} is {@code void.class}
      */
     public static MethodType methodType(Class<?> rtype, Class<?> ptype0, Class<?>... ptypes) {
-        Class<?>[] ptypes1 = new Class<?>[1+ptypes.length];
+        int len = ptypes.length;
+        if (rtype == Object.class && ptype0 == Object.class) {
+            if (len == 0) {
+                return genericMethodType(1, false);
+            }
+            if (isAllObject(ptypes, len - 1)) {
+                Class<?> lastParam = ptypes[len - 1];
+                if (lastParam == Object.class) {
+                    return genericMethodType(len + 1, false);
+                } else if (lastParam == Object[].class) {
+                    return genericMethodType(len, true);
+                }
+            }
+        }
+        Class<?>[] ptypes1 = new Class<?>[1 + len];
         ptypes1[0] = ptype0;
-        System.arraycopy(ptypes, 0, ptypes1, 1, ptypes.length);
+        System.arraycopy(ptypes, 0, ptypes1, 1, len);
         return makeImpl(rtype, ptypes1, true);
     }
 
@@ -290,6 +304,9 @@ public static MethodType methodType(Class<?> rtype, Class<?> ptype0, Class<?>...
      * @throws NullPointerException if {@code rtype} is null
      */
     public static MethodType methodType(Class<?> rtype) {
+        if (rtype == Object.class) {
+            return genericMethodType(0, false);
+        }
         return makeImpl(rtype, NO_PTYPES, true);
     }
 
@@ -304,6 +321,13 @@ public static MethodType methodType(Class<?> rtype) {
      * @throws IllegalArgumentException if {@code ptype0} is {@code void.class}
      */
     public static MethodType methodType(Class<?> rtype, Class<?> ptype0) {
+        if (rtype == Object.class) {
+            if (ptype0 == Object.class) {
+                return genericMethodType(1, false);
+            } else if (ptype0 == Object[].class) {
+                return genericMethodType(0, true);
+            }
+        }
         return makeImpl(rtype, new Class<?>[]{ ptype0 }, true);
     }
 
@@ -318,7 +342,35 @@ public static MethodType methodType(Class<?> rtype, Class<?> ptype0) {
      * @throws NullPointerException if {@code rtype} or {@code ptypes} is null
      */
     public static MethodType methodType(Class<?> rtype, MethodType ptypes) {
-        return makeImpl(rtype, ptypes.ptypes, true);
+        return methodType(rtype, ptypes.ptypes, true);
+    }
+
+    private static boolean isAllObject(Class<?>[] ptypes, int to) {
+        for (int i = 0; i < to; i++) {
+            if (ptypes[i] != Object.class) {
+                return false;
+            }
+        }
+        return true;
+    }
+
+    /*trusted*/
+    static MethodType methodType(Class<?> rtype, Class<?>[] ptypes, boolean trusted) {
+        if (rtype == Object.class) {
+            int last = ptypes.length - 1;
+            if (last < 0) {
+                return genericMethodType(0, false);
+            }
+            if (isAllObject(ptypes, last)) {
+                Class<?> lastParam = ptypes[last];
+                if (lastParam == Object.class) {
+                    return genericMethodType(last + 1, false);
+                } else if (lastParam == Object[].class) {
+                    return genericMethodType(last, true);
+                }
+            }
+        }
+        return makeImpl(rtype, ptypes, trusted);
     }
 
     /**
@@ -332,8 +384,7 @@ public static MethodType methodType(Class<?> rtype, MethodType ptypes) {
      * @throws IllegalArgumentException if any element of {@code ptypes} is {@code void.class}
      * @return the unique method type of the desired structure
      */
-    /*trusted*/
-    static MethodType makeImpl(Class<?> rtype, Class<?>[] ptypes, boolean trusted) {
+    private static MethodType makeImpl(Class<?> rtype, Class<?>[] ptypes, boolean trusted) {
         if (ptypes.length == 0) {
             ptypes = NO_PTYPES; trusted = true;
         }
@@ -629,7 +680,7 @@ public MethodType dropParameterTypes(int start, int end) {
                 System.arraycopy(ptypes, end, nptypes, start, tail);
             }
         }
-        return makeImpl(rtype, nptypes, true);
+        return methodType(rtype, nptypes, true);
     }
 
     /**
@@ -641,7 +692,7 @@ public MethodType dropParameterTypes(int start, int end) {
      */
     public MethodType changeReturnType(Class<?> nrtype) {
         if (returnType() == nrtype)  return this;
-        return makeImpl(nrtype, ptypes, true);
+        return methodType(nrtype, ptypes, true);
     }
 
     /**
@@ -1164,7 +1215,7 @@ static MethodType fromDescriptor(String descriptor, ClassLoader loader)
         List<Class<?>> types = BytecodeDescriptor.parseMethod(descriptor, loader);
         Class<?> rtype = types.remove(types.size() - 1);
         Class<?>[] ptypes = listToArray(types);
-        return makeImpl(rtype, ptypes, true);
+        return methodType(rtype, ptypes, true);
     }
 
     /**