@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2017, Red Hat, Inc. and/or its affiliates.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -31,6 +31,9 @@
 #include "runtime/globals.hpp"
 #include "runtime/globals_extension.hpp"
 #include "utilities/macros.hpp"
+#if defined(LINUX)
+#include "osContainer_linux.hpp"
+#endif
 
 size_t HeapAlignment = 0;
 size_t SpaceAlignment = 0;
@@ -138,6 +141,15 @@ void GCArguments::initialize_heap_flags_and_sizes() {
     vm_exit_during_initialization("Too small minimum heap");
   }
 
+#if defined(LINUX)
+  if (OSContainer::is_containerized() && FLAG_IS_CMDLINE(InitialHeapSize)) {
+    jlong limit = os::physical_memory();
+    if ((limit > 0) && (InitialHeapSize >= (julong) limit)) {
+      vm_exit_during_initialization("Initial heap size set to a larger value than the container memory & swap limit");
+    }
+  }
+#endif
+
   // User inputs from -Xmx and -Xms must be aligned
   // Write back to flags if the values changed
   if (!is_aligned(MinHeapSize, HeapAlignment)) {