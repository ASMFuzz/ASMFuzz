@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
@@ -35,7 +35,7 @@
  *
  * @author Sandy Gao, IBM
  *
- * @LastModified: Oct 2021
+ * @LastModified: Mar 2022
  */
 public class DatatypeException extends Exception {
 
@@ -108,4 +108,10 @@ public String getMessage() {
 
         return msg;
     }
+
+    @Override
+    public Throwable fillInStackTrace() {
+        // This is an internal exception; the stack trace is irrelevant.
+        return this;
+    }
 }