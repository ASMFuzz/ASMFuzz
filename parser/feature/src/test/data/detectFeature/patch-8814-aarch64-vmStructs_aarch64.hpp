@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -31,9 +31,12 @@
 // referenced by vmStructs.cpp.
 
 #define VM_STRUCTS_CPU(nonstatic_field, static_field, unchecked_nonstatic_field, volatile_nonstatic_field, nonproduct_nonstatic_field, c2_nonstatic_field, unchecked_c1_static_field, unchecked_c2_static_field) \
-  volatile_nonstatic_field(JavaFrameAnchor, _last_Java_fp, intptr_t*)
+  volatile_nonstatic_field(JavaFrameAnchor, _last_Java_fp,   intptr_t*) \
+              static_field(VM_Version,      _rop_protection, bool)      \
+              static_field(VM_Version,      _pac_mask,       uintptr_t)
 
-#define VM_TYPES_CPU(declare_type, declare_toplevel_type, declare_oop_type, declare_integer_type, declare_unsigned_integer_type, declare_c1_toplevel_type, declare_c2_type, declare_c2_toplevel_type)
+#define VM_TYPES_CPU(declare_type, declare_toplevel_type, declare_oop_type, declare_integer_type, declare_unsigned_integer_type, declare_c1_toplevel_type, declare_c2_type, declare_c2_toplevel_type) \
+  declare_toplevel_type(VM_Version)
 
 #define VM_INT_CONSTANTS_CPU(declare_constant, declare_preprocessor_constant, declare_c1_constant, declare_c2_constant, declare_c2_preprocessor_constant)
 