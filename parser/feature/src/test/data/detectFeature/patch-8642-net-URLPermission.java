@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -418,7 +418,7 @@ private List<String> normalizeMethods(String methods) {
                     "White space not allowed in methods: \"" + methods + "\"");
             } else {
                 if (c >= 'a' && c <= 'z') {
-                    c += 'A' - 'a';
+                    c += (char) ('A' - 'a');
                 }
                 b.append(c);
             }
@@ -437,7 +437,7 @@ private List<String> normalizeHeaders(String headers) {
             char c = headers.charAt(i);
             if (c >= 'a' && c <= 'z') {
                 if (capitalizeNext) {
-                    c += 'A' - 'a';
+                    c += (char) ('A' - 'a');
                     capitalizeNext = false;
                 }
                 b.append(c);