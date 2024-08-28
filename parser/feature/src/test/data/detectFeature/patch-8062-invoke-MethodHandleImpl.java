@@ -451,7 +451,7 @@ static MethodHandle makeVarargsCollector(MethodHandle target, Class<?> arrayType
     static final class AsVarargsCollector extends DelegatingMethodHandle {
         private final MethodHandle target;
         private final Class<?> arrayType;
-        private @Stable MethodHandle asCollectorCache;
+        private MethodHandle asCollectorCache;
 
         AsVarargsCollector(MethodHandle target, Class<?> arrayType) {
             this(target.type(), target, arrayType);