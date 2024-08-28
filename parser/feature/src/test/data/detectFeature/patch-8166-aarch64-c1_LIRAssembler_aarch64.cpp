@@ -438,6 +438,7 @@ int LIR_Assembler::emit_unwind_handler() {
       __ unlock_object(r5, r4, r0, *stub->entry());
     }
     __ bind(*stub->continuation());
+    __ dec_held_monitor_count(rthread);
   }
 
   if (compilation()->env()->dtrace_method_probes()) {
@@ -2037,6 +2038,7 @@ void LIR_Assembler::call(LIR_OpJavaCall* op, relocInfo::relocType rtype) {
     return;
   }
   add_call_info(code_offset(), op->info());
+  __ post_call_nop();
 }
 
 
@@ -2047,6 +2049,7 @@ void LIR_Assembler::ic_call(LIR_OpJavaCall* op) {
     return;
   }
   add_call_info(code_offset(), op->info());
+  __ post_call_nop();
 }
 
 void LIR_Assembler::emit_static_call_stub() {
@@ -2571,7 +2574,18 @@ void LIR_Assembler::emit_lock(LIR_OpLock* op) {
   } else {
     Unimplemented();
   }
+  if (op->code() == lir_lock) {
+    // If deoptimization happens in Runtime1::monitorenter, inc_held_monitor_count after backing from slowpath
+    // will be skipped. Solution is:
+    // 1. Increase only in fastpath
+    // 2. Runtime1::monitorenter increase count after locking
+    __ inc_held_monitor_count(rthread);
+  }
   __ bind(*op->stub()->continuation());
+  if (op->code() == lir_unlock) {
+    // unlock in slowpath is JRT_Leaf stub, no deoptimization can happen
+    __ dec_held_monitor_count(rthread);
+  }
 }
 
 void LIR_Assembler::emit_load_klass(LIR_OpLoadKlass* op) {
@@ -2899,6 +2913,7 @@ void LIR_Assembler::rt_call(LIR_Opr result, address dest, const LIR_OprList* arg
   if (info != NULL) {
     add_call_info_here(info);
   }
+  __ post_call_nop();
 }
 
 void LIR_Assembler::volatile_move_op(LIR_Opr src, LIR_Opr dest, BasicType type, CodeEmitInfo* info) {