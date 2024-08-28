@@ -49,7 +49,9 @@
  * @build jdk.jpackage.test.*
  * @modules jdk.jpackage/jdk.jpackage.internal
  * @compile MultiLauncherTwoPhaseTest.java
- * @run main/othervm/timeout=360 -Xmx512m jdk.jpackage.test.Main
+ * @run main/othervm/timeout=360 -Xmx512m
+ *  --add-opens jdk.jpackage/jdk.jpackage.internal=ALL-UNNAMED
+ *  jdk.jpackage.test.Main
  *  --jpt-run=MultiLauncherTwoPhaseTest
  */
 