@@ -23,7 +23,7 @@
 
 /**
  * @test
- * @bug 8192920 8204588 8210275
+ * @bug 8192920 8204588 8210275 8286571
  * @summary Test source mode
  * @modules jdk.compiler jdk.jlink
  * @run main SourceMode
@@ -32,6 +32,7 @@
 
 import java.io.IOException;
 import java.io.PrintStream;
+import java.io.PrintWriter;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
@@ -106,6 +107,33 @@ void testSimpleJava() throws IOException {
         show(tr);
     }
 
+    // java --source N --enable-preview Simple.java hello
+    // on minimal jdk image containing jdk.compiler
+    @Test
+    void test8286571() throws IOException {
+        starting("test8286571");
+        var pw = new PrintWriter(System.out);
+        int rc = ToolProvider.findFirst("jlink").orElseThrow().run(
+                pw, pw,
+                "--add-modules",
+                "jdk.compiler",
+                "--output",
+                "comp_only");
+        if (rc != 0)
+            throw new AssertionError("Jlink failed: rc = " + rc);
+        Path file = getSimpleFile("Simple.java", false);
+        TestResult tr = doExec(
+                Path.of("comp_only", "bin", isWindows ? "java.exe" : "java").toString(),
+                "--source", thisVersion,
+                "--enable-preview",
+                file.toString(), "hello");
+        if (!tr.isOK())
+            error(tr, "Bad exit code: " + tr.exitValue);
+        if (!tr.contains("[hello]"))
+            error(tr, "Expected output not found");
+        show(tr);
+    }
+
     // java --source N simple 1 2 3
     @Test
     void testSimple() throws IOException {