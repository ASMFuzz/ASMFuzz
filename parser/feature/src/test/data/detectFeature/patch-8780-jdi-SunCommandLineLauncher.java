@@ -47,7 +47,7 @@ public class SunCommandLineLauncher extends AbstractLauncher {
     private static final String ARG_QUOTE = "quote";
     private static final String ARG_VM_EXEC = "vmexec";
 
-    static private final String ARG_VM_ENUMERATE_VTHREADS = "enumeratevthreads";
+    static private final String ARG_VM_INCLUDE_VTHREADS = "includevirtualthreads";
 
     TransportService transportService;
     Transport transport;
@@ -133,9 +133,9 @@ public String name() {
                 "java",
                 true);
         addStringArgument(
-                ARG_VM_ENUMERATE_VTHREADS,
-                getString("sun.vm_enumerate_vthreads.label"),
-                getString("sun.vm_enumerate_vthreads"),
+                ARG_VM_INCLUDE_VTHREADS,
+                getString("sun.include_virtualthreads.label"),
+                getString("sun.include_virtualthreads"),
                 "n",
                 false);
     }
@@ -164,7 +164,7 @@ static boolean hasWhitespace(String string) {
                                                   arguments)).booleanValue();
         String quote = argument(ARG_QUOTE, arguments).value();
         String exe = argument(ARG_VM_EXEC, arguments).value();
-        String enumerateVThreads = argument(ARG_VM_ENUMERATE_VTHREADS, arguments).value();
+        String includeVThreads = argument(ARG_VM_INCLUDE_VTHREADS, arguments).value();
         String exePath = null;
 
         if (quote.length() > 1) {
@@ -223,7 +223,7 @@ static boolean hasWhitespace(String string) {
             String xrun = "transport=" + transport().name() +
                           ",address=" + address +
                           ",suspend=" + (wait? 'y' : 'n') +
-                          ",enumeratevthreads=" + enumerateVThreads;
+                          ",includevirtualthreads=" + includeVThreads;
             // Quote only if necessary in case the quote arg value is bogus
             if (hasWhitespace(xrun)) {
                 xrun = quote + xrun + quote;