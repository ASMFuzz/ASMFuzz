@@ -58,6 +58,7 @@
  *     JDK 1.3 classic VM for Sparc may crash (core dump) due to the known bug:
  *         #4245057 (P2/S3) VM crashes when heap is exhausted
  *
+ * @requires vm.opt.DeoptimizeALot != true
  * @run main/othervm -Xms50M -Xmx200M nsk.stress.except.except010
  */
 