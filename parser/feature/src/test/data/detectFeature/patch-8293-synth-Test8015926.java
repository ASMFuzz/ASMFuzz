@@ -94,6 +94,6 @@ public void run() {
     @Override
     public void uncaughtException(Thread thread, Throwable exception) {
         exception.printStackTrace();
-        System.exit(1);
+        throw new RuntimeException(exception);
     }
 }