@@ -43,7 +43,7 @@
  * @library /test/lib /testlibrary_tests /
  * @build sun.hotspot.WhiteBox
  * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
- * @run main/othervm/timeout=240 -Xbootclasspath/a:. -DSkipWhiteBoxInstall=true -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions
+ * @run main/othervm/timeout=240 -Xbootclasspath/a:. -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions
  *                               -XX:+WhiteBoxAPI -DPrintIREncoding=true  ir_framework.tests.TestIRMatching
  */
 