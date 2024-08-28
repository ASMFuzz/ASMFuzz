@@ -70,6 +70,8 @@ public static void main(String[] args) throws IOException, InterruptedException
                 lock.wait();
             }
         }
+
+        System.exit(Integer.getInteger("jpackage.test.exitCode", 0));
     }
 
     private static List<String> printArgs(String[] args) {