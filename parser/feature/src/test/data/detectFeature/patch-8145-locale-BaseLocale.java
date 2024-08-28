@@ -97,7 +97,7 @@ public final class BaseLocale {
     private final String region;
     private final String variant;
 
-    private volatile int hash;
+    private int hash;
 
     /**
      * Boolean for the old ISO language code compatibility.