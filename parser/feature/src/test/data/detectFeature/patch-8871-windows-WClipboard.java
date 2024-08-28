@@ -83,13 +83,7 @@ protected void setContentsNative(Transferable contents) {
                         translateTransferable(contents, flavor, format);
                     publishClipboardData(format, bytes);
                 } catch (IOException e) {
-                    // Fix 4696186: don't print exception if data with
-                    // javaJVMLocalObjectMimeType failed to serialize.
-                    // May remove this if-check when 5078787 is fixed.
-                    if (!(flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType) &&
-                          e instanceof java.io.NotSerializableException)) {
-                        e.printStackTrace();
-                    }
+                    // Cannot be translated in this format, skip
                 }
             }
         } finally {