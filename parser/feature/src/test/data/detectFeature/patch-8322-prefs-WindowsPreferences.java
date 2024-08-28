@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -498,9 +498,9 @@ private byte[] windowsAbsolutePath() {
      * given security mask.
      * @param securityMask Windows security mask.
      * @return Windows registry key's handle.
-     * @see #openKey(byte[], int)
-     * @see #openKey(int, byte[], int)
-     * @see #closeKey(int)
+     * @see #openKey(byte[], int, int)
+     * @see #openKey(long, byte[], int, int)
+     * @see #closeKey(long)
      */
     private long openKey(int securityMask) {
         return openKey(securityMask, securityMask);
@@ -512,9 +512,9 @@ private long openKey(int securityMask) {
      * @param mask1 Preferred Windows security mask.
      * @param mask2 Alternate Windows security mask.
      * @return Windows registry key's handle.
-     * @see #openKey(byte[], int)
-     * @see #openKey(int, byte[], int)
-     * @see #closeKey(int)
+     * @see #openKey(byte[], int, int)
+     * @see #openKey(long, byte[], int, int)
+     * @see #closeKey(long)
      */
     private long openKey(int mask1, int mask2) {
         return openKey(windowsAbsolutePath(), mask1,  mask2);
@@ -529,8 +529,8 @@ private long openKey(int mask1, int mask2) {
      * @param mask2 Alternate Windows security mask.
      * @return Windows registry key's handle.
      * @see #openKey(int)
-     * @see #openKey(int, byte[],int)
-     * @see #closeKey(int)
+     * @see #openKey(long, byte[], int, int)
+     * @see #closeKey(long)
      */
     private long openKey(byte[] windowsAbsolutePath, int mask1, int mask2) {
         /*  Check if key's path is short enough be opened at once
@@ -568,15 +568,15 @@ private long openKey(byte[] windowsAbsolutePath, int mask1, int mask2) {
      /**
      * Opens Windows registry key at a given relative path
      * with respect to a given Windows registry key.
-     * @param windowsAbsolutePath Windows relative path of the
+     * @param windowsRelativePath Windows relative path of the
      *        key as a byte-encoded string.
      * @param nativeHandle handle to the base Windows key.
      * @param mask1 Preferred Windows security mask.
      * @param mask2 Alternate Windows security mask.
      * @return Windows registry key's handle.
      * @see #openKey(int)
-     * @see #openKey(byte[],int)
-     * @see #closeKey(int)
+     * @see #openKey(byte[], int, int)
+     * @see #closeKey(long)
      */
     private long openKey(long nativeHandle, byte[] windowsRelativePath,
                          int mask1, int mask2) {
@@ -630,10 +630,10 @@ private long openKey(long nativeHandle, byte[] windowsRelativePath,
      /**
      * Closes Windows registry key.
      * Logs a warning if Windows registry is unavailable.
-     * @param key's Windows registry handle.
+     * @param nativeHandle Windows registry handle.
      * @see #openKey(int)
-     * @see #openKey(byte[],int)
-     * @see #openKey(int, byte[],int)
+     * @see #openKey(byte[], int, int)
+     * @see #openKey(long, byte[], int, int)
     */
     private void closeKey(long nativeHandle) {
         int result = WindowsRegCloseKey(nativeHandle);
@@ -776,7 +776,7 @@ protected String[] keysSpi() throws BackingStoreException{
 
     /**
      * Implements {@code AbstractPreferences} {@code childrenNamesSpi()} method.
-     * Calls Windows registry to retrive children of this node.
+     * Calls Windows registry to retrieve children of this node.
      * Throws a BackingStoreException and logs a warning message,
      * if Windows registry is not available.
      */
@@ -807,7 +807,6 @@ protected String[] childrenNamesSpi() throws BackingStoreException {
             closeKey(nativeHandle);
             return new String[0];
         }
-        String[] subkeys = new String[subKeysNumber];
         String[] children = new String[subKeysNumber];
         // Get children
         for (int i = 0; i < subKeysNumber; i++) {
@@ -870,7 +869,7 @@ public void flush() throws BackingStoreException{
     /**
      * Implements {@code Preferences} {@code sync()} method.
      * Flushes Windows registry changes to disk. Equivalent to flush().
-     * @see flush()
+     * @see #flush()
      */
     public void sync() throws BackingStoreException{
         if (isRemoved())
@@ -929,8 +928,7 @@ public void removeNodeSpi() throws BackingStoreException {
     private static String toJavaName(byte[] windowsNameArray) {
         String windowsName = byteArrayToString(windowsNameArray);
         // check if Alt64
-        if ((windowsName.length() > 1) &&
-                (windowsName.substring(0, 2).equals("/!"))) {
+        if (windowsName.startsWith("/!")) {
             return toJavaAlt64Name(windowsName);
         }
         StringBuilder javaName = new StringBuilder();