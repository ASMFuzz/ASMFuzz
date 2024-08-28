@@ -96,10 +96,13 @@ public long transferTo(FileChannel out) throws IOException {
                 assert current != null;
 
                 long rem = current.getSize();
-
                 while (rem > 0) {
                     long n = Math.min(rem, 1024 * 1024);
                     long w = out.transferFrom(channel, pos, n);
+                    // Prevent endless loop
+                    if (w == 0) {
+                        return out.size();
+                    }
                     pos += w;
                     rem -= w;
                 }
@@ -111,7 +114,7 @@ public long transferTo(FileChannel out) throws IOException {
                 current = null;
             }
             if (!nextChannel()) {
-                return pos;
+                return out.size();
             }
         }
     }