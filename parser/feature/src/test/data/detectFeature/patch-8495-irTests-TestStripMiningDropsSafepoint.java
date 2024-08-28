@@ -30,6 +30,7 @@
  * @bug 8282045
  * @summary When loop strip mining fails, safepoints are removed from loop anyway
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestStripMiningDropsSafepoint
  */
 