@@ -48,10 +48,10 @@
 
 /*
  * @test
- * @bug 8186958 8210280 8281631
+ * @bug 8186958 8210280 8281631 8285386
  * @modules java.base/java.util:open
  * @summary White box tests for HashMap-related internals around table sizing
- * @run testng WhiteBoxResizeTest
+ * @run testng/othervm -Xmx2g WhiteBoxResizeTest
  */
 public class WhiteBoxResizeTest {
 