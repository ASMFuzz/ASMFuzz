@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug 8270139 8273039
+ * @bug 8270139 8273039 8286895
  * @summary Verify error recovery in JShell
  * @modules jdk.compiler/com.sun.tools.javac.api
  *          jdk.compiler/com.sun.tools.javac.main
@@ -57,4 +57,12 @@ public void testBrokenName() {
                    DiagCheck.DIAG_IGNORE,
                    ste(MAIN_SNIPPET, NONEXISTENT, REJECTED, false, null));
     }
+
+    public void testBooleanPatternExpression() {
+        assertEval("Number n = 0;");
+        assertEval("if (!n instanceof Integer i) {}",
+                   DiagCheck.DIAG_ERROR,
+                   DiagCheck.DIAG_IGNORE,
+                   ste(MAIN_SNIPPET, NONEXISTENT, REJECTED, false, null));
+    }
 }