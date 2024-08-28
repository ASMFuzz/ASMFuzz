@@ -37,7 +37,7 @@
  * @library /test/lib /
  * @build sun.hotspot.WhiteBox
  * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
- * @run main/othervm -Xbootclasspath/a:. -DSkipWhiteBoxInstall=true -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions
+ * @run main/othervm -Xbootclasspath/a:. -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions
  *                   -Xbatch -XX:+WhiteBoxAPI ir_framework.tests.TestCompLevels
  */
 