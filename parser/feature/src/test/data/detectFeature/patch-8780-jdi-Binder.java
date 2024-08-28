@@ -739,8 +739,8 @@ private Map<String,? extends Argument> setupLaunchingConnector(LaunchingConnecto
             arg.setValue(argumentHandler.getLaunchExecName());
         }
 
-        // This flag is needed so VirtualThread.allThreads() includes known vthreads.
-        arg = (Connector.StringArgument) arguments.get("enumeratevthreads");
+        // This flag is needed so VirtualMachine.allThreads() includes known vthreads.
+        arg = (Connector.StringArgument) arguments.get("includevirtualthreads");
         arg.setValue("y");
 
         String vmArgs = "";