@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -132,7 +132,15 @@ inline void set(jbyte bits, jbyte* dest) {
 template <typename T>
 inline void JfrTraceIdBits::store(jbyte bits, const T* ptr) {
   assert(ptr != NULL, "invariant");
+  // gcc12 warns "writing 1 byte into a region of size 0" when T == Klass.
+  // The warning seems to be a false positive.  And there is no warning for
+  // other types that use the same mechanisms.  The warning also sometimes
+  // goes away with minor code perturbations, such as replacing function calls
+  // with equivalent code directly inlined.
+  PRAGMA_DIAG_PUSH
+  PRAGMA_DISABLE_GCC_WARNING("-Wstringop-overflow")
   set(bits, traceid_tag_byte(ptr));
+  PRAGMA_DIAG_POP
 }
 
 template <typename T>