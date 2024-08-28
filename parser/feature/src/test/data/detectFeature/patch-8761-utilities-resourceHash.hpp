@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -203,19 +203,37 @@ class ResourceHashtableBase : public STORAGE {
   // the iteration is cancelled.
   template<class ITER>
   void iterate(ITER* iter) const {
+    auto function = [&] (K& k, V& v) {
+      return iter->do_entry(k, v);
+    };
+    iterate(function);
+  }
+
+  template<typename Function>
+  void iterate(Function function) const { // lambda enabled API
     Node* const* bucket = table();
     const unsigned sz = table_size();
     while (bucket < bucket_at(sz)) {
       Node* node = *bucket;
       while (node != NULL) {
-        bool cont = iter->do_entry(node->_key, node->_value);
+        bool cont = function(node->_key, node->_value);
         if (!cont) { return; }
         node = node->_next;
       }
       ++bucket;
     }
   }
 
+  // same as above, but unconditionally iterate all entries
+  template<typename Function>
+  void iterate_all(Function function) const { // lambda enabled API
+    auto wrapper = [&] (K& k, V& v) {
+      function(k, v);
+      return true;
+    };
+    iterate(wrapper);
+  }
+
   // ITER contains bool do_entry(K const&, V const&), which will be
   // called for each entry in the table.  If do_entry() returns true,
   // the entry is deleted.