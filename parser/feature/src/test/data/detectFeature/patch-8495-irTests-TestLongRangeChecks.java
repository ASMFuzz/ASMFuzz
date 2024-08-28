@@ -31,6 +31,7 @@
  * @bug 8259609 8276116
  * @summary C2: optimize long range checks in long counted loops
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestLongRangeChecks
  */
 