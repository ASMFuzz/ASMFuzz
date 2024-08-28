@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @modules java.compiler
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm -javaagent:redefineagent.jar -Xlog:redefine+class*=trace RedefineInterfaceMethods
  */
@@ -53,29 +54,31 @@ public class RedefineInterfaceMethods {
 
     static final int RET = -2;
 
-    public static String redefinedPrivateMethod =
-        "interface RedefineInterfaceMethods_B {" +
-        "    int ORIGINAL_RETURN = 1;" +
-        "    int NEW_RETURN = 2;" +
-        "    private int privateMethod() {" +
-        "        return NEW_RETURN;" +
-        "    }" +
-        "    public default int defaultMethod() {" +
-        "       return privateMethod();" +
-        "    }" +
-        "}";
-
-    public static String redefinedDefaultMethod =
-        "interface RedefineInterfaceMethods_B {" +
-        "    int ORIGINAL_RETURN = 1;" +
-        "    int NEW_RETURN = 2;" +
-        "    private int privateMethod() {" +
-        "        return ORIGINAL_RETURN;" +
-        "    }" +
-        "    public default int defaultMethod() {" +
-        "       return RedefineInterfaceMethods.RET;" +
-        "    }" +
-        "}";
+    public static String redefinedPrivateMethod = """
+        interface RedefineInterfaceMethods_B {
+            int ORIGINAL_RETURN = 1;
+            int NEW_RETURN = 2;
+            private int privateMethod() {
+                return NEW_RETURN;
+            }
+            public default int defaultMethod() {
+                return privateMethod();
+            }
+        }
+        """;
+
+    public static String redefinedDefaultMethod = """
+        interface RedefineInterfaceMethods_B {
+            int ORIGINAL_RETURN = 1;
+            int NEW_RETURN = 2;
+            private int privateMethod() {
+                return ORIGINAL_RETURN;
+            }
+            public default int defaultMethod() {
+                return RedefineInterfaceMethods.RET;
+            }
+        }
+        """;
 
     static class Impl implements RedefineInterfaceMethods_B {
     }