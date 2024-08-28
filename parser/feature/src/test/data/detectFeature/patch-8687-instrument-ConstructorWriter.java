@@ -34,9 +34,9 @@
 
 final class ConstructorWriter extends MethodVisitor {
 
-    private boolean useInputParameter;
-    private String shortClassName;
-    private String fullClassName;
+    private final boolean useInputParameter;
+    private final String shortClassName;
+    private final String fullClassName;
 
     ConstructorWriter(Class<?> classToChange, boolean useInputParameter) {
         super(Opcodes.ASM7);