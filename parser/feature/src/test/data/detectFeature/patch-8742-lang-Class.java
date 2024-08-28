@@ -79,6 +79,7 @@
 import jdk.internal.reflect.ReflectionFactory;
 import jdk.internal.vm.annotation.ForceInline;
 import jdk.internal.vm.annotation.IntrinsicCandidate;
+import jdk.internal.vm.annotation.Stable;
 import sun.invoke.util.Wrapper;
 import sun.reflect.generics.factory.CoreReflectionFactory;
 import sun.reflect.generics.factory.GenericsFactory;
@@ -3292,7 +3293,8 @@ private ReflectionData<T> newReflectionData(SoftReference<ReflectionData<T>> old
     private native String getGenericSignature0();
 
     // Generic info repository; lazily initialized
-    private transient volatile ClassRepository genericInfo;
+    @Stable
+    private transient ClassRepository genericInfo;
 
     // accessor for factory
     private GenericsFactory getFactory() {