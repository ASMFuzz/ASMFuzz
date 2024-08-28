@@ -38,11 +38,11 @@
 
 public final class AnnotationConstruct {
 
-    private static final class AnnotationInvokationHandler implements InvocationHandler {
+    private static final class AnnotationInvocationHandler implements InvocationHandler {
 
         private final AnnotationElement annotationElement;
 
-        AnnotationInvokationHandler(AnnotationElement a) {
+        AnnotationInvocationHandler(AnnotationElement a) {
             this.annotationElement = a;
         }
 
@@ -91,7 +91,7 @@ public String getDescription() {
     public final <T> T getAnnotation(Class<? extends Annotation> clazz) {
         AnnotationElement ae = getAnnotationElement(clazz);
         if (ae != null) {
-            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] { clazz }, new AnnotationInvokationHandler(ae));
+            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] { clazz }, new AnnotationInvocationHandler(ae));
         }
         return null;
     }