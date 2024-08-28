@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package com.sun.tools.javap;
 
 import java.io.PrintWriter;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 /**
@@ -65,6 +66,11 @@ public String name() {
             return "javap";
         }
 
+        public Optional<String> description() {
+            JavapTask t = new JavapTask();
+            return Optional.of(t.getMessage("javap.description"));
+        }
+
         public int run(PrintWriter out, PrintWriter err, String... args) {
             return Main.run(args, out);
         }