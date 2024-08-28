@@ -255,14 +255,14 @@ private void setChannel(byte[] com) {
         if (channel <= 3) {
             // mask of bits 7, 1, 0 (channel number)
             // 0xbc == 1011 1100
-            com[0] &= 0xbc;
-            com[0] |= channel;
+            com[0] &= (byte) 0xbc;
+            com[0] |= (byte) channel;
         } else if (channel <= 19) {
             // mask of bits 7, 3, 2, 1, 0 (channel number)
             // 0xbc == 1011 0000
-            com[0] &= 0xb0;
-            com[0] |= 0x40;
-            com[0] |= (channel - 4);
+            com[0] &= (byte) 0xb0;
+            com[0] |= (byte) 0x40;
+            com[0] |= (byte) (channel - 4);
         } else {
             throw new RuntimeException("Unsupported channel number: " + channel);
         }