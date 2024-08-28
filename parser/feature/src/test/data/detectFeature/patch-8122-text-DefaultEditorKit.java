@@ -339,7 +339,11 @@ public void write(Writer out, Document doc, int pos, int len)
                 for (int counter = last; counter < maxCounter; counter++) {
                     if (array[counter] == '\n') {
                         if (counter > last) {
-                            out.write(array, last, counter - last);
+                            if (array[counter - 1] == '\r') {
+                                out.write(array, last, counter - last - 1);
+                            } else {
+                                out.write(array, last, counter - last);
+                            }
                         }
                         out.write(endOfLine);
                         last = counter + 1;