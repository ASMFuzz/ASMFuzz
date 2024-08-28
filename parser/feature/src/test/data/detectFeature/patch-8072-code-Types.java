@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -654,6 +654,12 @@ FunctionDescriptorLookupError setMessage(JCDiagnostic diag) {
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
 
     /**
@@ -5055,6 +5061,12 @@ public static class InvalidSignatureException extends RuntimeException {
             public Type type() {
                 return type;
             }
+
+            @Override
+            public Throwable fillInStackTrace() {
+                // This is an internal exception; the stack trace is irrelevant.
+                return this;
+            }
         }
 
         private final Types types;