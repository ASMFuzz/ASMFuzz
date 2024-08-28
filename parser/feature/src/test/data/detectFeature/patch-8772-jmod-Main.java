@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package jdk.tools.jmod;
 
 import java.io.*;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 public class Main {
@@ -55,6 +56,11 @@ public String name() {
             return "jmod";
         }
 
+        @Override
+        public Optional<String> description() {
+            return Optional.of(JmodTask.getMessage("jmod.description"));
+        }
+
         @Override
         public int run(PrintWriter out, PrintWriter err, String... args) {
             return Main.run(out, err, args);