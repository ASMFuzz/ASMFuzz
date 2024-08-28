@@ -475,7 +475,7 @@ private long implSkip(long n) throws IOException {
             }
             long d = nChars - nextChar;
             if (r <= d) {
-                nextChar += r;
+                nextChar += (int)r;
                 r = 0;
                 break;
             }