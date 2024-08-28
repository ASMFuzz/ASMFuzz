@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -193,7 +193,7 @@ class ZipFileSystem extends FileSystem {
 
     /**
      * Return the compression method to use (STORED or DEFLATED).  If the
-     * property {@code commpressionMethod} is set use its value to determine
+     * property {@code compressionMethod} is set use its value to determine
      * the compression method to use.  If the property is not set, then the
      * default compression is DEFLATED unless the property {@code noCompression}
      * is set which is supported for backwards compatibility.
@@ -357,7 +357,7 @@ public String getSeparator() {
 
     @Override
     public boolean isOpen() {
-        return isOpen;
+        return !closed;
     }
 
     @Override
@@ -467,9 +467,9 @@ public PathMatcher getPathMatcher(String syntaxAndInput) {
     public void close() throws IOException {
         beginWrite();
         try {
-            if (!isOpen)
+            if (closed)
                 return;
-            isOpen = false;          // set closed
+            closed = true;          // set closed
         } finally {
             endWrite();
         }
@@ -868,7 +868,7 @@ InputStream newInputStream(byte[] path) throws IOException {
     }
 
     private void checkOptions(Set<? extends OpenOption> options) {
-        // check for options of null type and option is an intance of StandardOpenOption
+        // check for options of null type and option is an instance of StandardOpenOption
         for (OpenOption option : options) {
             if (option == null)
                 throw new NullPointerException();
@@ -1200,7 +1200,7 @@ private void endRead() {
 
     ///////////////////////////////////////////////////////////////////
 
-    private volatile boolean isOpen = true;
+    private volatile boolean closed;
     private final SeekableByteChannel ch; // channel to the zipfile
     final byte[]  cen;     // CEN & ENDHDR
     private END  end;
@@ -1659,7 +1659,7 @@ private  final void checkUTF8(byte[] a) throws ZipException {
         }
     }
 
-    private final void checkEncoding( byte[] a) throws ZipException {
+    private final void checkEncoding(byte[] a) throws ZipException {
         try {
             zc.toString(a);
         } catch(Exception e) {
@@ -1669,7 +1669,7 @@ private final void checkEncoding( byte[] a) throws ZipException {
 
 
     private void ensureOpen() {
-        if (!isOpen)
+        if (closed)
             throw new ClosedFileSystemException();
     }
 
@@ -2429,7 +2429,7 @@ private void initDataPos() throws IOException {
         }
     }
 
-    // Maxmum number of de/inflater we cache
+    // Maximum number of de/inflater we cache
     private final int MAX_FLATER = 20;
     // List of available Inflater objects for decompression
     private final List<Inflater> inflaters = new ArrayList<>();
@@ -3034,7 +3034,7 @@ private int writeLOC(OutputStream os) throws IOException {
             }
             if (elenEXTT != 0) {
                 writeShort(os, EXTID_EXTT);
-                writeShort(os, elenEXTT - 4);// size for the folowing data block
+                writeShort(os, elenEXTT - 4);// size for the following data block
                 int fbyte = 0x1;
                 if (atime != -1)           // mtime and atime
                     fbyte |= 0x2;