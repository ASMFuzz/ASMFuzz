@@ -82,6 +82,7 @@ public final class Method extends Executable {
     // Generics and annotations support
     private final transient String    signature;
     // generic info repository; lazily initialized
+    @Stable
     private transient MethodRepository genericInfo;
     private final byte[]              annotations;
     private final byte[]              parameterAnnotations;
@@ -108,11 +109,13 @@ private GenericsFactory getFactory() {
     // Accessor for generic info repository
     @Override
     MethodRepository getGenericInfo() {
+        var genericInfo = this.genericInfo;
         // lazily initialize repository if necessary
         if (genericInfo == null) {
             // create and cache generic info repository
             genericInfo = MethodRepository.make(getGenericSignature(),
                                                 getFactory());
+            this.genericInfo = genericInfo;
         }
         return genericInfo; //return cached repository
     }