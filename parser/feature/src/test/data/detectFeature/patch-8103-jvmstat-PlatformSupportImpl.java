@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -41,6 +41,31 @@ public class PlatformSupportImpl extends PlatformSupport {
     private static final String containerTmpPath = "/root" + getTemporaryDirectory();
     private static final String pidPatternStr = "^[0-9]+$";
 
+    private long tmpInode;
+    private long tmpDev;
+
+    public PlatformSupportImpl() {
+        super();
+        try {
+            var tmpPath = Path.of(getTemporaryDirectory());
+            tmpInode = (Long)Files.getAttribute(tmpPath, "unix:ino");
+            tmpDev = (Long)Files.getAttribute(tmpPath, "unix:dev");
+        } catch (IOException e) {
+            tmpInode = -1L;
+            tmpDev = -1L;
+        }
+    }
+
+    private boolean tempDirectoryEquals(Path p) {
+        try {
+            long ino = (Long)Files.getAttribute(p, "unix:ino");
+            long dev = (Long)Files.getAttribute(p, "unix:dev");
+            return (ino == tmpInode) && (dev == tmpDev);
+        } catch (IOException e) {
+            return false;
+        }
+    }
+
     /*
      * Return the temporary directories that the VM uses for the attach
      * and perf data files.  This function returns the traditional
@@ -83,11 +108,12 @@ public class PlatformSupportImpl extends PlatformSupport {
      *
      * 1. duplication of tmp directories
      *
-     * /proc/{hostpid}/root/tmp directories exist for many processes
-     * that are running on a Linux kernel that has cgroups enabled even
-     * if they are not running in a container.  To avoid this duplication,
-     * we compare the inode of the /proc tmp directories to /tmp and
-     * skip these duplicated directories.
+     * When cgroups is enabled, the directory /proc/{pid}/root/tmp may
+     * exist even if the given pid is not running inside a container. In
+     * this case, this directory is usually the same as /tmp and should
+     * be skipped, or else we would get duplicated hsperfdata files.
+     * This case can be detected if the inode and device id of
+     * /proc/{pid}/root/tmp are the same as /tmp.
      *
      * 2. Containerized processes without PID namespaces being enabled.
      *
@@ -101,7 +127,6 @@ public List<String> getTemporaryDirectories(int pid) {
         FilenameFilter pidFilter;
         Matcher pidMatcher;
         Pattern pidPattern = Pattern.compile(pidPatternStr);
-        long tmpInode = 0;
 
         File procdir = new File("/proc");
 
@@ -117,12 +142,6 @@ public List<String> getTemporaryDirectories(int pid) {
         List<String> v = new ArrayList<>();
         v.add(getTemporaryDirectory());
 
-        try {
-            File f = new File(getTemporaryDirectory());
-            tmpInode = (Long)Files.getAttribute(f.toPath(), "unix:ino");
-        }
-        catch (IOException e) {}
-
         pidFilter = new FilenameFilter() {
             public boolean accept(File dir, String name) {
                 if (!dir.isDirectory())
@@ -139,14 +158,11 @@ public boolean accept(File dir, String name) {
             String containerTmpDir = dir.getAbsolutePath() + containerTmpPath;
             File containerFile = new File(containerTmpDir);
 
-            try {
-                long procInode = (Long)Files.getAttribute(containerFile.toPath(), "unix:ino");
-                if (containerFile.exists() && containerFile.isDirectory() &&
-                    containerFile.canRead() && procInode != tmpInode) {
-                    v.add(containerTmpDir);
-                }
+            if (containerFile.exists() && containerFile.isDirectory() &&
+                containerFile.canRead() &&
+                !tempDirectoryEquals(containerFile.toPath())) {
+                v.add(containerTmpDir);
             }
-            catch (IOException e) {}
         }
 
         return v;