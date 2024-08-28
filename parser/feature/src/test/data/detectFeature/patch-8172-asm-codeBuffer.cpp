@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -133,11 +133,10 @@ CodeBuffer::~CodeBuffer() {
     // Previous incarnations of this buffer are held live, so that internal
     // addresses constructed before expansions will not be confused.
     cb->free_blob();
+    // free any overflow storage
+    delete cb->_overflow_arena;
   }
 
-  // free any overflow storage
-  delete _overflow_arena;
-
   NOT_PRODUCT(clear_strings());
 
   assert(_default_oop_recorder.allocated_on_stack_or_embedded(), "should be embedded object");
@@ -932,6 +931,7 @@ void CodeBuffer::take_over_code_from(CodeBuffer* cb) {
     this_sect->take_over_code_from(cb_sect);
   }
   _overflow_arena = cb->_overflow_arena;
+  cb->_overflow_arena = NULL;
   // Make sure the old cb won't try to use it or free it.
   DEBUG_ONLY(cb->_blob = (BufferBlob*)badAddress);
 }