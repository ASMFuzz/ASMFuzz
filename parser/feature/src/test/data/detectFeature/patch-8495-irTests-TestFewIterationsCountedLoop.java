@@ -30,6 +30,7 @@
  * @bug 8262721
  * @summary Add Tests to verify single iteration loops are properly optimized
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestFewIterationsCountedLoop
  */
 