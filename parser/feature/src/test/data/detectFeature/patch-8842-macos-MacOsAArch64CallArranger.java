@@ -38,4 +38,9 @@ protected boolean varArgsOnStack() {
         return true;
     }
 
+    @Override
+    protected boolean requiresSubSlotStackPacking() {
+        return true;
+    }
+
 }