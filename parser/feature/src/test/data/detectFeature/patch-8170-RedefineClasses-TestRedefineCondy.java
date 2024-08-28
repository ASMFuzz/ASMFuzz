@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,6 +32,7 @@
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
  * @compile RedefineCondy.jasm
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm -javaagent:redefineagent.jar TestRedefineCondy
  */
@@ -43,10 +44,12 @@
 public class TestRedefineCondy {
 
     static final String DEST = System.getProperty("test.classes");
-    static String newClass =
-        "public class RedefineCondy { " +
-        "public RedefineCondy(java.lang.invoke.MethodHandles.Lookup l, java.lang.String s, java.lang.Class c) { } " +
-    "public static void main(String argv[]) { } } ";
+    static String newClass = """
+        public class RedefineCondy {
+            public RedefineCondy(java.lang.invoke.MethodHandles.Lookup l, java.lang.String s, java.lang.Class c) {}
+            public static void main(String argv[]) {}
+        }
+        """;
 
     public static void main(String[] args) throws Exception  {
         Class<?> classWithCondy = Class.forName("RedefineCondy");