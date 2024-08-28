@@ -1290,6 +1290,23 @@ static void move32_64(MacroAssembler *masm,
   }
 }
 
+CodeBlob *SharedRuntime::generate_method_handle_intrinsic_wrapper(MacroAssembler *masm,
+                                                                  const methodHandle& method,
+                                                                  int compile_id,
+                                                                  BasicType *in_sig_bt,
+                                                                  VMRegPair *in_regs,
+                                                                  BasicType ret_type) {
+  assert(method->is_method_handle_intrinsic(), "must be MethodHandle intrinsic");
+
+  int total_in_args = method->size_of_parameters();
+
+  gen_special_dispatch(masm, total_in_args,
+                       method->intrinsic_id(), in_sig_bt, in_regs);
+  __ flush();
+
+  return MethodHandleIntrinsicBlob::create(method, masm->code());
+}
+
 //----------------------------------------------------------------------
 // Wrap a JNI call.
 //----------------------------------------------------------------------
@@ -1300,32 +1317,8 @@ nmethod *SharedRuntime::generate_native_wrapper(MacroAssembler *masm,
                                                 BasicType *in_sig_bt,
                                                 VMRegPair *in_regs,
                                                 BasicType ret_type) {
+  assert(!method->is_method_handle_intrinsic(), "must not be MethodHandle intrinsic");
   int total_in_args = method->size_of_parameters();
-  if (method->is_method_handle_intrinsic()) {
-    vmIntrinsics::ID iid = method->intrinsic_id();
-    intptr_t start = (intptr_t) __ pc();
-    int vep_offset = ((intptr_t) __ pc()) - start;
-
-    gen_special_dispatch(masm, total_in_args,
-                         method->intrinsic_id(), in_sig_bt, in_regs);
-
-    int frame_complete = ((intptr_t)__ pc()) - start; // Not complete, period.
-
-    __ flush();
-
-    int stack_slots = SharedRuntime::out_preserve_stack_slots();  // No out slots at all, actually.
-
-    return nmethod::new_native_nmethod(method,
-                                       compile_id,
-                                       masm->code(),
-                                       vep_offset,
-                                       frame_complete,
-                                       stack_slots / VMRegImpl::slots_per_word,
-                                       in_ByteSize(-1),
-                                       in_ByteSize(-1),
-                                       (OopMapSet *) NULL);
-  }
-
 
   ///////////////////////////////////////////////////////////////////////
   //