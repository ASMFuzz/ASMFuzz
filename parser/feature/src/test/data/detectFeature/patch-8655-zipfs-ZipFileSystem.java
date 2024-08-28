@@ -1582,9 +1582,9 @@ private byte[] initCEN() throws IOException {
                 throw new ZipException("invalid CEN header (bad header size)");
             }
             IndexNode inode = new IndexNode(cen, pos, nlen);
-            if (hasDotOrDotDot(inode.name)) {
+            if (inode.pathHasDotOrDotDot()) {
                 throw new ZipException("ZIP file can't be opened as a file system " +
-                        "because an entry has a '.' or '..' element in its name");
+                        "because entry \"" + inode.nameAsString() + "\" has a '.' or '..' element in its name");
             }
             inodes.put(inode, inode);
             if (zc.isUTF8() || (flag & FLAG_USE_UTF8) != 0) {
@@ -1602,44 +1602,6 @@ private byte[] initCEN() throws IOException {
         return cen;
     }
 
-    /**
-     * Check Inode.name to see if it includes a "." or ".." in the name array
-     * @param path  the path as stored in Inode.name to verify
-     * @return true if the path contains a "." or ".." entry; false otherwise
-     */
-    private boolean hasDotOrDotDot(byte[] path) {
-        // Inode.name always includes "/" in path[0]
-        assert path[0] == '/';
-        if (path.length == 1) {
-            return false;
-        }
-        int index = 1;
-        while (index < path.length) {
-            int starting = index;
-            while (index < path.length && path[index] != '/') {
-                index++;
-            }
-            // Check the path snippet for a "." or ".."
-            if (isDotOrDotDotPath(path, starting, index)) {
-                return true;
-            }
-            index++;
-        }
-        return false;
-    }
-
-    /**
-     * Check the path to see if it includes a "." or ".."
-     * @param path  the path to check
-     * @return true if the path contains a "." or ".." entry; false otherwise
-     */
-    private boolean isDotOrDotDotPath(byte[] path, int start, int index) {
-        int pathLen = index - start;
-        if ((pathLen == 1 && path[start] == '.'))
-            return true;
-        return (pathLen == 2 && path[start] == '.') && path[start + 1] == '.';
-    }
-
     private  final void checkUTF8(byte[] a) throws ZipException {
         try {
             int end = a.length;
@@ -2660,6 +2622,37 @@ boolean isDir() {
             return isdir;
         }
 
+        /**
+         * Check name if it contains a "." or ".." path element
+         * @return true if the path contains a "." or ".." entry; false otherwise
+         */
+        private boolean pathHasDotOrDotDot() {
+            // name always includes "/" in path[0]
+            assert name[0] == '/';
+            if (name.length == 1) {
+                return false;
+            }
+            int index = 1;
+            while (index < name.length) {
+                int start = index;
+                while (index < name.length && name[index] != '/') {
+                    index++;
+                }
+                if (name[start] == '.') {
+                    int len = index - start;
+                    if (len == 1 || (name[start + 1] == '.' && len == 2)) {
+                        return true;
+                    }
+                }
+                index++;
+            }
+            return false;
+        }
+
+        protected String nameAsString() {
+            return new String(name);
+        }
+
         @Override
         public boolean equals(Object other) {
             if (!(other instanceof IndexNode)) {
@@ -2678,7 +2671,7 @@ public int hashCode() {
 
         @Override
         public String toString() {
-            return new String(name) + (isdir ? " (dir)" : " ") + ", index: " + pos;
+            return nameAsString() + (isdir ? " (dir)" : " ") + ", index: " + pos;
         }
     }
 
@@ -3214,7 +3207,7 @@ private void readLocEXTT(ZipFileSystem zipfs) throws IOException {
         public String toString() {
             StringBuilder sb = new StringBuilder(1024);
             Formatter fm = new Formatter(sb);
-            fm.format("    name            : %s%n", new String(name));
+            fm.format("    name            : %s%n", nameAsString());
             fm.format("    creationTime    : %tc%n", creationTime().toMillis());
             fm.format("    lastAccessTime  : %tc%n", lastAccessTime().toMillis());
             fm.format("    lastModifiedTime: %tc%n", lastModifiedTime().toMillis());