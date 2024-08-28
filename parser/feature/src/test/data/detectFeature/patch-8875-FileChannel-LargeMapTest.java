@@ -37,7 +37,7 @@
  * @bug 8286637
  * @summary Ensure that memory mapping beyond 32-bit range does not cause an
  *          EXCEPTION_ACCESS_VIOLATION.
- * @run main/othervm LargeMapTest
+ * @run main/othervm/timeout=240 LargeMapTest
  */
 public class LargeMapTest {
     private static final String FILE = "test.dat";