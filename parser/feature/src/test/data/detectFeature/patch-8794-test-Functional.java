@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -149,7 +149,8 @@ public ExceptionBox(Throwable throwable) {
     }
 
     @SuppressWarnings("unchecked")
-    public static void rethrowUnchecked(Throwable throwable) throws ExceptionBox {
+    public static RuntimeException rethrowUnchecked(Throwable throwable) throws
+            ExceptionBox {
         if (throwable instanceof RuntimeException) {
             throw (RuntimeException)throwable;
         }