@@ -266,7 +266,7 @@ void MethodHandles::jump_to_native_invoker(MacroAssembler* _masm, Register nep_r
   // Load the invoker, as NEP -> .invoker
   __ verify_oop(nep_reg);
   __ access_load_at(T_ADDRESS, IN_HEAP, temp_target,
-                    Address(nep_reg, NONZERO(jdk_internal_foreign_abi_NativeEntryPoint::invoker_offset_in_bytes())),
+                    Address(nep_reg, NONZERO(jdk_internal_foreign_abi_NativeEntryPoint::downcall_stub_address_offset_in_bytes())),
                     noreg, noreg);
 
   __ br(temp_target);