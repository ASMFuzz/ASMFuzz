@@ -26,7 +26,7 @@
 #include "asm/macroAssembler.hpp"
 #include "logging/logStream.hpp"
 #include "memory/resourceArea.hpp"
-#include "prims/universalUpcallHandler.hpp"
+#include "prims/upcallLinker.hpp"
 #include "runtime/sharedRuntime.hpp"
 #include "runtime/signature.hpp"
 #include "runtime/signature.hpp"
@@ -115,16 +115,16 @@ static void restore_callee_saved_registers(MacroAssembler* _masm, const ABIDescr
   __ block_comment("} restore_callee_saved_regs ");
 }
 
-address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiver, Method* entry,
-                                                                  BasicType* in_sig_bt, int total_in_args,
-                                                                  BasicType* out_sig_bt, int total_out_args,
-                                                                  BasicType ret_type,
-                                                                  jobject jabi, jobject jconv,
-                                                                  bool needs_return_buffer, int ret_buf_size) {
+address UpcallLinker::make_upcall_stub(jobject receiver, Method* entry,
+                                       BasicType* in_sig_bt, int total_in_args,
+                                       BasicType* out_sig_bt, int total_out_args,
+                                       BasicType ret_type,
+                                       jobject jabi, jobject jconv,
+                                       bool needs_return_buffer, int ret_buf_size) {
   ResourceMark rm;
   const ABIDescriptor abi = ForeignGlobals::parse_abi_descriptor(jabi);
   const CallRegs call_regs = ForeignGlobals::parse_call_regs(jconv);
-  CodeBuffer buffer("upcall_stub_linkToNative", /* code_size = */ 2048, /* locs_size = */ 1024);
+  CodeBuffer buffer("upcall_stub", /* code_size = */ 2048, /* locs_size = */ 1024);
 
   Register shuffle_reg = r19;
   JavaCallingConvention out_conv;
@@ -157,7 +157,7 @@ address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiv
   int arg_save_area_offset   = res_save_area_offset   + result_spiller.spill_size_bytes();
   int reg_save_area_offset   = arg_save_area_offset   + arg_spilller.spill_size_bytes();
   int frame_data_offset      = reg_save_area_offset   + reg_save_area_size;
-  int frame_bottom_offset    = frame_data_offset      + sizeof(OptimizedEntryBlob::FrameData);
+  int frame_bottom_offset    = frame_data_offset      + sizeof(UpcallStub::FrameData);
 
   int ret_buf_offset = -1;
   if (needs_return_buffer) {
@@ -209,7 +209,7 @@ address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiv
 
   __ block_comment("{ on_entry");
   __ lea(c_rarg0, Address(sp, frame_data_offset));
-  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, ProgrammableUpcallHandler::on_entry));
+  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, UpcallLinker::on_entry));
   __ blr(rscratch1);
   __ mov(rthread, r0);
   __ reinit_heapbase();
@@ -286,7 +286,7 @@ address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiv
   __ block_comment("{ on_exit");
   __ lea(c_rarg0, Address(sp, frame_data_offset));
   // stack already aligned
-  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, ProgrammableUpcallHandler::on_exit));
+  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, UpcallLinker::on_exit));
   __ blr(rscratch1);
   __ block_comment("} on_exit");
 
@@ -306,7 +306,7 @@ address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiv
   // Native caller has no idea how to handle exceptions,
   // so we just crash here. Up to callee to catch exceptions.
   __ verify_oop(r0);
-  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, ProgrammableUpcallHandler::handle_uncaught_exception));
+  __ movptr(rscratch1, CAST_FROM_FN_PTR(uint64_t, UpcallLinker::handle_uncaught_exception));
   __ blr(rscratch1);
   __ should_not_reach_here();
 
@@ -316,18 +316,18 @@ address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiv
 
 #ifndef PRODUCT
   stringStream ss;
-  ss.print("optimized_upcall_stub_%s", entry->signature()->as_C_string());
+  ss.print("upcall_stub_%s", entry->signature()->as_C_string());
   const char* name = _masm->code_string(ss.as_string());
 #else // PRODUCT
-  const char* name = "optimized_upcall_stub";
+  const char* name = "upcall_stub";
 #endif // PRODUCT
 
-  OptimizedEntryBlob* blob
-    = OptimizedEntryBlob::create(name,
-                                 &buffer,
-                                 exception_handler_offset,
-                                 receiver,
-                                 in_ByteSize(frame_data_offset));
+  UpcallStub* blob
+    = UpcallStub::create(name,
+                         &buffer,
+                         exception_handler_offset,
+                         receiver,
+                         in_ByteSize(frame_data_offset));
 
   if (TraceOptimizedUpcallStubs) {
     blob->print_on(tty);