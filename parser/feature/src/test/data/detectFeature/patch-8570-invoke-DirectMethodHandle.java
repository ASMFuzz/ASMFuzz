@@ -30,7 +30,6 @@
 import jdk.internal.vm.annotation.Stable;
 import sun.invoke.util.ValueConversions;
 import sun.invoke.util.VerifyAccess;
-import sun.invoke.util.VerifyType;
 import sun.invoke.util.Wrapper;
 
 import java.util.Arrays;
@@ -629,12 +628,14 @@ private static int afIndex(byte formOp, boolean isVolatile, int ftypeKind) {
     private static final LambdaForm[] ACCESSOR_FORMS
             = new LambdaForm[afIndex(AF_LIMIT, false, 0)];
     static int ftypeKind(Class<?> ftype) {
-        if (ftype.isPrimitive())
+        if (ftype.isPrimitive()) {
             return Wrapper.forPrimitiveType(ftype).ordinal();
-        else if (VerifyType.isNullReferenceConversion(Object.class, ftype))
+        } else if (ftype.isInterface() || ftype.isAssignableFrom(Object.class)) {
+            // retyping can be done without a cast
             return FT_UNCHECKED_REF;
-        else
+        } else {
             return FT_CHECKED_REF;
+        }
     }
 
     /**