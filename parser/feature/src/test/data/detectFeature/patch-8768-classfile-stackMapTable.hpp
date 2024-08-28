@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -125,7 +125,7 @@ class StackMapReader : StackObj {
       int32_t size, int32_t max_size, TRAPS) {
     if (size < 0 || size > max_size) {
       // Since this error could be caused someone rewriting the method
-      // but not knowing to update the stackmap data, we call the the
+      // but not knowing to update the stackmap data, we call the
       // verifier's error method, which may not throw an exception and
       // failover to the old verifier instead.
       _verifier->class_format_error(