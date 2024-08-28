@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2018, 2019 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -756,18 +756,17 @@ void CodeHeapState::aggregate(outputStream* out, CodeHeap* heap, size_t granular
         CodeBlob* cb  = (CodeBlob*)heap->find_start(h);
         cbType = get_cbType(cb);  // Will check for cb == NULL and other safety things.
         if (cbType != noType) {
-          const char* blob_name  = os::strdup(cb->name());
+          const char* blob_name  = nullptr;
           unsigned int nm_size   = 0;
           int temperature        = 0;
           nmethod*  nm = cb->as_nmethod_or_null();
           if (nm != NULL) { // no is_readable check required, nm = (nmethod*)cb.
             ResourceMark rm;
             Method* method = nm->method();
-            if (nm->is_in_use()) {
-              blob_name = os::strdup(method->name_and_sig_as_C_string());
-            }
-            if (nm->is_not_entrant()) {
+            if (nm->is_in_use() || nm->is_not_entrant()) {
               blob_name = os::strdup(method->name_and_sig_as_C_string());
+            } else {
+              blob_name = os::strdup(cb->name());
             }
 
             nm_size    = nm->total_size();
@@ -815,6 +814,8 @@ void CodeHeapState::aggregate(outputStream* out, CodeHeap* heap, size_t granular
               default:
                 break;
             }
+          } else {
+            blob_name  = os::strdup(cb->name());
           }
 
           //------------------------------------------