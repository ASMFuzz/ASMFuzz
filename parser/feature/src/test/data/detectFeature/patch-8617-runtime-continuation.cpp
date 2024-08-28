@@ -104,6 +104,7 @@ bool Continuation::is_continuation_scope_mounted(JavaThread* thread, oop cont_sc
 // The continuation object can be extracted from the thread.
 bool Continuation::is_cont_barrier_frame(const frame& f) {
   assert(f.is_interpreted_frame() || f.cb() != nullptr, "");
+  if (!Continuations::enabled()) return false;
   return is_return_barrier_entry(f.is_interpreted_frame() ? ContinuationHelper::InterpretedFrame::return_pc(f)
                                                           : ContinuationHelper::CompiledFrame::return_pc(f));
 }