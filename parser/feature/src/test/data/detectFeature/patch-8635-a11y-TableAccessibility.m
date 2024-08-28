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