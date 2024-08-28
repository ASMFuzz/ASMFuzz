@@ -28,7 +28,7 @@
 import jdk.jfr.internal.Type;
 
 final class ConstantLookup {
-    final Type type;
+    private final Type type;
     private ConstantMap current;
     private ConstantMap previous = ConstantMap.EMPTY;
 