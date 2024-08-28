@@ -118,6 +118,6 @@ public void run() {
 
     public void uncaughtException(Thread thread, Throwable throwable) {
         throwable.printStackTrace();
-        System.exit(1);
+        throw new RuntimeException(throwable);
     }
 }