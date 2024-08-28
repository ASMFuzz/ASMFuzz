@@ -30,6 +30,7 @@
  * bug 8281322
  * @summary check counted loop is properly constructed with/without safepoint
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestCountedLoopSafepoint
  */
 