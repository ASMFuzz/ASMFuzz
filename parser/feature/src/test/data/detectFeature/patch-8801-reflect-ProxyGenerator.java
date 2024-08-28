@@ -31,6 +31,7 @@
 import jdk.internal.org.objectweb.asm.MethodVisitor;
 import jdk.internal.org.objectweb.asm.Opcodes;
 import jdk.internal.org.objectweb.asm.Type;
+import sun.invoke.util.Wrapper;
 import sun.security.action.GetBooleanAction;
 
 import java.io.IOException;
@@ -39,7 +40,6 @@
 import java.nio.file.Path;
 import java.util.ArrayList;
 import java.util.Arrays;
-import java.util.HashMap;
 import java.util.LinkedHashMap;
 import java.util.List;
 import java.util.ListIterator;
@@ -813,21 +813,7 @@ private void codeWrapArgument(MethodVisitor mv, Class<?> type, int slot) {
             if (type.isPrimitive()) {
                 PrimitiveTypeInfo prim = PrimitiveTypeInfo.get(type);
 
-                if (type == int.class ||
-                        type == boolean.class ||
-                        type == byte.class ||
-                        type == char.class ||
-                        type == short.class) {
-                    mv.visitVarInsn(ILOAD, slot);
-                } else if (type == long.class) {
-                    mv.visitVarInsn(LLOAD, slot);
-                } else if (type == float.class) {
-                    mv.visitVarInsn(FLOAD, slot);
-                } else if (type == double.class) {
-                    mv.visitVarInsn(DLOAD, slot);
-                } else {
-                    throw new AssertionError();
-                }
+                mv.visitVarInsn(prim.loadOpcode, slot);
                 mv.visitMethodInsn(INVOKESTATIC, prim.wrapperClassName, "valueOf",
                         prim.wrapperValueOfDesc, false);
             } else {
@@ -849,21 +835,7 @@ private void codeUnwrapReturnValue(MethodVisitor mv, Class<?> type) {
                         prim.wrapperClassName,
                         prim.unwrapMethodName, prim.unwrapMethodDesc, false);
 
-                if (type == int.class ||
-                        type == boolean.class ||
-                        type == byte.class ||
-                        type == char.class ||
-                        type == short.class) {
-                    mv.visitInsn(IRETURN);
-                } else if (type == long.class) {
-                    mv.visitInsn(LRETURN);
-                } else if (type == float.class) {
-                    mv.visitInsn(FRETURN);
-                } else if (type == double.class) {
-                    mv.visitInsn(DRETURN);
-                } else {
-                    throw new AssertionError();
-                }
+                mv.visitInsn(prim.returnOpcode);
             } else {
                 mv.visitTypeInsn(CHECKCAST, dotToSlash(type.getName()));
                 mv.visitInsn(ARETURN);
@@ -952,65 +924,73 @@ public String toString() {
     }
 
     /**
-     * A PrimitiveTypeInfo object contains assorted information about
-     * a primitive type in its public fields.  The struct for a particular
+     * A PrimitiveTypeInfo object contains bytecode-related information about
+     * a primitive type in its instance fields. The struct for a particular
      * primitive type can be obtained using the static "get" method.
      */
-    private static class PrimitiveTypeInfo {
-
-        private static Map<Class<?>, PrimitiveTypeInfo> table = new HashMap<>();
-
-        static {
-            add(byte.class, Byte.class);
-            add(char.class, Character.class);
-            add(double.class, Double.class);
-            add(float.class, Float.class);
-            add(int.class, Integer.class);
-            add(long.class, Long.class);
-            add(short.class, Short.class);
-            add(boolean.class, Boolean.class);
-        }
+    private enum PrimitiveTypeInfo {
+        BYTE(byte.class, ILOAD, IRETURN),
+        CHAR(char.class, ILOAD, IRETURN),
+        DOUBLE(double.class, DLOAD, DRETURN),
+        FLOAT(float.class, FLOAD, FRETURN),
+        INT(int.class, ILOAD, IRETURN),
+        LONG(long.class, LLOAD, LRETURN),
+        SHORT(short.class, ILOAD, IRETURN),
+        BOOLEAN(boolean.class, ILOAD, IRETURN);
 
         /**
-         * name of corresponding wrapper class
+         * internal name of corresponding wrapper class
          */
-        private String wrapperClassName;
+        private final String wrapperClassName;
         /**
          * method descriptor for wrapper class "valueOf" factory method
          */
-        private String wrapperValueOfDesc;
+        private final String wrapperValueOfDesc;
         /**
          * name of wrapper class method for retrieving primitive value
          */
-        private String unwrapMethodName;
+        private final String unwrapMethodName;
         /**
          * descriptor of same method
          */
-        private String unwrapMethodDesc;
+        private final String unwrapMethodDesc;
+        /**
+         * Load opcode used by this primitive
+         */
+        private final int loadOpcode;
+        /**
+         * Return opcode used by this primitive
+         */
+        private final int returnOpcode;
 
-        private PrimitiveTypeInfo(Class<?> primitiveClass, Class<?> wrapperClass) {
+        PrimitiveTypeInfo(Class<?> primitiveClass, int loadOpcode, int returnOpcode) {
             assert primitiveClass.isPrimitive();
+            assert returnOpcode - IRETURN == loadOpcode - ILOAD;
 
-            /**
-             * "base type" used in various descriptors (see JVMS section 4.3.2)
-             */
-            String baseTypeString =
-                    Array.newInstance(primitiveClass, 0)
-                            .getClass().getName().substring(1);
-            wrapperClassName = dotToSlash(wrapperClass.getName());
+            Wrapper wrapper = Wrapper.forPrimitiveType(primitiveClass);
+            // single-char BaseType descriptor (see JVMS section 4.3.2)
+            String baseTypeString = wrapper.basicTypeString();
+            var wrapperType = wrapper.wrapperType();
+            wrapperClassName = dotToSlash(wrapperType.getName());
             wrapperValueOfDesc =
-                    "(" + baseTypeString + ")L" + wrapperClassName + ";";
+                    "(" + baseTypeString + ")" + wrapperType.descriptorString();
             unwrapMethodName = primitiveClass.getName() + "Value";
             unwrapMethodDesc = "()" + baseTypeString;
-        }
-
-        private static void add(Class<?> primitiveClass, Class<?> wrapperClass) {
-            table.put(primitiveClass,
-                    new PrimitiveTypeInfo(primitiveClass, wrapperClass));
+            this.loadOpcode = loadOpcode;
+            this.returnOpcode = returnOpcode;
         }
 
         public static PrimitiveTypeInfo get(Class<?> cl) {
-            return table.get(cl);
+            // Uses if chain for speed: 8284880
+            if (cl == int.class)     return INT;
+            if (cl == long.class)    return LONG;
+            if (cl == boolean.class) return BOOLEAN;
+            if (cl == short.class)   return SHORT;
+            if (cl == byte.class)    return BYTE;
+            if (cl == char.class)    return CHAR;
+            if (cl == float.class)   return FLOAT;
+            if (cl == double.class)  return DOUBLE;
+            throw new AssertionError(cl);
         }
     }
 }