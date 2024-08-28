@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -65,17 +65,19 @@ public static void infinite() {
 
 public class RedefinePreviousVersions {
 
-    public static String newB =
-                "class RedefinePreviousVersions_B {" +
-                "}";
-
-    public static String newRunning =
-        "class RedefinePreviousVersions_Running {" +
-        "    public static volatile boolean stop = true;" +
-        "    public static volatile boolean running = true;" +
-        "    static void localSleep() { }" +
-        "    public static void infinite() { }" +
-        "}";
+    public static String newB = """
+                class RedefinePreviousVersions_B {
+                }
+                """;
+
+    public static String newRunning = """
+        class RedefinePreviousVersions_Running {
+            public static volatile boolean stop = true;
+            public static volatile boolean running = true;
+            static void localSleep() { }
+            public static void infinite() { }
+        }
+        """;
 
     public static void main(String[] args) throws Exception {
 