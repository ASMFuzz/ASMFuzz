@@ -232,7 +232,7 @@ public static void main(String... args) throws Exception {
         // insert  bytes in data section
         System.out.println("\n5. Insert bytes at beginning of data section, should fail\n");
         String insertBytes = startNewArchive("insert-bytes");
-        CDSArchiveUtils.insertBytesRandomlyAfterHeader(orgJsaFile, insertBytes, new byte[4096]);
+        CDSArchiveUtils.insertBytesRandomlyAfterHeader(orgJsaFile, insertBytes);
         testAndCheck(verifyExecArgs);
 
         // delete bytes in data section forward