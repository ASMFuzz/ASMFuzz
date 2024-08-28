@@ -28,7 +28,7 @@
 #include "runtime/frame.inline.hpp"
 #include "runtime/thread.hpp"
 
-frame JavaThread::pd_last_frame() {
+frame JavaThread::pd_last_frame(bool forSignalHandler) {
   assert(has_last_Java_frame(), "must have last_Java_sp() when suspended");
 
   intptr_t* sp = last_Java_sp();
@@ -41,15 +41,15 @@ frame JavaThread::pd_last_frame() {
     pc = (address) *(sp + 2);
   }
 
-  return frame(sp, pc);
+  return frame(sp, pc, forSignalHandler);
 }
 
-bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava) {
+bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler) {
 
   // If we have a last_Java_frame, then we should use it even if
   // isInJava == true.  It should be more reliable than ucontext info.
   if (has_last_Java_frame() && frame_anchor()->walkable()) {
-    *fr_addr = pd_last_frame();
+    *fr_addr = pd_last_frame(forSignalHandler);
     return true;
   }
 
@@ -65,7 +65,7 @@ bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext,
       return false;
     }
 
-    frame ret_frame((intptr_t*)uc->uc_mcontext.regs->gpr[1/*REG_SP*/], pc);
+    frame ret_frame((intptr_t*)uc->uc_mcontext.regs->gpr[1/*REG_SP*/], pc, forSignalHandler);
 
     if (ret_frame.fp() == NULL) {
       // The found frame does not have a valid frame pointer.
@@ -109,7 +109,11 @@ bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext,
 
 // Forte Analyzer AsyncGetCallTrace profiling support.
 bool JavaThread::pd_get_top_frame_for_signal_handler(frame* fr_addr, void* ucontext, bool isInJava) {
-  return pd_get_top_frame_for_profiling(fr_addr, ucontext, isInJava);
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, false);
+}
+
+bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava) {
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, true);
 }
 
 void JavaThread::cache_global_variables() { }