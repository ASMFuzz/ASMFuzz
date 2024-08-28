@@ -32,6 +32,7 @@
  * @summary Test that transformation from ~x + c to (c - 1) - x and
  *          from ~(x + c) to (-c - 1) - x works as intended.
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestIRAddIdealNotXPlusC
  */
 public class TestIRAddIdealNotXPlusC {