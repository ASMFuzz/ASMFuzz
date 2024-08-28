@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package com.sun.tools.jdeps;
 
 import java.io.*;
+import java.util.Optional;
 import java.util.spi.ToolProvider;
 
 /**
@@ -69,6 +70,10 @@ public String name() {
             return "jdeps";
         }
 
+        public Optional<String> description() {
+            return Optional.of(JdepsTask.getMessage("jdeps.description"));
+        }
+
         public int run(PrintWriter out, PrintWriter err, String... args) {
             return Main.run(args, out);
         }