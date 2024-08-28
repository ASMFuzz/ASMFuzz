@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -202,7 +202,7 @@ public String run() {
 
         // Fixed 6260650: FileDialog.getDirectory() does not return null when file dialog is cancelled
         // After showing we should display 'user.dir' as current directory
-        // if user didn't set directory programatically
+        // if user didn't set directory programmatically
         pathField = new TextField(savedDir != null ? savedDir : userDir);
         @SuppressWarnings("serial") // Anonymous class
         Choice tmp = new Choice() {
@@ -728,7 +728,7 @@ public void setDirectory(String dir) {
         int i;
         if ((i=dir.indexOf("~")) != -1) {
 
-            dir = dir.substring(0,i) + System.getProperty("user.home") + dir.substring(i+1,dir.length());
+            dir = dir.substring(0,i) + System.getProperty("user.home") + dir.substring(i+1);
         }
 
         File fe = new File(dir).getAbsoluteFile();