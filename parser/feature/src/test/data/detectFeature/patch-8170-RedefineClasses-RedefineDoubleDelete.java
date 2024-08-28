@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @modules java.compiler
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm/native -Xlog:redefine+class+load+exceptions -agentlib:RedefineDoubleDelete -javaagent:redefineagent.jar RedefineDoubleDelete
  */
@@ -46,15 +47,17 @@ class RedefineDoubleDelete_B {
 public class RedefineDoubleDelete {
 
     // Class gets a redefinition error because it adds a data member
-    public static String newB =
-                "class RedefineDoubleDelete_B {" +
-                "   int count1 = 0;" +
-                "}";
+    public static String newB = """
+                class RedefineDoubleDelete_B {
+                   int count1 = 0;
+                }
+                """;
 
-    public static String newerB =
-                "class RedefineDoubleDelete_B { " +
-                "   int faa() { System.out.println(\"baa\"); return 2; }" +
-                "}";
+    public static String newerB = """
+                class RedefineDoubleDelete_B {
+                   int faa() { System.out.println("baa"); return 2; }
+                }
+                """;
 
     public static void main(String args[]) throws Exception {
 