@@ -34,7 +34,7 @@
  * @build sun.hotspot.WhiteBox
  * @requires vm.compiler2.enabled
  * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
- * @run main/othervm -Xbootclasspath/a:. -DSkipWhiteBoxInstall=true -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI compiler.c2.irTests.TestSuperwordFailsUnrolling
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI compiler.c2.irTests.TestSuperwordFailsUnrolling
  */
 
 public class TestSuperwordFailsUnrolling {