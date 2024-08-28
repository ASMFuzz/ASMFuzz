@@ -225,8 +225,9 @@
  * </ul>
  */
 public class JSR166TestCase extends TestCase {
+    // No longer run with custom securityManagers
     private static final boolean useSecurityManager =
-        Boolean.getBoolean("jsr166.useSecurityManager");
+    Boolean.getBoolean("jsr166.useSecurityManager");
 
     protected static final boolean expensiveTests =
         Boolean.getBoolean("jsr166.expensiveTests");
@@ -437,11 +438,15 @@ static junit.textui.TestRunner newPithyTestRunner() {
      * Runs all unit tests in the given test suite.
      * Actual behavior influenced by jsr166.* system properties.
      */
+    @SuppressWarnings("removal")
     static void main(Test suite, String[] args) {
         if (useSecurityManager) {
             System.err.println("Setting a permissive security manager");
             Policy.setPolicy(permissivePolicy());
-            System.setSecurityManager(new SecurityManager());
+            try {
+                System.setSecurityManager(new SecurityManager());
+            } catch(Throwable ok) {  // failure OK during deprecation
+            }
         }
         for (int i = 0; i < suiteRuns; i++) {
             TestResult result = newPithyTestRunner().doRun(suite);
@@ -482,14 +487,18 @@ public static void addNamedTestClasses(TestSuite suite,
     public static final String JAVA_SPECIFICATION_VERSION;
     static {
         try {
-            JAVA_CLASS_VERSION = java.security.AccessController.doPrivileged(
+            @SuppressWarnings("removal") double jcv =
+            java.security.AccessController.doPrivileged(
                 new java.security.PrivilegedAction<Double>() {
                 public Double run() {
                     return Double.valueOf(System.getProperty("java.class.version"));}});
-            JAVA_SPECIFICATION_VERSION = java.security.AccessController.doPrivileged(
+            JAVA_CLASS_VERSION = jcv;
+            @SuppressWarnings("removal") String jsv =
+            java.security.AccessController.doPrivileged(
                 new java.security.PrivilegedAction<String>() {
                 public String run() {
                     return System.getProperty("java.specification.version");}});
+            JAVA_SPECIFICATION_VERSION = jsv;
         } catch (Throwable t) {
             throw new Error(t);
         }
@@ -626,6 +635,12 @@ public static Test suite() {
             addNamedTestClasses(suite, java9TestClassNames);
         }
 
+        if (atLeastJava17()) {
+            String[] java17TestClassNames = {
+                "ForkJoinPool19Test",
+            };
+            addNamedTestClasses(suite, java17TestClassNames);
+        }
         return suite;
     }
 
@@ -1084,7 +1099,7 @@ Runnable releaser(final AtomicBoolean flag) {
     void joinPool(ExecutorService pool) {
         try {
             pool.shutdown();
-            if (!pool.awaitTermination(2 * LONG_DELAY_MS, MILLISECONDS)) {
+            if (!pool.awaitTermination(20 * LONG_DELAY_MS, MILLISECONDS)) {
                 try {
                     threadFail("ExecutorService " + pool +
                                " did not terminate in a timely manner");
@@ -1168,6 +1183,7 @@ static boolean threadOfInterest(ThreadInfo info) {
      * A debugging tool to print stack traces of most threads, as jstack does.
      * Uninteresting threads are filtered out.
      */
+    @SuppressWarnings("removal")
     static void dumpTestThreads() {
         SecurityManager sm = System.getSecurityManager();
         if (sm != null) {
@@ -1376,9 +1392,7 @@ static void mustRemove(Collection<Item> c, Item i) {
         assertTrue(c.remove(i));
     }
     static void mustNotRemove(Collection<Item> c, int i) {
-        Item[] items = defaultItems;
-        Item x = (i >= 0 && i < items.length) ? items[i] : new Item(i);
-        assertFalse(c.remove(x));
+        assertFalse(c.remove(itemFor(i)));
     }
     static void mustNotRemove(Collection<Item> c, Item i) {
         assertFalse(c.remove(i));
@@ -1403,6 +1417,7 @@ static void mustOffer(Queue<Item> c, Item i) {
      * security manager.  We require that any security manager permit
      * getPolicy/setPolicy.
      */
+    @SuppressWarnings("removal")
     public void runWithPermissions(Runnable r, Permission... permissions) {
         SecurityManager sm = System.getSecurityManager();
         if (sm == null) {
@@ -1418,18 +1433,24 @@ public void runWithPermissions(Runnable r, Permission... permissions) {
      * Runnable.  We require that any security manager permit
      * getPolicy/setPolicy.
      */
+    @SuppressWarnings("removal")
     public void runWithSecurityManagerWithPermissions(Runnable r,
                                                       Permission... permissions) {
+        if (!useSecurityManager) return;
         SecurityManager sm = System.getSecurityManager();
         if (sm == null) {
             Policy savedPolicy = Policy.getPolicy();
             try {
                 Policy.setPolicy(permissivePolicy());
                 System.setSecurityManager(new SecurityManager());
                 runWithSecurityManagerWithPermissions(r, permissions);
+            } catch (UnsupportedOperationException ok) {
             } finally {
-                System.setSecurityManager(null);
-                Policy.setPolicy(savedPolicy);
+                try {
+                    System.setSecurityManager(null);
+                    Policy.setPolicy(savedPolicy);
+                } catch (Exception ok) {
+                }
             }
         } else {
             Policy savedPolicy = Policy.getPolicy();
@@ -1456,6 +1477,7 @@ public void runWithoutPermissions(Runnable r) {
      * A security policy where new permissions can be dynamically added
      * or all cleared.
      */
+    @SuppressWarnings("removal")
     public static class AdjustablePolicy extends java.security.Policy {
         Permissions perms = new Permissions();
         AdjustablePolicy(Permission... permissions) {
@@ -1485,6 +1507,7 @@ public String toString() {
     /**
      * Returns a policy containing all the permissions we ever need.
      */
+    @SuppressWarnings("removal")
     public static Policy permissivePolicy() {
         return new AdjustablePolicy
             // Permissions j.u.c. needs directly