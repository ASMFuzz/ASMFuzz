@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,7 +24,7 @@
 /* @test
  * @summary Unit test for java.net.URI
  * @bug 4464135 4505046 4503239 4438319 4991359 4866303 7023363 7041800
- *      7171415 6933879
+ *      7171415 6339649 6933879 8037396 8272072
  * @author Mark Reinhold
  */
 
@@ -1364,6 +1364,7 @@ static void eq(URI u, URI v) throws URISyntaxException {
     }
 
     static void eq(String expected, String actual) {
+        testCount++;
         if (expected == null && actual == null) {
             return;
         }
@@ -1612,9 +1613,11 @@ static void clargs(String base, String uri) {
     // miscellaneous bugs/rfes that don't fit in with the test framework
 
     static void bugs() {
+        header("Bugs");
         b6339649();
         b6933879();
         b8037396();
+        b8272072();
     }
 
     // 6339649 - include detail message from nested exception
@@ -1626,6 +1629,7 @@ private static void b6339649() {
                 throw new RuntimeException ("No detail message");
             }
         }
+        testCount++;
     }
 
     // 6933879 - check that "." and "_" characters are allowed in IPv6 scope_id.
@@ -1673,6 +1677,24 @@ private static void b8037396() {
         eq("a%20b[c%20d]", u.getRawFragment());
     }
 
+    // 8272072 - Resolving URI relative path with no "/" may lead to incorrect toString
+    private static void b8272072() {
+        try {
+            URI baseURI = new URI("http://example.com");
+            URI relativeURI = new URI("test");
+            URI resolvedURI = baseURI.resolve(relativeURI);
+
+            eq(new URI("http://example.com/test"), resolvedURI);
+
+            baseURI = new URI("relativeBase");
+            resolvedURI = baseURI.resolve(relativeURI);
+
+            eq(new URI("test"), resolvedURI);
+        } catch (URISyntaxException e) {
+            throw new AssertionError("shouldn't ever happen", e);
+        }
+    }
+
     public static void main(String[] args) throws Exception {
         switch (args.length) {
 