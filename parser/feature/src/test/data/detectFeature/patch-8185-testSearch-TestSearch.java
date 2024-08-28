@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -709,29 +709,9 @@ void checkSearchJS() {
                 "##REPLACE:");
 
         checkOutput("search.js", true,
-                "function searchIndexWithMatcher(indexArray, matcher, category, nameFunc) {",
-                """
-                    function getURLPrefix(ui) {
-                        var urlPrefix="";
-                        var slash = "/";
-                        if (ui.item.category === catModules) {
-                            return ui.item.l + slash;
-                        } else if (ui.item.category === catPackages && ui.item.m) {
-                            return ui.item.m + slash;
-                        } else if (ui.item.category === catTypes || ui.item.category === catMembers) {
-                            if (ui.item.m) {
-                                urlPrefix = ui.item.m + slash;
-                            } else {
-                                $.each(packageSearchIndex, function(index, item) {
-                                    if (item.m && ui.item.p === item.l) {
-                                        urlPrefix = item.m + slash;
-                                    }
-                                });
-                            }
-                        }
-                        return urlPrefix;
-                    }""",
-                "url += ui.item.l;");
+                "function searchIndex(indexArray, category) {",
+                "function getURLPrefix(item, category) {",
+                "url += item.l;");
 
         checkCssClasses("search.js", "stylesheet.css");
     }