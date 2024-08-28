@@ -56,7 +56,7 @@ private PBEKeyFactory(String keytype) {
     }
 
     static {
-        validTypes = new HashSet<>(17);
+        validTypes = HashSet.newHashSet(17);
         validTypes.add("PBEWithMD5AndDES".toUpperCase(Locale.ENGLISH));
         validTypes.add("PBEWithSHA1AndDESede".toUpperCase(Locale.ENGLISH));
         validTypes.add("PBEWithSHA1AndRC2_40".toUpperCase(Locale.ENGLISH));