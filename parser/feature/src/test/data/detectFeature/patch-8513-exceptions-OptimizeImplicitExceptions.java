@@ -195,6 +195,11 @@ public static void main(String[] args) throws Exception {
             return;
         }
 
+        // The following options are both develop, or nops in product build.
+        // If they are set, disable them for test stability. It's fine because we use /othervm above.
+        WB.setBooleanVMFlag("DeoptimizeALot", false);
+        WB.setBooleanVMFlag("DeoptimizeRandom", false);
+
         // Initialize global deopt counts to zero.
         for (ImplicitException impExcp : ImplicitException.values()) {
             oldDeoptCountReason.put(impExcp.getReason(), 0);