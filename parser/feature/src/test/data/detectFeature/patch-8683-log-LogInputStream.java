@@ -103,7 +103,7 @@ public long skip(long n) throws IOException {
             return 0;
         n = (length < n) ? length : n;
         n = in.skip(n);
-        length -= n;
+        length -= (int) n;
         return n;
     }
 