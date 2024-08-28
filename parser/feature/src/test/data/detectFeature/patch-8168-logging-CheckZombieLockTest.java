@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -50,6 +50,8 @@
 import java.util.logging.FileHandler;
 import java.util.logging.Level;
 import java.util.logging.LogRecord;
+import static java.nio.file.StandardOpenOption.*;
+
 public class CheckZombieLockTest {
 
     private static final String WRITABLE_DIR = "writable-lockfile-dir";
@@ -241,10 +243,9 @@ private static void testFileHandlerReuse(File writableDir) throws IOException {
             }
 
             if (supportsLocking) {
-                FileChannel fc = FileChannel.open(Paths.get(lock.getAbsolutePath()),
-                    StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND,
-                    StandardOpenOption.WRITE);
-                try {
+                handler2 = null;
+                try (FileChannel fc = FileChannel.open(lock.toPath(), CREATE_NEW, APPEND, WRITE)) {
+
                     if (fc.tryLock() != null) {
                         System.out.println("locked: " + lock);
                         handler2 = createFileHandler(writableDir);
@@ -261,6 +262,7 @@ private static void testFileHandlerReuse(File writableDir) throws IOException {
                         throw new RuntimeException("Failed to lock: " + lock);
                     }
                 } finally {
+                    if (handler2 != null) handler2.close();
                     delete(lock);
                 }
             }
@@ -320,17 +322,12 @@ private static File setup() throws RuntimeException {
 
         // try to determine whether file locking is supported
         final String uniqueFileName = UUID.randomUUID().toString()+".lck";
-        try {
-            FileChannel fc = FileChannel.open(Paths.get(writableDir.getAbsolutePath(),
-                    uniqueFileName),
-                    StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND,
-                    StandardOpenOption.DELETE_ON_CLOSE);
+        try (FileChannel fc = FileChannel.open(Paths.get(writableDir.getAbsolutePath(),
+                    uniqueFileName), CREATE_NEW, APPEND, DELETE_ON_CLOSE)) {
             try {
                 fc.tryLock();
-            } catch(IOException x) {
+            } catch (IOException x) {
                 supportsLocking = false;
-            } finally {
-                fc.close();
             }
         } catch (IOException t) {
             // should not happen