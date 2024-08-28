@@ -91,7 +91,11 @@ public static boolean signedBy(X509Certificate end, X509Certificate ca) {
     public static boolean isWindowsKeyStore(String storetype) {
         return storetype != null
                 && (storetype.equalsIgnoreCase("Windows-MY")
-                    || storetype.equalsIgnoreCase("Windows-ROOT"));
+                    || storetype.equalsIgnoreCase("Windows-ROOT")
+                    || storetype.equalsIgnoreCase("Windows-MY-CURRENTUSER")
+                    || storetype.equalsIgnoreCase("Windows-ROOT-CURRENTUSER")
+                    || storetype.equalsIgnoreCase("Windows-MY-LOCALMACHINE")
+                    || storetype.equalsIgnoreCase("Windows-ROOT-LOCALMACHINE"));
     }
 
     /**
@@ -102,6 +106,14 @@ public static String niceStoreTypeName(String storetype) {
             return "Windows-MY";
         } else if(storetype.equalsIgnoreCase("Windows-ROOT")) {
             return "Windows-ROOT";
+        } else if(storetype.equalsIgnoreCase("Windows-MY-CURRENTUSER")) {
+            return "Windows-MY-CURRENTUSER";
+        } else if(storetype.equalsIgnoreCase("Windows-ROOT-CURRENTUSER")) {
+            return "Windows-ROOT-CURRENTUSER";
+        } else if(storetype.equalsIgnoreCase("Windows-MY-LOCALMACHINE")) {
+            return "Windows-MY-LOCALMACHINE";
+        } else if(storetype.equalsIgnoreCase("Windows-ROOT-LOCALMACHINE")) {
+            return "Windows-ROOT-LOCALMACHINE";
         } else {
             return storetype.toUpperCase(Locale.ENGLISH);
         }