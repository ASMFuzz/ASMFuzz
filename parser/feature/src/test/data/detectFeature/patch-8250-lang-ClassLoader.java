@@ -494,7 +494,7 @@ public String getName() {
     }
 
     // package-private used by StackTraceElement to avoid
-    // calling the overrideable getName method
+    // calling the overridable getName method
     final String name() {
         return name;
     }