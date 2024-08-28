@@ -29,6 +29,7 @@
 @interface TableAccessibility : CommonComponentAccessibility <NSAccessibilityTable>
 {
     NSMutableDictionary<NSNumber*, id> *rowCache;
+    BOOL cacheValid;
 }
 
 - (BOOL)isAccessibleChildSelectedFromIndex:(int)index;