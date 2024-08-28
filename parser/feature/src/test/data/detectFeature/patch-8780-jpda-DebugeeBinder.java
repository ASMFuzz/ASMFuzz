@@ -347,7 +347,7 @@ public String[] makeCommandLineArgs(String classToExecute, String transportAddre
                         + "server=" + server
                         + ",transport=" + argumentHandler.getTransportName()
                         + ",address=" + transportAddress
-                        + ",enumeratevthreads=y";
+                        + ",includevirtualthreads=y";
 
         if (! argumentHandler.isDefaultJVMDIStrictMode()) {
             if (argumentHandler.isJVMDIStrictMode())