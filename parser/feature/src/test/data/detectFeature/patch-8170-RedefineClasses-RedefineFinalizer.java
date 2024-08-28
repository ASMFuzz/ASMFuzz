@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @modules java.compiler
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm -javaagent:redefineagent.jar RedefineFinalizer
  */
@@ -54,12 +55,13 @@ protected void finalize() {
 
 public class RedefineFinalizer {
 
-    public static String newB =
-                "class RedefineFinalizer_B {" +
-                "   protected void finalize() { " +
-                "       System.out.println(\"Finalizer called\");" +
-                "   }" +
-                "}";
+    public static String newB = """
+                class RedefineFinalizer_B {
+                    protected void finalize() {
+                        System.out.println("Finalizer called");
+                    }
+                }
+                """;
 
     public static void main(String[] args) throws Exception {
         RedefineClassHelper.redefineClass(RedefineFinalizer_B.class, newB);