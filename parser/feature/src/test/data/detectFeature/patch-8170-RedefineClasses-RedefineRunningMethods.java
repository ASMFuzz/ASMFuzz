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
  * @run main/othervm/timeout=180 -javaagent:redefineagent.jar -Xlog:redefine+class+iklass+add=trace,redefine+class+iklass+purge=trace,class+loader+data=debug,safepoint+cleanup,gc+phases=debug:rt.log RedefineRunningMethods
  */
@@ -59,41 +60,43 @@ public static void infinite_emcp() {
 
 public class RedefineRunningMethods {
 
-    public static String newB =
-                "class RedefineRunningMethods_B {" +
-                "   static int count1 = 0;" +
-                "   static int count2 = 0;" +
-                "   public static volatile boolean stop = false;" +
-                "  static void localSleep() { " +
-                "    try{ " +
-                "      Thread.currentThread().sleep(10);" +
-                "    } catch(InterruptedException ie) { " +
-                "    } " +
-                " } " +
-                "   public static void infinite() { " +
-                "       System.out.println(\"infinite called\");" +
-                "   }" +
-                "   public static void infinite_emcp() { " +
-                "       while (!stop) { count2++; localSleep(); }" +
-                "   }" +
-                "}";
-
-    public static String evenNewerB =
-                "class RedefineRunningMethods_B {" +
-                "   static int count1 = 0;" +
-                "   static int count2 = 0;" +
-                "   public static volatile boolean stop = false;" +
-                "  static void localSleep() { " +
-                "    try{ " +
-                "      Thread.currentThread().sleep(1);" +
-                "    } catch(InterruptedException ie) { " +
-                "    } " +
-                " } " +
-                "   public static void infinite() { }" +
-                "   public static void infinite_emcp() { " +
-                "       System.out.println(\"infinite_emcp now obsolete called\");" +
-                "   }" +
-                "}";
+    public static String newB = """
+                class RedefineRunningMethods_B {
+                    static int count1 = 0;
+                    static int count2 = 0;
+                    public static volatile boolean stop = false;
+                    static void localSleep() {
+                        try {
+                            Thread.currentThread().sleep(10);
+                        } catch(InterruptedException ie) {
+                        }
+                    }
+                    public static void infinite() {
+                        System.out.println("infinite called");
+                    }
+                    public static void infinite_emcp() {
+                        while (!stop) { count2++; localSleep(); }
+                    }
+                }
+                """;
+
+    public static String evenNewerB = """
+                class RedefineRunningMethods_B {
+                    static int count1 = 0;
+                    static int count2 = 0;
+                    public static volatile boolean stop = false;
+                    static void localSleep() {
+                        try {
+                            Thread.currentThread().sleep(1);
+                        } catch(InterruptedException ie) {
+                        }
+                    }
+                    public static void infinite() { }
+                    public static void infinite_emcp() {
+                        System.out.println("infinite_emcp now obsolete called");
+                    }
+                }
+                """;
 
 
     public static void main(String[] args) throws Exception {