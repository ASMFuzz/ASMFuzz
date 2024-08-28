@@ -323,7 +323,7 @@ public long skip(long n) throws IOException {
             if (n < pskip) {
                 pskip = n;
             }
-            pos += pskip;
+            pos += (int) pskip;
             n -= pskip;
         }
         if (n > 0) {