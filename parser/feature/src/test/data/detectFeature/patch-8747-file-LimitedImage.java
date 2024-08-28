@@ -24,7 +24,7 @@
 /**
  * @test
  * @bug 8153391
- * @summary Verify javac behaves properly in absence of zip/jar FileSystemProvider
+ * @summary Verify javac behaves properly in JDK image limited to jdk.compiler module
  * @library /tools/lib
  * @modules jdk.compiler/com.sun.tools.javac.api
  *          jdk.compiler/com.sun.tools.javac.main
@@ -34,14 +34,11 @@
 import java.io.IOException;
 import java.nio.file.Path;
 import java.nio.file.Paths;
-import java.util.Arrays;
-import java.util.List;
 
 import toolbox.JavacTask;
 import toolbox.JarTask;
 import toolbox.Task.Expect;
 import toolbox.Task.Mode;
-import toolbox.Task.OutputKind;
 import toolbox.ToolBox;
 
 public class LimitedImage {
@@ -68,73 +65,39 @@ public static void main(String... args) throws IOException {
 
         new JarTask(tb, testJar).run();
 
-        List<String> actualOutput;
-        List<String> expectedOutput = Arrays.asList(
-                "- compiler.err.no.zipfs.for.archive: " + testJar.toString()
-        );
-
         //check proper diagnostics when zip/jar FS not present:
         System.err.println("Test " + testJar + " on classpath");
-        actualOutput = new JavacTask(tb, Mode.CMDLINE)
+        new JavacTask(tb, Mode.CMDLINE)
                 .classpath(testJar)
                 .options("-XDrawDiagnostics")
                 .files(testSource)
                 .outdir(".")
-                .run(Expect.FAIL)
-                .writeAll()
-                .getOutputLines(OutputKind.DIRECT);
-
-        if (!expectedOutput.equals(actualOutput)) {
-            throw new AssertionError("Unexpected output");
-        }
+                .run(Expect.SUCCESS);
 
         System.err.println("Test " + testJar + " on sourcepath");
-        actualOutput = new JavacTask(tb, Mode.CMDLINE)
+        new JavacTask(tb, Mode.CMDLINE)
                 .sourcepath(testJar)
                 .options("-XDrawDiagnostics")
                 .files(testSource)
                 .outdir(".")
-                .run(Expect.FAIL)
-                .writeAll()
-                .getOutputLines(OutputKind.DIRECT);
-
-        if (!expectedOutput.equals(actualOutput)) {
-            throw new AssertionError("Unexpected output");
-        }
+                .run(Expect.SUCCESS);
 
         System.err.println("Test " + testJar + " on modulepath");
-        actualOutput = new JavacTask(tb, Mode.CMDLINE)
+        new JavacTask(tb, Mode.CMDLINE)
                 .options("-XDrawDiagnostics",
                          "--module-path", testJar.toString())
                 .files(testSource)
                 .outdir(".")
-                .run(Expect.FAIL)
-                .writeAll()
-                .getOutputLines(OutputKind.DIRECT);
-
-        if (!expectedOutput.equals(actualOutput)) {
-            throw new AssertionError("Unexpected output");
-        }
-
-        expectedOutput = Arrays.asList(
-                "- compiler.err.no.zipfs.for.archive: " + testJar.toString(),
-                "1 error"
-        );
+                .run(Expect.SUCCESS);
 
         System.err.println("Test directory containing " + testJar + " on modulepath");
-        actualOutput = new JavacTask(tb, Mode.CMDLINE)
+        new JavacTask(tb, Mode.CMDLINE)
                 .classpath()
                 .options("-XDrawDiagnostics",
                          "--module-path", testJar.getParent().toString())
                 .files(testSource)
                 .outdir(".")
-                .run(Expect.FAIL)
-                .writeAll()
-                .getOutputLines(OutputKind.DIRECT);
-
-        if (!expectedOutput.equals(actualOutput)) {
-            throw new AssertionError("Unexpected output");
-        }
+                .run(Expect.SUCCESS);
     }
 
 }