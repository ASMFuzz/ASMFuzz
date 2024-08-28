@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -87,12 +87,6 @@ public List<String> run() {
 
     private static final boolean DEBUG = false;
 
-    private static void debug(Object o) {
-        if (DEBUG) {
-            System.out.println(o);
-        }
-    }
-
     // file name containing this configuration
     private String filename;
 
@@ -548,7 +542,9 @@ private void parse() throws IOException {
 
     private int nextToken() throws IOException {
         int token = st.nextToken();
-        debug(st);
+        if (DEBUG)  {
+            System.out.println(st);
+        }
         return token;
     }
 
@@ -595,23 +591,29 @@ private String parseStringEntry(String keyword) throws IOException {
         }
         String value = st.sval;
 
-        debug(keyword + ": " + value);
+        if (DEBUG) {
+            System.out.println(keyword + ": " + value);
+        }
         return value;
     }
 
     private boolean parseBooleanEntry(String keyword) throws IOException {
         checkDup(keyword);
         parseEquals();
         boolean value = parseBoolean();
-        debug(keyword + ": " + value);
+        if (DEBUG) {
+            System.out.println(keyword + ": " + value);
+        }
         return value;
     }
 
     private int parseIntegerEntry(String keyword) throws IOException {
         checkDup(keyword);
         parseEquals();
         int value = decodeNumber(parseWord());
-        debug(keyword + ": " + value);
+        if (DEBUG) {
+            System.out.println(keyword + ": " + value);
+        }
         return value;
     }
 
@@ -716,7 +718,9 @@ private String parseLibrary(String keyword) throws IOException {
             String suffix = lib.substring(i + 5);
             lib = prefix + suffix;
         }
-        debug(keyword + ": " + lib);
+        if (DEBUG) {
+            System.out.println(keyword + ": " + lib);
+        }
 
         // Check to see if full path is specified to prevent the DLL
         // preloading attack
@@ -731,7 +735,9 @@ private void parseDescription(String keyword) throws IOException {
         checkDup(keyword);
         parseEquals();
         description = parseLine();
-        debug("description: " + description);
+        if (DEBUG) {
+            System.out.println("description: " + description);
+        }
     }
 
     private void parseSlotID(String keyword) throws IOException {
@@ -745,7 +751,9 @@ private void parseSlotID(String keyword) throws IOException {
         parseEquals();
         String slotString = parseWord();
         slotID = decodeNumber(slotString);
-        debug("slot: " + slotID);
+        if (DEBUG) {
+            System.out.println("slot: " + slotID);
+        }
     }
 
     private void parseSlotListIndex(String keyword) throws IOException {
@@ -759,7 +767,9 @@ private void parseSlotListIndex(String keyword) throws IOException {
         parseEquals();
         String slotString = parseWord();
         slotListIndex = decodeNumber(slotString);
-        debug("slotListIndex: " + slotListIndex);
+        if (DEBUG) {
+            System.out.println("slotListIndex: " + slotListIndex);
+        }
     }
 
     private void parseEnabledMechanisms(String keyword) throws IOException {
@@ -1021,7 +1031,9 @@ private void parseNSSArgs(String keyword) throws IOException {
             throw excToken("Expected quoted string");
         }
         nssArgs = expand(st.sval);
-        debug("nssArgs: " + nssArgs);
+        if (DEBUG) {
+            System.out.println("nssArgs: " + nssArgs);
+        }
     }
 
     private void parseHandleStartupErrors(String keyword) throws IOException {
@@ -1037,7 +1049,9 @@ private void parseHandleStartupErrors(String keyword) throws IOException {
         } else {
             throw excToken("Invalid value for handleStartupErrors:");
         }
-        debug("handleStartupErrors: " + handleStartupErrors);
+        if (DEBUG) {
+            System.out.println("handleStartupErrors: " + handleStartupErrors);
+        }
     }
 
 }