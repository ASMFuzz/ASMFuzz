@@ -278,7 +278,7 @@ private static Set<String> schemesListToSet(String list) {
         allowRestrictedHeaders = Boolean.parseBoolean(
                 props.getProperty("sun.net.http.allowRestrictedHeaders"));
         if (!allowRestrictedHeaders) {
-            restrictedHeaderSet = new HashSet<>(restrictedHeaders.length);
+            restrictedHeaderSet = HashSet.newHashSet(restrictedHeaders.length);
             for (int i=0; i < restrictedHeaders.length; i++) {
                 restrictedHeaderSet.add(restrictedHeaders[i].toLowerCase());
             }