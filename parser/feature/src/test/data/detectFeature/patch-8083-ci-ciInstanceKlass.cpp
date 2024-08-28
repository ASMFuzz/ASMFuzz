@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,7 +28,6 @@
 #include "ci/ciInstanceKlass.hpp"
 #include "ci/ciUtilities.inline.hpp"
 #include "classfile/javaClasses.hpp"
-#include "classfile/systemDictionary.hpp"
 #include "classfile/vmClasses.hpp"
 #include "memory/allocation.hpp"
 #include "memory/allocation.inline.hpp"
@@ -281,31 +280,6 @@ bool ciInstanceKlass::is_boxed_value_offset(int offset) const {
          (offset == java_lang_boxing_object::value_offset(bt));
 }
 
-static bool is_klass_initialized(Symbol* klass_name) {
-  VM_ENTRY_MARK;
-  InstanceKlass* ik = SystemDictionary::find_instance_klass(klass_name, Handle(), Handle());
-  return ik != nullptr && ik->is_initialized();
-}
-
-bool ciInstanceKlass::is_box_cache_valid() const {
-  BasicType box_type = box_klass_type();
-
-  if (box_type != T_OBJECT) {
-    switch(box_type) {
-      case T_INT:     return is_klass_initialized(java_lang_Integer_IntegerCache::symbol());
-      case T_CHAR:    return is_klass_initialized(java_lang_Character_CharacterCache::symbol());
-      case T_SHORT:   return is_klass_initialized(java_lang_Short_ShortCache::symbol());
-      case T_BYTE:    return is_klass_initialized(java_lang_Byte_ByteCache::symbol());
-      case T_LONG:    return is_klass_initialized(java_lang_Long_LongCache::symbol());
-      case T_BOOLEAN:
-      case T_FLOAT:
-      case T_DOUBLE:  return true;
-      default:;
-    }
-  }
-  return false;
-}
-
 // ------------------------------------------------------------------
 // ciInstanceKlass::is_in_package
 //