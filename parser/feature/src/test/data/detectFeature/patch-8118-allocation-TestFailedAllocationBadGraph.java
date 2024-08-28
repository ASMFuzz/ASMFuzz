@@ -25,10 +25,11 @@
  * @test
  * bug 8279219
  * @summary C2 crash when allocating array of size too large
+ * @requires vm.compiler2.enabled
  * @library /test/lib /
  * @build sun.hotspot.WhiteBox
  * @run driver jdk.test.lib.helpers.ClassFileInstaller sun.hotspot.WhiteBox
- * @run main/othervm  -ea -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -XX:-BackgroundCompilation TestFailedAllocationBadGraph
+ * @run main/othervm -ea -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -XX:-BackgroundCompilation TestFailedAllocationBadGraph
  */
 
 import sun.hotspot.WhiteBox;