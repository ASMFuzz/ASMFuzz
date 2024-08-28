@@ -1,6 +1,6 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2021, JetBrains s.r.o.. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, JetBrains s.r.o.. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -130,6 +130,15 @@ - (TableRowAccessibility *)createRowWithIndex:(NSUInteger)index
     if (rowCache == nil) {
         int rowCount = [self accessibilityRowCount];
         rowCache = [[NSMutableDictionary<NSNumber*, id> dictionaryWithCapacity:rowCount] retain];
+        cacheValid = YES;
+    }
+
+    if (!cacheValid) {
+        for (NSNumber *key in [rowCache allKeys]) {
+            [[rowCache objectForKey:key] release];
+            [rowCache removeObjectForKey:key];
+        }
+        cacheValid = YES;
     }
 
     id row = [rowCache objectForKey:[NSNumber numberWithUnsignedInteger:index]];
@@ -223,11 +232,7 @@ - (NSArray *)accessibilitySelectedCells
 }
 
 - (void)clearCache {
-    for (NSNumber *key in [rowCache allKeys]) {
-        [[rowCache objectForKey:key] release];
-    }
-    [rowCache release];
-    rowCache = nil;
+    cacheValid = NO;
 }
 
 @end