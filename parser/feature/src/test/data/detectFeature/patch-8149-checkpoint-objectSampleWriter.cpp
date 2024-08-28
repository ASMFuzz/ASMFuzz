@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -612,11 +612,11 @@ ObjectSampleWriter::ObjectSampleWriter(JfrCheckpointWriter& writer, EdgeStore* s
   assert(store != NULL, "invariant");
   assert(!store->is_empty(), "invariant");
   register_serializers();
-  sample_infos = NULL;
-  ref_infos = NULL;
-  array_infos = NULL;
-  field_infos = NULL;
-  root_infos = NULL;
+  assert(field_infos == NULL, "Invariant");
+  assert(sample_infos == NULL, "Invariant");
+  assert(ref_infos == NULL, "Invariant");
+  assert(array_infos == NULL, "Invariant");
+  assert(root_infos == NULL, "Invariant");
 }
 
 ObjectSampleWriter::~ObjectSampleWriter() {
@@ -625,6 +625,16 @@ ObjectSampleWriter::~ObjectSampleWriter() {
   write_array_infos(_writer);
   write_field_infos(_writer);
   write_root_descriptors(_writer);
+
+  // Followings are RA allocated, memory will be released automatically.
+  if (field_infos != NULL) {
+    field_infos->~FieldTable();
+    field_infos = NULL;
+  }
+  sample_infos = NULL;
+  ref_infos = NULL;
+  array_infos = NULL;
+  root_infos = NULL;
 }
 
 bool ObjectSampleWriter::operator()(StoredEdge& e) {