@@ -3001,7 +3001,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
   // get the returned method
   __ get_vm_result_2(Z_method);
 
-  // We are back the the original state on entry and ready to go.
+  // We are back to the original state on entry and ready to go.
   __ z_br(Z_R1_scratch);
 
   // Pending exception after the safepoint