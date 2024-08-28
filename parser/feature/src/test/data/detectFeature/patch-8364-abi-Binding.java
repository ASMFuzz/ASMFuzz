@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -811,8 +811,8 @@ private Allocate(long size, long alignment) {
             this.alignment = alignment;
         }
 
-        private static MemorySegment allocateBuffer(long size, long allignment, Context context) {
-            return context.allocator().allocate(size, allignment);
+        private static MemorySegment allocateBuffer(long size, long alignment, Context context) {
+            return context.allocator().allocate(size, alignment);
         }
 
         public long size() {