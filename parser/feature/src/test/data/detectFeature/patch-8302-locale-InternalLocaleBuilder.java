@@ -313,7 +313,7 @@ private InternalLocaleBuilder setExtensions(List<String> bcpExtensions, String p
         clearExtensions();
 
         if (!LocaleUtils.isEmpty(bcpExtensions)) {
-            Set<CaseInsensitiveChar> done = new HashSet<>(bcpExtensions.size());
+            Set<CaseInsensitiveChar> done = HashSet.newHashSet(bcpExtensions.size());
             for (String bcpExt : bcpExtensions) {
                 CaseInsensitiveChar key = new CaseInsensitiveChar(bcpExt);
                 // ignore duplicates