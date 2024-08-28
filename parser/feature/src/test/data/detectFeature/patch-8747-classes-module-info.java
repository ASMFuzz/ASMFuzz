@@ -78,6 +78,7 @@
  */
 module jdk.compiler {
     requires transitive java.compiler;
+    requires jdk.zipfs;
 
     exports com.sun.source.doctree;
     exports com.sun.source.tree;