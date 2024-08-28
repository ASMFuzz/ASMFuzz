@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2012, 2019 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -242,7 +242,7 @@ inline T Atomic::PlatformCmpxchg<1>::operator()(T volatile* dest,
   STATIC_ASSERT(1 == sizeof(T));
 
   // Note that cmpxchg guarantees a two-way memory barrier across
-  // the cmpxchg, so it's really a a 'fence_cmpxchg_fence' if not
+  // the cmpxchg, so it's really a 'fence_cmpxchg_fence' if not
   // specified otherwise (see atomic.hpp).
 
   // Using 32 bit internally.
@@ -312,7 +312,7 @@ inline T Atomic::PlatformCmpxchg<4>::operator()(T volatile* dest,
   STATIC_ASSERT(4 == sizeof(T));
 
   // Note that cmpxchg guarantees a two-way memory barrier across
-  // the cmpxchg, so it's really a a 'fence_cmpxchg_fence' if not
+  // the cmpxchg, so it's really a 'fence_cmpxchg_fence' if not
   // specified otherwise (see atomic.hpp).
 
   T old_value;
@@ -362,7 +362,7 @@ inline T Atomic::PlatformCmpxchg<8>::operator()(T volatile* dest,
   STATIC_ASSERT(8 == sizeof(T));
 
   // Note that cmpxchg guarantees a two-way memory barrier across
-  // the cmpxchg, so it's really a a 'fence_cmpxchg_fence' if not
+  // the cmpxchg, so it's really a 'fence_cmpxchg_fence' if not
   // specified otherwise (see atomic.hpp).
 
   T old_value;