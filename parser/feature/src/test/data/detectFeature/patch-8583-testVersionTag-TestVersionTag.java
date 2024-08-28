@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @run main TestVersionTag
  */
 
+import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
@@ -53,7 +54,7 @@ public static void main(String... args) throws Exception {
         tb.writeJavaFiles(src,
                   """
                       package pkg;
-                      /** Introduction.\s
+                      /** Introduction.
                        * @version 1.2.3
                        */
                       public class Test { }
@@ -81,6 +82,45 @@ public void testNoVersion() {
         checkVersion(false);
     }
 
+    @Test
+    public void testBadVersion_NoWarning(Path base) throws IOException {
+        testBadVersion(base, false);
+    }
+
+    @Test
+    public void testBadVersion_Warning(Path base) throws IOException {
+        testBadVersion(base, true);
+    }
+
+    public void testBadVersion(Path base, boolean useVersionOption) throws IOException {
+        Path src = base.resolve("src");
+        tb.writeJavaFiles(src,
+                """
+                    package pkg;
+                    /** Comment. */
+                    public class Test {
+                        private Test() { }
+                        /**
+                         * Comment.
+                         * @version 1.2.3
+                         */
+                        public void m() { }
+                    }""");
+
+        javadoc("-d", base.resolve("out").toString(),
+                "-sourcepath", src.toString(),
+                "-Xdoclint:none",
+                (useVersionOption ? "-version" : "-XDdummy=dummy"),
+                "pkg");
+        checkExit(Exit.OK);
+
+        // bad tags never cause corresponding output, whether the option is enabled or not
+        checkVersion(false);
+
+        checkOutput(Output.OUT, useVersionOption,
+                "warning: Tag @version cannot be used in method documentation.");
+    }
+
     void checkVersion(boolean on) {
         checkOutput("pkg/Test.html", on,
                 """