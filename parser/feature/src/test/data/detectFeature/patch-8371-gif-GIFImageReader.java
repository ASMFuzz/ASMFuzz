@@ -962,7 +962,8 @@ public BufferedImage read(int imageIndex, ImageReadParam param)
             this.clearCode = 1 << initCodeSize;
             this.eofCode = clearCode + 1;
 
-            int code, oldCode = 0;
+            final int NULL_CODE = -1;
+            int code, oldCode = NULL_CODE;
 
             int[] prefix = new int[4096];
             byte[] suffix = new byte[4096];
@@ -985,6 +986,7 @@ public BufferedImage read(int imageIndex, ImageReadParam param)
                     codeMask = (1 << codeSize) - 1;
 
                     code = getCode(codeSize, codeMask);
+                    oldCode = NULL_CODE;
                     if (code == eofCode) {
                         // Inform IIOReadProgressListeners of end of image
                         processImageComplete();
@@ -1007,24 +1009,21 @@ public BufferedImage read(int imageIndex, ImageReadParam param)
                         }
                     }
 
-                    if (tableIndex >= prefix.length) {
-                        throw new IIOException("Code buffer limit reached,"
-                                + " no End of Image tag present, possibly data is corrupted. ");
-                    }
-
-                    int ti = tableIndex;
-                    int oc = oldCode;
+                    if (NULL_CODE != oldCode && tableIndex < 4096) {
+                        int ti = tableIndex;
+                        int oc = oldCode;
 
-                    prefix[ti] = oc;
-                    suffix[ti] = initial[newSuffixIndex];
-                    initial[ti] = initial[oc];
-                    length[ti] = length[oc] + 1;
+                        prefix[ti] = oc;
+                        suffix[ti] = initial[newSuffixIndex];
+                        initial[ti] = initial[oc];
+                        length[ti] = length[oc] + 1;
 
-                    ++tableIndex;
-                    if ((tableIndex == (1 << codeSize)) &&
-                        (tableIndex < 4096)) {
-                        ++codeSize;
-                        codeMask = (1 << codeSize) - 1;
+                        ++tableIndex;
+                        if ((tableIndex == (1 << codeSize)) &&
+                            (tableIndex < 4096)) {
+                            ++codeSize;
+                            codeMask = (1 << codeSize) - 1;
+                        }
                     }
                 }
 