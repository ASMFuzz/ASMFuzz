@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -151,14 +151,14 @@ public static <T> T checkNonNull(T t, Supplier<String> msg) {
     /** Equivalent to
      *   assert false;
      */
-    public static void error() {
+    public static Error error() {
         throw new AssertionError();
     }
 
     /** Equivalent to
      *   assert false : msg;
      */
-    public static void error(String msg) {
+    public static Error error(String msg) {
         throw new AssertionError(msg);
     }
 