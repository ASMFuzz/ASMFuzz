@@ -181,7 +181,7 @@ public void testThreadAccess() throws Exception {
                 thread.join();
 
                 RuntimeException e = exception.get();
-                if (!(e instanceof IllegalStateException)) {
+                if (!(e instanceof WrongThreadException)) {
                     throw e;
                 }
             }
@@ -199,7 +199,7 @@ public void testThreadAccess() throws Exception {
                 thread.join();
 
                 RuntimeException e = exception.get();
-                if (!(e instanceof IllegalStateException)) {
+                if (!(e instanceof WrongThreadException)) {
                     throw e;
                 }
             }