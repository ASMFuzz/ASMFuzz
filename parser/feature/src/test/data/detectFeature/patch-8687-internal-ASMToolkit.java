@@ -33,40 +33,26 @@
 import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
 import jdk.jfr.ValueDescriptor;
 
-public final class ASMToolkit {
+final class ASMToolkit {
     public static final Type TYPE_STRING = Type.getType(String.class);
     private static final Type TYPE_THREAD = Type.getType(Thread.class);
     private static final Type TYPE_CLASS = Type.getType(Class.class);
 
     public static Type toType(ValueDescriptor v) {
-        String typeName = v.getTypeName();
-
-        switch (typeName) {
-        case "byte":
-            return Type.BYTE_TYPE;
-        case "short":
-            return Type.SHORT_TYPE;
-        case "int":
-            return Type.INT_TYPE;
-        case "long":
-            return Type.LONG_TYPE;
-        case "double":
-            return Type.DOUBLE_TYPE;
-        case "float":
-            return Type.FLOAT_TYPE;
-        case "char":
-            return Type.CHAR_TYPE;
-        case "boolean":
-            return Type.BOOLEAN_TYPE;
-        case "java.lang.String":
-            return TYPE_STRING;
-        case "java.lang.Thread":
-            return TYPE_THREAD;
-        case "java.lang.Class":
-            return TYPE_CLASS;
-        }
-        // Add support for SettingControl?
-       throw new Error("Not a valid type " + v.getTypeName());
+        return switch (v.getTypeName()) {
+            case "byte" -> Type.BYTE_TYPE;
+            case "short" -> Type.SHORT_TYPE;
+            case "int" ->  Type.INT_TYPE;
+            case "long" ->Type.LONG_TYPE;
+            case "double" -> Type.DOUBLE_TYPE;
+            case "float" -> Type.FLOAT_TYPE;
+            case "char" -> Type.CHAR_TYPE;
+            case "boolean" -> Type.BOOLEAN_TYPE;
+            case "java.lang.String" -> TYPE_STRING;
+            case "java.lang.Thread" -> TYPE_THREAD;
+            case "java.lang.Class" -> TYPE_CLASS;
+            default -> throw new Error("Not a valid type " + v.getTypeName());
+        };
     }
 
     /**
@@ -78,32 +64,17 @@ public static Type toType(ValueDescriptor v) {
      * @return descriptor
      */
     public static String getDescriptor(String typeName) {
-        if ("int".equals(typeName)) {
-            return "I";
-        }
-        if ("long".equals(typeName)) {
-            return "J";
-        }
-        if ("boolean".equals(typeName)) {
-            return "Z";
-        }
-        if ("float".equals(typeName)) {
-            return "F";
-        }
-        if ("double".equals(typeName)) {
-            return "D";
-        }
-        if ("short".equals(typeName)) {
-            return "S";
-        }
-        if ("char".equals(typeName)) {
-            return "C";
-        }
-        if ("byte".equals(typeName)) {
-            return "B";
-        }
-        String internal = getInternalName(typeName);
-        return Type.getObjectType(internal).getDescriptor();
+        return switch (typeName) {
+            case "int" -> "I";
+            case "long" -> "J";
+            case "boolean" -> "Z";
+            case "float" -> "F";
+            case "double" -> "D";
+            case "short" -> "S";
+            case "char" -> "C";
+            case "byte" -> "B";
+            default -> Type.getObjectType(getInternalName(typeName)).getDescriptor();
+        };
     }
 
     /**