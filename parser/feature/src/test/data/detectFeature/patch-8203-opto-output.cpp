@@ -1862,6 +1862,19 @@ void PhaseOutput::fill_buffer(CodeBuffer* cb, uint* blk_starts) {
   if (C->print_assembly()) {
     ttyLocker ttyl;  // keep the following output all in one block
     if (!VMThread::should_terminate()) {  // test this under the tty lock
+      // print_metadata and dump_asm may safepoint which makes us loose the ttylock.
+      // We call them first and write to a stringStream, then we retake the lock to
+      // make sure the end tag is coherent, and that xmlStream->pop_tag is done thread safe.
+      ResourceMark rm;
+      stringStream method_metadata_str;
+      if (C->method() != NULL) {
+        C->method()->print_metadata(&method_metadata_str);
+      }
+      stringStream dump_asm_str;
+      dump_asm_on(&dump_asm_str, node_offsets, node_offset_limit);
+
+      NoSafepointVerifier nsv;
+      ttyLocker ttyl2;
       // This output goes directly to the tty, not the compiler log.
       // To enable tools to match it up with the compilation activity,
       // be sure to tag this tty output with the compile ID.
@@ -1871,19 +1884,15 @@ void PhaseOutput::fill_buffer(CodeBuffer* cb, uint* blk_starts) {
       }
       if (C->method() != NULL) {
         tty->print_cr("----------------------- MetaData before Compile_id = %d ------------------------", C->compile_id());
-        C->method()->print_metadata();
+        tty->print_raw(method_metadata_str.as_string());
       } else if (C->stub_name() != NULL) {
         tty->print_cr("----------------------------- RuntimeStub %s -------------------------------", C->stub_name());
       }
       tty->cr();
       tty->print_cr("------------------------ OptoAssembly for Compile_id = %d -----------------------", C->compile_id());
-      dump_asm(node_offsets, node_offset_limit);
+      tty->print_raw(dump_asm_str.as_string());
       tty->print_cr("--------------------------------------------------------------------------------");
       if (xtty != NULL) {
-        // print_metadata and dump_asm above may safepoint which makes us loose the ttylock.
-        // Retake lock too make sure the end tag is coherent, and that xmlStream->pop_tag is done
-        // thread safe
-        ttyLocker ttyl2;
         xtty->tail("opto_assembly");
       }
     }