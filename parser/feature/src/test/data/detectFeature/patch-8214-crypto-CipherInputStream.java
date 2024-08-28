@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,11 +25,9 @@
 
 package javax.crypto;
 
-import java.io.InputStream;
 import java.io.FilterInputStream;
 import java.io.IOException;
-import javax.crypto.BadPaddingException;
-import javax.crypto.IllegalBlockSizeException;
+import java.io.InputStream;
 
 /**
  * A CipherInputStream is composed of an InputStream and a Cipher so
@@ -77,15 +75,15 @@
 public class CipherInputStream extends FilterInputStream {
 
     // the cipher engine to use to process stream data
-    private Cipher cipher;
+    private final Cipher cipher;
 
     // the underlying input stream
-    private InputStream input;
+    private final InputStream input;
 
     /* the buffer holding data that have been read in from the
        underlying stream, but have not been processed by the cipher
        engine. the size 512 bytes is somewhat randomly chosen */
-    private byte[] ibuffer = new byte[512];
+    private final byte[] ibuffer = new byte[512];
 
     // having reached the end of the underlying input stream
     private boolean done = false;
@@ -215,7 +213,7 @@ public int read() throws IOException {
             if (i == -1) return -1;
         }
         return ((int) obuffer[ostart++] & 0xff);
-    };
+    }
 
     /**
      * Reads up to <code>b.length</code> bytes of data from this input
@@ -233,7 +231,7 @@ public int read() throws IOException {
      * @see        java.io.InputStream#read(byte[], int, int)
      */
     @Override
-    public int read(byte b[]) throws IOException {
+    public int read(byte[] b) throws IOException {
         return read(b, 0, b.length);
     }
 
@@ -254,7 +252,7 @@ public int read(byte b[]) throws IOException {
      * @see        java.io.InputStream#read()
      */
     @Override
-    public int read(byte b[], int off, int len) throws IOException {
+    public int read(byte[] b, int off, int len) throws IOException {
         if (ostart >= ofinish) {
             // we loop for new data as the spec says we are blocking
             int i = 0;