@@ -973,7 +973,7 @@ public static void main(String argv[]) throws MissingResourceException {
                         return;
                     }
                 }
-            } else if (token.equals("-trackvthreads")) {
+            } else if (token.equals("-trackallthreads")) {
                 trackVthreads = true;
             } else if (token.equals("-X")) {
                 usageError("Use java minus X to see");
@@ -1169,7 +1169,7 @@ public static void main(String argv[]) throws MissingResourceException {
         }
 
         if (connectSpec.startsWith("com.sun.jdi.CommandLineLaunch:") && trackVthreads) {
-            connectSpec += "enumeratevthreads=y,";
+            connectSpec += "includevirtualthreads=y,";
         }
 
         try {