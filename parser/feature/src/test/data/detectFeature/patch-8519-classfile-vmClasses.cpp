@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,6 +30,7 @@
 #include "classfile/systemDictionary.hpp"
 #include "classfile/vmClasses.hpp"
 #include "classfile/vmSymbols.hpp"
+#include "gc/shared/collectedHeap.hpp"
 #include "memory/metaspaceClosure.hpp"
 #include "memory/universe.hpp"
 #include "oops/instanceKlass.hpp"
@@ -122,10 +123,10 @@ void vmClasses::resolve_all(TRAPS) {
   // Preload commonly used klasses
   vmClassID scan = vmClassID::FIRST;
   // first do Object, then String, Class
+  resolve_through(VM_CLASS_ID(Object_klass), scan, CHECK);
+  CollectedHeap::set_filler_object_klass(vmClasses::Object_klass());
 #if INCLUDE_CDS
   if (UseSharedSpaces) {
-    resolve_through(VM_CLASS_ID(Object_klass), scan, CHECK);
-
     // It's unsafe to access the archived heap regions before they
     // are fixed up, so we must do the fixup as early as possible
     // before the archived java objects are accessed by functions
@@ -191,6 +192,8 @@ void vmClasses::resolve_all(TRAPS) {
   resolve_through(jsr292_group_end, scan, CHECK);
   resolve_until(vmClassID::LIMIT, scan, CHECK);
 
+  CollectedHeap::set_filler_object_klass(vmClasses::FillerObject_klass());
+
   _box_klasses[T_BOOLEAN] = vmClasses::Boolean_klass();
   _box_klasses[T_CHAR]    = vmClasses::Character_klass();
   _box_klasses[T_FLOAT]   = vmClasses::Float_klass();