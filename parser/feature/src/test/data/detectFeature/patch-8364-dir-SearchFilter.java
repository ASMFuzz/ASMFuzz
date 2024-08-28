@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -82,7 +82,7 @@ public boolean check(Attributes targetAttrs) throws NamingException {
      * Utility routines used by member classes
      */
 
-    // does some pre-processing on the string to make it look exactly lik
+    // does some pre-processing on the string to make it look exactly like
     // what the parser expects. This only needs to be called once.
     protected void normalizeFilter() {
         skipWhiteSpace(); // get rid of any leading whitespaces
@@ -400,7 +400,7 @@ private boolean substringMatch(String proto, String value) {
                     !value.toLowerCase(Locale.ENGLISH).startsWith(
                         subStrs.nextToken().toLowerCase(Locale.ENGLISH))) {
                 if(debug) {
-                    System.out.println("faild initial test");
+                    System.out.println("failed initial test");
                 }
                 return false;
             }
@@ -421,7 +421,7 @@ private boolean substringMatch(String proto, String value) {
             // do we need to end with the last token?
             if(proto.charAt(proto.length() - 1) != WILDCARD_TOKEN &&
                currentPos != value.length() ) {
-                if(debug) {System.out.println("faild final test");}
+                if(debug) {System.out.println("failed final test");}
                 return false;
             }
 