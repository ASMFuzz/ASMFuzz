@@ -270,8 +270,8 @@ public void save() throws IOException {
             b.append("# S L link_only_source timestamp\n");
             b.append("# G C generated_source timestamp\n");
             b.append("# A artifact timestamp\n");
-            b.append("# D S dependant -> source dependency\n");
-            b.append("# D C dependant -> classpath dependency\n");
+            b.append("# D S dependent -> source dependency\n");
+            b.append("# D C dependent -> classpath dependency\n");
             b.append("# I pubapi\n");
             b.append("R ").append(theArgs).append("\n");
 