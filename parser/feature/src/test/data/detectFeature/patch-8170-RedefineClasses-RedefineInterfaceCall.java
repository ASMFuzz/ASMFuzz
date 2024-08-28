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
  * @run main/othervm -javaagent:redefineagent.jar -Xlog:redefine+class+update*=trace RedefineInterfaceCall
  */
@@ -53,12 +54,13 @@ public class RedefineInterfaceCall {
     static String newI1 =
       "interface I1 { default int m() { return 1; } }";
 
-    static String newC =
-        "class RedefineInterfaceCall_C implements I2 { " +
-        "  public int test(I2 i) { " +
-        "    return i.m(); " +
-        "  } " +
-        "} ";
+    static String newC = """
+        class RedefineInterfaceCall_C implements I2 {
+            public int test(I2 i) {
+                return i.m();
+            }
+        }
+        """;
 
     static int test(I2 i) {
         return i.m(); // invokeinterface cpCacheEntry