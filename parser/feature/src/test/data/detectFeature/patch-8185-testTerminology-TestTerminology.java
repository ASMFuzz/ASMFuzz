@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -143,11 +143,11 @@ public void testSearch(Path base, Path src, SourceVersion sv) {
 
         checkOutput("search.js", sv.compareTo(SourceVersion.RELEASE_16) < 0,
                 """
-                        var catTypes = "Types";""" //
+                        types: "Types","""
         );
         checkOutput("search.js", sv.compareTo(SourceVersion.RELEASE_16) >= 0,
                 """
-                        var catTypes = "Classes and Interfaces";"""
+                        types: "Classes and Interfaces","""
         );
     }
 