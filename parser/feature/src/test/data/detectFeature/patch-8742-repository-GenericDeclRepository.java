@@ -26,6 +26,7 @@
 package sun.reflect.generics.repository;
 
 import java.lang.reflect.TypeVariable;
+import jdk.internal.vm.annotation.Stable;
 import sun.reflect.generics.factory.GenericsFactory;
 import sun.reflect.generics.tree.FormalTypeParameter;
 import sun.reflect.generics.tree.Signature;
@@ -45,7 +46,8 @@ public abstract class GenericDeclRepository<S extends Signature>
     public static final TypeVariable<?>[] EMPTY_TYPE_VARS = new TypeVariable<?>[0];
 
     /** The formal type parameters.  Lazily initialized. */
-    private volatile TypeVariable<?>[] typeParameters;
+    @Stable
+    private TypeVariable<?>[] typeParameters;
 
     protected GenericDeclRepository(String rawSig, GenericsFactory f) {
         super(rawSig, f);