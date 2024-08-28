@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package jdk.jpackage.internal;
 
 import java.io.PrintWriter;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 /**
@@ -40,6 +41,10 @@ public String name() {
         return "jpackage";
     }
 
+    public Optional<String> description() {
+        return Optional.of(jdk.jpackage.main.Main.I18N.getString("jpackage.description"));
+    }
+
     public synchronized int run(
             PrintWriter out, PrintWriter err, String... args) {
         try {