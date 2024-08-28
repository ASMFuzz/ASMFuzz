@@ -31,6 +31,7 @@
  * @run main TestAuthor
  */
 
+import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
@@ -81,6 +82,45 @@ public void testNoAuthor() {
         checkAuthor(false);
     }
 
+    @Test
+    public void testBadAuthor_NoWarning(Path base) throws IOException {
+        testBadAuthor(base, false);
+    }
+
+    @Test
+    public void testBadAuthor_Warning(Path base) throws IOException {
+        testBadAuthor(base, true);
+    }
+
+    public void testBadAuthor(Path base, boolean useAuthorOption) throws IOException {
+        Path src = base.resolve("src");
+        tb.writeJavaFiles(src,
+                """
+                    package pkg;
+                    /** Comment. */
+                    public class Test {
+                        private Test() { }
+                        /**
+                         * Comment.
+                         * @author anonymous
+                         */
+                        public void m() { }
+                    }""");
+
+        javadoc("-d", base.resolve("out").toString(),
+                "-sourcepath", src.toString(),
+                "-Xdoclint:none",
+                (useAuthorOption ? "-author" : "-XDdummy=dummy"),
+                "pkg");
+        checkExit(Exit.OK);
+
+        // bad tags never cause corresponding output, whether the option is enabled or not
+        checkAuthor(false);
+
+        checkOutput(Output.OUT, useAuthorOption,
+                "warning: Tag @author cannot be used in method documentation.");
+    }
+
     void checkAuthor(boolean on) {
         checkOutput("pkg/Test.html", on,
                 """