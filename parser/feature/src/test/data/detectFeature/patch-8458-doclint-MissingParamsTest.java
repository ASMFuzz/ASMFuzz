@@ -1,6 +1,6 @@
 /*
  * @test /nodynamiccopyright/
- * @bug 8004832
+ * @bug 8004832 8285496
  * @summary Add new doclint package
  * @modules jdk.javadoc/jdk.javadoc.internal.doclint
  * @build DocLintTester
@@ -21,4 +21,7 @@ void missingParam(int param) { }
 
     /** . */
     <T> void missingTyparam() { }
+
+    /** . */
+    public class MissingTyparam<T> { /** . */ MissingTyparam() { } }
 }