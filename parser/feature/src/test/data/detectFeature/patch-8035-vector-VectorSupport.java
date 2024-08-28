@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -416,9 +416,9 @@ public interface LoadVectorMaskedOperation<C,
      S extends VectorSpecies<E>,
      M extends VectorMask<E>>
     V loadMasked(Class<? extends V> vClass, Class<M> mClass, Class<E> eClass,
-                 int length,
-                 Object base, long offset,
-                 M m, C container, long index, S s,
+                 int length, Object base, long offset,
+                 M m, int offsetInRange,
+                 C container, long index, S s,
                  LoadVectorMaskedOperation<C, V, S, M> defaultImpl) {
         assert isNonCapturingLambda(defaultImpl) : defaultImpl;
         return defaultImpl.load(container, index, s, m);