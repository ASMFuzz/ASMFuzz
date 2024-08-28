@@ -1002,7 +1002,7 @@ public void initialize(ImageInputStream stream, boolean isPrimaryIFD,
                 // The IFD entry value is a pointer to the actual field value.
                 long offset = stream.readUnsignedInt();
 
-                // Check whether the the field value is within the stream.
+                // Check whether the field value is within the stream.
                 if (haveStreamLength && offset + size > streamLength) {
                     continue;
                 }