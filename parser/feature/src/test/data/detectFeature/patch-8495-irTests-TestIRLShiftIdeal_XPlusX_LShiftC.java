@@ -31,6 +31,7 @@
  * @bug 8278114
  * @summary Test that transformation from (x + x) >> c to x >> (c + 1) works as intended.
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestIRLShiftIdeal_XPlusX_LShiftC
  */
 public class TestIRLShiftIdeal_XPlusX_LShiftC {