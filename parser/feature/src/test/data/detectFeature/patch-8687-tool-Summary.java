@@ -147,19 +147,11 @@ private void printInformation(Path p) throws IOException {
             String header = "      Count  Size (bytes) ";
             String typeHeader = " Event Type";
             minWidth = Math.max(minWidth, typeHeader.length());
-            println(typeHeader + pad(minWidth - typeHeader.length(), ' ') + header);
-            println(pad(minWidth + header.length(), '='));
+            println(typeHeader + " ".repeat(minWidth - typeHeader.length()) + header);
+            println("=".repeat(minWidth + header.length()));
             for (Statistics s : statsList) {
                 System.out.printf(" %-" + minWidth + "s%10d  %12d\n", s.name, s.count, s.size);
             }
         }
     }
-
-    private String pad(int count, char c) {
-        StringBuilder sb = new StringBuilder();
-        for (int i = 0; i < count; i++) {
-            sb.append(c);
-        }
-        return sb.toString();
-    }
 }