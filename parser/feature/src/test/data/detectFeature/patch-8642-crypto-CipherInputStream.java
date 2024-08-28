@@ -297,7 +297,7 @@ public long skip(long n) throws IOException {
         if (n < 0) {
             return 0;
         }
-        ostart += n;
+        ostart += (int) n;
         return n;
     }
 