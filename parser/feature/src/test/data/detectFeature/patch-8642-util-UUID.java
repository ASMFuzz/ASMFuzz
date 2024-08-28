@@ -152,7 +152,7 @@ public static UUID randomUUID() {
         randomBytes[6]  &= 0x0f;  /* clear version        */
         randomBytes[6]  |= 0x40;  /* set to version 4     */
         randomBytes[8]  &= 0x3f;  /* clear variant        */
-        randomBytes[8]  |= 0x80;  /* set to IETF variant  */
+        randomBytes[8]  |= (byte) 0x80;  /* set to IETF variant  */
         return new UUID(randomBytes);
     }
 
@@ -176,7 +176,7 @@ public static UUID nameUUIDFromBytes(byte[] name) {
         md5Bytes[6]  &= 0x0f;  /* clear version        */
         md5Bytes[6]  |= 0x30;  /* set to version 3     */
         md5Bytes[8]  &= 0x3f;  /* clear variant        */
-        md5Bytes[8]  |= 0x80;  /* set to IETF variant  */
+        md5Bytes[8]  |= (byte) 0x80;  /* set to IETF variant  */
         return new UUID(md5Bytes);
     }
 