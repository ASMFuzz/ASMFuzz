@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package jdk.tools.jlink.internal;
 
 import java.io.*;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 public class Main {
@@ -61,6 +62,12 @@ public String name() {
             return "jlink";
         }
 
+        @Override
+        public Optional<String> description() {
+            TaskHelper taskHelper = new TaskHelper(TaskHelper.JLINK_BUNDLE);
+            return Optional.of(taskHelper.getMessage("jlink.desciption"));
+        }
+
         @Override
         public int run(PrintWriter out, PrintWriter err, String... args) {
             return Main.run(out, err, args);