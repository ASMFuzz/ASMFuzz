@@ -334,7 +334,7 @@ private InternalLocaleBuilder setExtensions(List<String> bcpExtensions, String p
         if (privateuse != null && !privateuse.isEmpty()) {
             // privateuse string contains prefix, e.g. "x-abc-def"
             if (extensions == null) {
-                extensions = new HashMap<>(1);
+                extensions = HashMap.newHashMap(1);
             }
             extensions.put(new CaseInsensitiveChar(privateuse), privateuse.substring(2));
         }