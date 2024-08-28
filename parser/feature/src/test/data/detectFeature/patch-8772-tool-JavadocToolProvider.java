@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,7 +25,11 @@
 
 package jdk.javadoc.internal.tool;
 
+import com.sun.tools.javac.util.Context;
+import com.sun.tools.javac.util.JavacMessages;
 import java.io.PrintWriter;
+import java.util.Optional;
+import java.util.ResourceBundle;
 import java.util.spi.ToolProvider;
 
 /**
@@ -43,6 +47,13 @@ public String name() {
         return "javadoc";
     }
 
+    // @Override - commented out due to interim builds of javadoc with JDKs < 19.
+    public Optional<String> description() {
+        JavacMessages messages = JavacMessages.instance(new Context());
+        messages.add(locale -> ResourceBundle.getBundle("jdk.javadoc.internal.tool.resources.javadoc", locale));
+        return Optional.of(messages.getLocalizedString("javadoc.description"));
+    }
+
     @Override
     public int run(PrintWriter out, PrintWriter err, String... args) {
         return Main.execute(args, out, err);