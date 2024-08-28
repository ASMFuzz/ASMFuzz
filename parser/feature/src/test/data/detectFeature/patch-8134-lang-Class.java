@@ -3002,9 +3002,9 @@ private boolean isOpenToCaller(String name, Class<?> caller) {
         if (callerModule != thisModule) {
             String pn = Resources.toPackageName(name);
             if (thisModule.getDescriptor().packages().contains(pn)) {
-                if (callerModule == null && !thisModule.isOpen(pn)) {
-                    // no caller, package not open
-                    return false;
+                if (callerModule == null) {
+                    // no caller, return true if the package is open to all modules
+                    return thisModule.isOpen(pn);
                 }
                 if (!thisModule.isOpen(pn, callerModule)) {
                     // package not open to caller