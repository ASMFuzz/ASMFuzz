@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
  * @modules java.compiler
  *          java.instrument
  *          jdk.jartool/sun.tools.jar
+ * @build jdk.test.lib.helpers.ClassFileInstaller jdk.test.lib.compiler.InMemoryJavaCompiler
  * @run main RedefineClassHelper
  * @run main/othervm -javaagent:redefineagent.jar RedefineRunningMethodsWithBacktrace
  */
@@ -81,41 +82,43 @@ public static void throwable() {
 
 public class RedefineRunningMethodsWithBacktrace {
 
-    public static String newB =
-                "class RedefineRunningMethodsWithBacktrace_B {" +
-                "   static int count1 = 0;" +
-                "   static int count2 = 0;" +
-                "   public static volatile boolean stop = false;" +
-                "  static void localSleep() { " +
-                "    try{ " +
-                "      Thread.sleep(10);" +
-                "    } catch(InterruptedException ie) { " +
-                "    } " +
-                " } " +
-                "   public static void infinite() { " +
-                "       System.out.println(\"infinite called\");" +
-                "   }" +
-                "   public static void throwable() { " +
-                "       throw new RuntimeException(\"throwable called\");" +
-                "   }" +
-                "}";
-
-    public static String evenNewerB =
-                "class RedefineRunningMethodsWithBacktrace_B {" +
-                "   static int count1 = 0;" +
-                "   static int count2 = 0;" +
-                "   public static volatile boolean stop = false;" +
-                "  static void localSleep() { " +
-                "    try{ " +
-                "      Thread.sleep(1);" +
-                "    } catch(InterruptedException ie) { " +
-                "    } " +
-                " } " +
-                "   public static void infinite() { }" +
-                "   public static void throwable() { " +
-                "       throw new RuntimeException(\"throwable called\");" +
-                "   }" +
-                "}";
+    public static String newB = """
+                class RedefineRunningMethodsWithBacktrace_B {
+                    static int count1 = 0;
+                    static int count2 = 0;
+                    public static volatile boolean stop = false;
+                    static void localSleep() {
+                        try {
+                            Thread.sleep(10);
+                        } catch(InterruptedException ie) {
+                        }
+                    }
+                    public static void infinite() {
+                        System.out.println("infinite called");
+                    }
+                    public static void throwable() {
+                        throw new RuntimeException("throwable called");
+                    }
+                }
+                """;
+
+    public static String evenNewerB = """
+                class RedefineRunningMethodsWithBacktrace_B {
+                    static int count1 = 0;
+                    static int count2 = 0;
+                    public static volatile boolean stop = false;
+                    static void localSleep() {
+                        try {
+                            Thread.sleep(1);
+                        } catch(InterruptedException ie) {
+                        }
+                    }
+                    public static void infinite() {}
+                    public static void throwable() {
+                        throw new RuntimeException("throwable called");
+                    }
+                }
+                """;
 
     private static void touchRedefinedMethodInBacktrace(Throwable throwable) {
         System.out.println("touchRedefinedMethodInBacktrace: ");