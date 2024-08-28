@@ -108,7 +108,8 @@ private static boolean isUnixDomainOption(SocketOption<?> option) {
     }
 
     private static boolean isStreamOption(SocketOption<?> option, boolean server) {
-        if (option.name().startsWith("UDP_") || isUnixDomainOption(option)) {
+        if (option.name().startsWith("UDP_") || isUnixDomainOption(option)
+            || option.name().equals("IP_DONTFRAGMENT")) {
             return false;
         } else {
             return true;