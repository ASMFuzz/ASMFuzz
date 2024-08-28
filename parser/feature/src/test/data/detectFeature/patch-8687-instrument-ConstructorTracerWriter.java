@@ -38,7 +38,8 @@
 
 final class ConstructorTracerWriter extends ClassVisitor {
 
-    private ConstructorWriter useInputParameter, noUseInputParameter;
+    private final ConstructorWriter useInputParameter;
+    private final ConstructorWriter noUseInputParameter;
 
     static byte[] generateBytes(Class<?> clz, byte[] oldBytes) throws IOException {
         InputStream in = new ByteArrayInputStream(oldBytes);