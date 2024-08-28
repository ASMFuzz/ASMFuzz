@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -135,13 +135,16 @@ var console = {
     }
 };
 
+var window = {
+    innerWidth: 800
+}
+
 var renderMenu = function(items) {
     var result = new java.util.ArrayList();
     var currentCategory = "";
     $.each(items, function(index, item) {
         var li;
-        if (item.l !== noResult.l && item.category !== currentCategory) {
-            // print(item.category);
+        if (item.l !== messages.noResult && item.category !== currentCategory) {
             currentCategory = item.category;
         }
         result.add(renderItem(item));
@@ -150,25 +153,7 @@ var renderMenu = function(items) {
 };
 
 var renderItem = function(item) {
-    var label;
-    if (item.category === catModules) {
-        label = item.l;
-    } else if (item.category === catPackages) {
-        label = (item.m)
-                ? item.m + "/" + item.l
-                : item.l;
-    } else if (item.category === catTypes) {
-        label = (item.p)
-                ? item.p + "." + item.l
-                : item.l;
-    } else if (item.category === catMembers) {
-        label = item.p + "." + item.c + "." + item.l;
-    } else if (item.category === catSearchTags) {
-        label = item.l;
-    } else {
-        label = item.l;
-    }
-    return label;
+    return item.l || item.input;
 };
 
 