@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -123,6 +123,7 @@ public class Proc {
     private String debug;           // debug flag, controller will show data
                                     // transfer between procs. If debug is set,
                                     // it MUST be different between Procs.
+    private final StringBuilder stdout = new StringBuilder();
 
     final private static String PREFIX = "PROCISFUN:";
 
@@ -358,6 +359,9 @@ String getId(String suffix) {
     // Reads a line from stdout of proc
     public String readLine() throws IOException {
         String s = br.readLine();
+        if (s != null) {
+            stdout.append(s).append('\n');
+        }
         if (debug != null) {
             System.out.println("PROC: " + debug + " readline: " +
                     (s == null ? "<EOF>" : s));
@@ -402,6 +406,16 @@ public int waitFor() throws Exception {
         }
         return p.waitFor();
     }
+
+    // Returns an OutputAnalyzer
+    public OutputAnalyzer output() throws Exception {
+        int exitCode = waitFor();
+        Path stderr = Path.of(getId("stderr"));
+        return new OutputAnalyzer(stdout.toString(),
+                Files.exists(stderr) ? Files.readString(stderr) : "",
+                exitCode);
+    }
+
     // Wait for process end with expected exit code
     public void waitFor(int expected) throws Exception {
         if (p.waitFor() != expected) {