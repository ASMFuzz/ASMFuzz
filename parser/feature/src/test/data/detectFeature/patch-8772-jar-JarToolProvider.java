@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,13 +26,18 @@
 package sun.tools.jar;
 
 import java.io.PrintWriter;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 public class JarToolProvider implements ToolProvider {
     public String name() {
         return "jar";
     }
 
+    public Optional<String> description() {
+        return Optional.of(Main.getMsg("jar.description"));
+    }
+
     public int run(PrintWriter out, PrintWriter err, String... args) {
         boolean ok = new Main(out, err, name()).run(args);
         return ok ? 0 : 1;