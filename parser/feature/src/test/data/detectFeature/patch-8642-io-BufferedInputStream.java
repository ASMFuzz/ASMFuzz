@@ -436,7 +436,7 @@ private long implSkip(long n) throws IOException {
         }
 
         long skipped = (avail < n) ? avail : n;
-        pos += skipped;
+        pos += (int)skipped;
         return skipped;
     }
 