@@ -1292,13 +1292,12 @@ static Source get(File file, boolean toDelete, ZipCoder zc) throws IOException {
             src = new Source(key, toDelete, zc);
 
             synchronized (files) {
-                if (files.containsKey(key)) {    // someone else put in first
-                    src.close();                 // close the newly created one
-                    src = files.get(key);
-                    src.refs++;
-                    return src;
+                Source prev = files.putIfAbsent(key, src);
+                if (prev != null) {    // someone else put in first
+                    src.close();       // close the newly created one
+                    prev.refs++;
+                    return prev;
                 }
-                files.put(key, src);
                 return src;
             }
         }