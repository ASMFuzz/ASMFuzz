@@ -151,7 +151,7 @@ public Object translateBytes(byte[] bytes, DataFlavor flavor,
         if(isUriListFlavor(flavor) && format == CF_FILE) {
             // dragQueryFile works fine with files and url,
             // it parses and extracts values from property list.
-            // maxosx always returns property list for
+            // macosx always returns property list for
             // CF_URL and CF_FILE
             String[] strings = dragQueryFile(bytes);
             if(strings == null) {
@@ -160,7 +160,7 @@ public Object translateBytes(byte[] bytes, DataFlavor flavor,
             bytes = String.join(System.getProperty("line.separator"),
                     strings).getBytes();
             // now we extracted uri from xml, now we should treat it as
-            // regular string that allows to translate data to target represantation
+            // regular string that allows to translate data to target representation
             // class by base method
             format = CF_STRING;
         }