@@ -409,18 +409,41 @@ public static long writeData(File file, long offset, int value) throws Exception
          }
     }
 
-    // dstFile will keep original size so will remove corresponding bytes.length bytes at end of file
-    public static File insertBytesRandomlyAfterHeader(File orgFile, String newFileName, byte[] bytes) throws Exception {
-        long offset = fileHeaderSize(orgFile) + getRandomBetween(0L, 4096L);
+    // Helper method for calling FileChannel.transferFrom and checking the
+    // return value.
+    private static void transferFrom(FileChannel inputChannel,
+                                     FileChannel outputChannel,
+                                     long offset,
+                                     long length) throws Exception {
+        long position = offset;
+        long count = length;
+        while (count > 0 && inputChannel.position() < inputChannel.size()) {
+            long n = outputChannel.transferFrom(inputChannel, position, count);
+            if (n < 0 || n > count) {
+                throw new RuntimeException("Incorrect transfer length n = " + n
+                                           + " (expected 0 <= n <= " + length + ")");
+            }
+            position += n;
+            count -= n;
+        }
+    }
+
+    // dstFile will keep original size
+    public static File insertBytesRandomlyAfterHeader(File orgFile, String newFileName) throws Exception {
+        long headerSize = fileHeaderSize(orgFile);
+        long dupSize = getRandomBetween(0L, headerSize);
         File dstFile = new File(newFileName);
         try (FileChannel inputChannel = new FileInputStream(orgFile).getChannel();
              FileChannel outputChannel = new FileOutputStream(dstFile).getChannel()) {
             long orgSize = inputChannel.size();
-            outputChannel.transferFrom(inputChannel, 0, offset);
-            outputChannel.position(offset);
-            outputChannel.write(ByteBuffer.wrap(bytes));
-            outputChannel.transferFrom(inputChannel, offset + bytes.length, orgSize - bytes.length);
-        }
+            // Copy the header
+            transferFrom(inputChannel, outputChannel, 0, headerSize);
+            // Copy dupSize bytes from the end of the header. Then, copy the rest
+            // of the input such that the new file will have the same size as
+            // the old file.
+            inputChannel.position(headerSize - dupSize);
+            transferFrom(inputChannel, outputChannel, headerSize, orgSize - headerSize);
+            }
         return dstFile;
     }
 
@@ -431,9 +454,9 @@ public static File deleteBytesAtRandomPositionAfterHeader(File orgFile, String n
         try (FileChannel inputChannel = new FileInputStream(orgFile).getChannel();
              FileChannel outputChannel = new FileOutputStream(dstFile).getChannel()) {
             long orgSize = inputChannel.size();
-            outputChannel.transferFrom(inputChannel, 0, offset);
+            transferFrom(inputChannel, outputChannel, 0, offset);
             inputChannel.position(offset + nBytes);
-            outputChannel.transferFrom(inputChannel, offset, orgSize - nBytes);
+            transferFrom(inputChannel, outputChannel, offset, orgSize - nBytes);
         }
         return dstFile;
     }