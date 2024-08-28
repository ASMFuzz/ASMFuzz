@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1407,6 +1407,12 @@ public static class InapplicableMethodException extends RuntimeException {
         public JCDiagnostic getDiagnostic() {
             return diagnostic;
         }
+
+        @Override
+        public Throwable fillInStackTrace() {
+            // This is an internal exception; the stack trace is irrelevant.
+            return this;
+        }
     }
 
 /* ***************************************************************************