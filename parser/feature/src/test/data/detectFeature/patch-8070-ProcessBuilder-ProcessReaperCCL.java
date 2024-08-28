@@ -57,7 +57,7 @@ static void test() throws Exception {
 
         // Verify all "Process Reaper" threads have a null CCL
         for (Thread th : Thread.getAllStackTraces().keySet()) {
-            if ("process reaper".equals(th.getName())) {
+            if (th.getName().startsWith("process reaper")) {
                 Assert.assertEquals(th.getContextClassLoader(), null, "CCL not null");
             }
         }