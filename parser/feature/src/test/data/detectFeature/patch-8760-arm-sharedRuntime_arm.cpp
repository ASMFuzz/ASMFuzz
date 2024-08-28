@@ -739,6 +739,22 @@ static void gen_special_dispatch(MacroAssembler* masm,
                                                  receiver_reg, member_reg, /*for_compiler_entry:*/ true);
 }
 
+CodeBlob* SharedRuntime::generate_method_handle_intrinsic_wrapper(MacroAssembler* masm,
+                                                                  const methodHandle& method,
+                                                                  int compile_id,
+                                                                  BasicType* in_sig_bt,
+                                                                  VMRegPair* in_regs,
+                                                                  BasicType ret_type) {
+  assert(method->is_method_handle_intrinsic(), "must be MethodHandle intrinsic");
+
+  gen_special_dispatch(masm,
+                       method,
+                       in_sig_bt,
+                       in_regs);
+  __ flush();
+  return MethodHandleIntrinsicBlob::create(method, masm->code());
+}
+
 // ---------------------------------------------------------------------------
 // Generate a native wrapper for a given method.  The method takes arguments
 // in the Java compiled code convention, marshals them to the native
@@ -751,27 +767,7 @@ nmethod* SharedRuntime::generate_native_wrapper(MacroAssembler* masm,
                                                 BasicType* in_sig_bt,
                                                 VMRegPair* in_regs,
                                                 BasicType ret_type) {
-  if (method->is_method_handle_intrinsic()) {
-    vmIntrinsics::ID iid = method->intrinsic_id();
-    intptr_t start = (intptr_t)__ pc();
-    int vep_offset = ((intptr_t)__ pc()) - start;
-    gen_special_dispatch(masm,
-                         method,
-                         in_sig_bt,
-                         in_regs);
-    int frame_complete = ((intptr_t)__ pc()) - start;  // not complete, period
-    __ flush();
-    int stack_slots = SharedRuntime::out_preserve_stack_slots();  // no out slots at all, actually
-    return nmethod::new_native_nmethod(method,
-                                       compile_id,
-                                       masm->code(),
-                                       vep_offset,
-                                       frame_complete,
-                                       stack_slots / VMRegImpl::slots_per_word,
-                                       in_ByteSize(-1),
-                                       in_ByteSize(-1),
-                                       (OopMapSet*)NULL);
-  }
+  assert(!method->is_method_handle_intrinsic(), "must not be MethodHandle intrinsic");
   // Arguments for JNI method include JNIEnv and Class if static
 
   // Usage of Rtemp should be OK since scratched by native call