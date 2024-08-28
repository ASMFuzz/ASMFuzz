@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
 import java.nio.file.spi.FileSystemProvider;
 import java.util.Iterator;
 import java.util.NoSuchElementException;
+import java.util.Objects;
 
 /**
  * An object that may be used to locate a file in a file system. It will
@@ -49,7 +50,7 @@
  * file system. {@code Path} defines the {@link #getFileName() getFileName},
  * {@link #getParent getParent}, {@link #getRoot getRoot}, and {@link #subpath
  * subpath} methods to access the path components or a subsequence of its name
- * elements.
+ * elements, and {@link #getExtension() getExtension} to obtain its extension.
  *
  * <p> In addition to accessing the components of a path, a {@code Path} also
  * defines the {@link #resolve(Path) resolve} and {@link #resolveSibling(Path)
@@ -248,6 +249,63 @@ public static Path of(URI uri) {
      */
     Path getFileName();
 
+    /**
+     * Returns the file extension of this path's file name as a {@code String}.
+     * The extension is derived from this {@code Path} by obtaining the
+     * {@linkplain #getFileName file name element}, deriving its {@linkplain
+     * #toString string representation}, and then extracting a substring
+     * determined by the position of a period character ('.', U+002E FULL STOP)
+     * within the file name string. If the file name element is {@code null},
+     * or if the file name string does not contain a period character, or if
+     * the only period in the file name string is its first character, then
+     * the extension is {@code null}. Otherwise, the extension is the substring
+     * after the last period in the file name string. If this last period is
+     * also the last character in the file name string, then the  extension is
+     * {@linkplain String#isEmpty empty}.
+     *
+     * @implSpec
+     * The default implementation is equivalent for this path to:
+     * <pre>{@code
+     * int lastPeriod = fileName.lastIndexOf('.');
+     * if (lastPeriod <= 0)
+     *     return null;
+     * return (lastPeriod == fileName.length() - 1)
+     *     ? ""
+     *     : fileName.substring(lastPeriod + 1);
+     * }</pre>
+     *
+     * @return  the file name extension of this path, which might be the
+     *          empty string, or {@code null} if no extension is found
+     *
+     * @since 20
+     */
+    default String getExtension() {
+        Path fileName = getFileName();
+        if (fileName == null)
+            return null;
+
+        String fileNameString = fileName.toString();
+        int length = fileNameString.length();
+
+        // An empty or unity length file name string has a null extension
+        if (length > 1) {
+            int lastPeriodIndex = fileNameString.lastIndexOf('.');
+
+            // Indeterminate if there is no period character or
+            // only the first character is a period character
+            if (lastPeriodIndex > 0) {
+                if (lastPeriodIndex == length - 1) {
+                    // empty string
+                    return "";
+                } else {
+                    return fileNameString.substring(lastPeriodIndex + 1);
+                }
+            }
+        }
+
+        return null;
+    }
+
     /**
      * Returns the <em>parent path</em>, or {@code null} if this path does not
      * have a parent.