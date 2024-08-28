@@ -23,7 +23,7 @@
 
 /* @test
  * @summary Comprehensive test for FileChannel.transfer{From,To}
- * @bug 4708120
+ * @bug 4708120 8274113
  * @author Mark Reinhold
  * @run main/timeout=300 Transfers
  */
@@ -468,10 +468,16 @@ static void testFrom(long seed, Source src, FileChannel fc, int off, int len)
         int pos = (int)seed & 0xfff;
         fc.position(pos);
 
-        int n = (int)fc.transferFrom(src.channel(), off, len);
-        if (n != len)
-            throw new Failure("Incorrect transfer length: " + n
-                              + " (expected " + len + ")");
+        long position = off;
+        long count = len;
+        while (count > 0) {
+            int n = (int)fc.transferFrom(src.channel(), position, count);
+            if (n < 0 || n > count)
+                throw new Failure("Incorrect transfer length n = : " + n
+                                  + " (expected 0 <= n <= " + len + ")");
+            position += n;
+            count -= n;
+        }
 
         // Check that source didn't change, and was read correctly
         src.verify();