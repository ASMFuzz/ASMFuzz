@@ -469,7 +469,7 @@ public interface StoreVectorMaskedOperation<C,
     void storeMasked(Class<? extends V> vClass, Class<M> mClass, Class<E> eClass,
                      int length,
                      Object base, long offset,
-                     V v, M m, C container, int index,
+                     V v, M m, int offsetInRange, C container, int index,
                      StoreVectorMaskedOperation<C, V, M> defaultImpl) {
         assert isNonCapturingLambda(defaultImpl) : defaultImpl;
         defaultImpl.store(container, index, v, m);