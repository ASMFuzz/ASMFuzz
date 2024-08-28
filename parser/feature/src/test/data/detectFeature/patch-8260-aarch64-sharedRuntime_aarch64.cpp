@@ -762,7 +762,7 @@ AdapterHandlerEntry* SharedRuntime::generate_i2c2i_adapters(MacroAssembler *masm
   // require some stack space.  We grow the current (compiled) stack, then repack
   // the args.  We  finally end in a jump to the generic interpreter entry point.
   // On exit from the interpreter, the interpreter will restore our SP (lest the
-  // compiled code, which relys solely on SP and not FP, get sick).
+  // compiled code, which relies solely on SP and not FP, get sick).
 
   {
     __ block_comment("c2i_unverified_entry {");
@@ -2628,7 +2628,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
   bool cause_return = (poll_type == POLL_AT_RETURN);
   RegisterSaver reg_save(poll_type == POLL_AT_VECTOR_LOOP /* save_vectors */);
 
-  // When the signal occured, the LR was either signed and stored on the stack (in which
+  // When the signal occurred, the LR was either signed and stored on the stack (in which
   // case it will be restored from the stack before being used) or unsigned and not stored
   // on the stack. Stipping ensures we get the right value.
   __ strip_return_address();
@@ -2638,7 +2638,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
 
   // The following is basically a call_VM.  However, we need the precise
   // address of the call in order to generate an oopmap. Hence, we do all the
-  // work outselves.
+  // work ourselves.
 
   Label retaddr;
   __ set_last_Java_frame(sp, noreg, retaddr, rscratch1);