@@ -31,6 +31,7 @@
  * @bug 8279888
  * @summary Local variable independently used by multiple loops can interfere with loop optimizations
  * @library /test/lib /
+ * @requires vm.compiler2.enabled
  * @run driver compiler.c2.irTests.TestDuplicateBackedge
  */
 