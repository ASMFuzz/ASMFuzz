@@ -124,7 +124,7 @@ void DivByZeroStub::emit_code(LIR_Assembler* ce) {
     ce->compilation()->implicit_exception_table()->append(_offset, __ offset());
   }
   __ bind(_entry);
-  __ far_call(Address(Runtime1::entry_for(Runtime1::throw_div0_exception_id), relocInfo::runtime_call_type));
+  __ far_call(RuntimeAddress(Runtime1::entry_for(Runtime1::throw_div0_exception_id)));
   ce->add_call_info_here(_info);
   ce->verify_oop_map(_info);
 #ifdef ASSERT