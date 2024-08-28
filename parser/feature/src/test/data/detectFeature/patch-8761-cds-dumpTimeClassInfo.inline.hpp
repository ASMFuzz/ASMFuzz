@@ -1,6 +1,6 @@
 
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,38 +35,34 @@
 
 #if INCLUDE_CDS
 
-// For safety, only iterate over a class if it loader is alive.
-// IterationHelper and DumpTimeSharedClassTable::iterate
-// must be used only inside a safepoint, where the value of
+// For safety, only iterate over a class if its loader is alive.
+// This function must be called only inside a safepoint, where the value of
 // k->is_loader_alive() will not change.
-template<class ITER>
-class DumpTimeSharedClassTable::IterationHelper {
-  ITER* _iter;
-public:
-  IterationHelper(ITER* iter) {
-    _iter = iter;
-  }
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+template<typename Function>
+void DumpTimeSharedClassTable::iterate_all_live_classes(Function function) const {
+  auto wrapper = [&] (InstanceKlass* k, DumpTimeClassInfo& info) {
     assert(SafepointSynchronize::is_at_safepoint(), "invariant");
     assert_lock_strong(DumpTimeTable_lock);
     if (k->is_loader_alive()) {
-      bool result = _iter->do_entry(k, info);
+      function(k, info);
       assert(k->is_loader_alive(), "must not change");
-      return result;
     } else {
       if (!SystemDictionaryShared::is_excluded_class(k)) {
         SystemDictionaryShared::warn_excluded(k, "Class loader not alive");
         SystemDictionaryShared::set_excluded_locked(k);
       }
-      return true;
     }
-  }
-};
+  };
+  DumpTimeSharedClassTableBaseType::iterate_all(wrapper);
+}
+
 
 template<class ITER>
-void DumpTimeSharedClassTable::iterate(ITER* iter) const {
-  IterationHelper<ITER> helper(iter);
-  DumpTimeSharedClassTableBaseType::iterate(&helper);
+void DumpTimeSharedClassTable::iterate_all_live_classes(ITER* iter) const {
+  auto function = [&] (InstanceKlass* k, DumpTimeClassInfo& v) {
+    iter->do_entry(k, v);
+  };
+  iterate_all_live_classes(function);
 }
 
 #endif // INCLUDE_CDS