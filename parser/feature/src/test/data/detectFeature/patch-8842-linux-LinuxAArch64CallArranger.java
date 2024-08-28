@@ -38,4 +38,9 @@ protected boolean varArgsOnStack() {
         return false;
     }
 
+    @Override
+    protected boolean requiresSubSlotStackPacking() {
+        return false;
+    }
+
 }