@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @modules java.compiler
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm -javaagent:redefineagent.jar -XX:+AllowRedefinitionToAddDeleteMethods -Xlog:redefine+class*=trace RedefineSubtractLambdaExpression
  */
@@ -53,16 +54,17 @@ static int test_math(String p) {
 
 public class RedefineSubtractLambdaExpression {
 
-    public static String newB =
-        "class B {" +
-        "    public static int operate(int a, int b, MathOperation mathOperation) {" +
-        "        return mathOperation.operation(a, b);" +
-        "    }" +
-        "    static int test_math(String p) {" +
-        "        MathOperation subtraction = (int a, int b) -> a - b;" +
-        "        return operate(10, 5, subtraction);" +
-        "    }" +
-        "}";
+    public static String newB = """
+        class B {
+            public static int operate(int a, int b, MathOperation mathOperation) {
+                return mathOperation.operation(a, b);
+            }
+            static int test_math(String p) {
+                MathOperation subtraction = (int a, int b) -> a - b;
+                return operate(10, 5, subtraction);
+            }
+        }
+        """;
 
     public static void main(String[] args) throws Exception {
         int res = B.test_math("Hello");