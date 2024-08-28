@@ -65,7 +65,7 @@ public synchronized int size() {
             @Override
             public void uncaughtException(Thread thread, Throwable throwable) {
                 throwable.printStackTrace();
-                System.exit(1);
+                throw new RuntimeException(throwable);
             }
         });
         thread.start();