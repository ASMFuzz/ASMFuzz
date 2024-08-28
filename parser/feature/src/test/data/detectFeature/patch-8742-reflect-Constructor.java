@@ -73,6 +73,7 @@ public final class Constructor<T> extends Executable {
     // Generics and annotations support
     private final transient String    signature;
     // generic info repository; lazily initialized
+    @Stable
     private transient ConstructorRepository genericInfo;
     private final byte[]              annotations;
     private final byte[]              parameterAnnotations;
@@ -87,12 +88,14 @@ private GenericsFactory getFactory() {
     // Accessor for generic info repository
     @Override
     ConstructorRepository getGenericInfo() {
+        var genericInfo = this.genericInfo;
         // lazily initialize repository if necessary
         if (genericInfo == null) {
             // create and cache generic info repository
             genericInfo =
                 ConstructorRepository.make(getSignature(),
                                            getFactory());
+            this.genericInfo = genericInfo;
         }
         return genericInfo; //return cached repository
     }