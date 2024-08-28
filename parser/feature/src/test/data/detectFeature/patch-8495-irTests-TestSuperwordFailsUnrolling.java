@@ -32,6 +32,7 @@
  * @summary C2: loop candidate for superword not always unrolled fully if superword fails
  * @library /test/lib /
  * @build sun.hotspot.WhiteBox
+ * @requires vm.compiler2.enabled
  * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
  * @run main/othervm -Xbootclasspath/a:. -DSkipWhiteBoxInstall=true -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI compiler.c2.irTests.TestSuperwordFailsUnrolling
  */