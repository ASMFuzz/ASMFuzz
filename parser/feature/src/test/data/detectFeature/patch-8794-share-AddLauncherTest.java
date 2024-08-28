@@ -52,7 +52,9 @@
  * @build jdk.jpackage.test.*
  * @modules jdk.jpackage/jdk.jpackage.internal
  * @compile AddLauncherTest.java
- * @run main/othervm/timeout=360 -Xmx512m jdk.jpackage.test.Main
+ * @run main/othervm/timeout=360 -Xmx512m
+ *  --add-opens jdk.jpackage/jdk.jpackage.internal=ALL-UNNAMED
+ *  jdk.jpackage.test.Main
  *  --jpt-run=AddLauncherTest.test
  */
 
@@ -65,7 +67,9 @@
  * @build jdk.jpackage.test.*
  * @modules jdk.jpackage/jdk.jpackage.internal
  * @compile AddLauncherTest.java
- * @run main/othervm/timeout=540 -Xmx512m jdk.jpackage.test.Main
+ * @run main/othervm/timeout=540 -Xmx512m
+ *  --add-opens jdk.jpackage/jdk.jpackage.internal=ALL-UNNAMED
+ *  jdk.jpackage.test.Main
  *  --jpt-run=AddLauncherTest
  */
 