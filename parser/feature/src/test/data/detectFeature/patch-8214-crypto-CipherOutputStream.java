@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -71,13 +71,13 @@
 public class CipherOutputStream extends FilterOutputStream {
 
     // the cipher engine to use to process stream data
-    private Cipher cipher;
+    private final Cipher cipher;
 
     // the underlying output stream
-    private OutputStream output;
+    private final OutputStream output;
 
     /* the buffer holding one byte of incoming data */
-    private byte[] ibuffer = new byte[1];
+    private final byte[] ibuffer = new byte[1];
 
     // the buffer holding data ready to be written out
     private byte[] obuffer = null;
@@ -113,7 +113,7 @@ public CipherOutputStream(OutputStream os, Cipher c) {
         super(os);
         output = os;
         cipher = c;
-    };
+    }
 
     /**
      * Constructs a CipherOutputStream from an OutputStream without
@@ -149,7 +149,7 @@ public void write(int b) throws IOException {
             // should never happen; re-throw just in case
             throw new IOException(sbe);
         }
-    };
+    }
 
     /**
      * Writes <code>b.length</code> bytes from the specified byte array
@@ -166,7 +166,7 @@ public void write(int b) throws IOException {
      * @see        javax.crypto.CipherOutputStream#write(byte[], int, int)
      */
     @Override
-    public void write(byte b[]) throws IOException {
+    public void write(byte[] b) throws IOException {
         write(b, 0, b.length);
     }
 
@@ -180,7 +180,7 @@ public void write(byte b[]) throws IOException {
      * @exception  IOException  if an I/O error occurs.
      */
     @Override
-    public void write(byte b[], int off, int len) throws IOException {
+    public void write(byte[] b, int off, int len) throws IOException {
         ensureCapacity(len);
         try {
             int ostored = cipher.update(b, off, len, obuffer);