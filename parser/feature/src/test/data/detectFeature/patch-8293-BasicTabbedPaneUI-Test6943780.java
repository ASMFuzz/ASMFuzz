@@ -41,7 +41,7 @@ public static void main(String[] args) throws Exception {
     @Override
     public void uncaughtException(Thread thread, Throwable throwable) {
         throwable.printStackTrace();
-        System.exit(1);
+        throw new RuntimeException(throwable);
     }
 
     @Override