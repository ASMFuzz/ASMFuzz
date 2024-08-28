@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,8 +26,11 @@
 package com.sun.tools.javac.main;
 
 import java.io.PrintWriter;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
+import com.sun.tools.javac.util.JavacMessages;
+
 /**
  * An implementation of the {@link java.util.spi.ToolProvider ToolProvider} SPI,
  * providing access to JDK Java compiler, javac.
@@ -41,6 +44,11 @@ public String name() {
         return "javac";
     }
 
+    public Optional<String> description() {
+        JavacMessages messages = new JavacMessages(Main.javacBundleName);
+        return Optional.of(messages.getLocalizedString("javac.description"));
+    }
+
     public int run(PrintWriter out, PrintWriter err, String... args) {
         Main compiler = new Main("javac", out, err);
         return compiler.compile(args).exitCode;