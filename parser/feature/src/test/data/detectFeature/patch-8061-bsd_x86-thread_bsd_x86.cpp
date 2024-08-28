@@ -26,29 +26,29 @@
 #include "runtime/frame.inline.hpp"
 #include "runtime/thread.inline.hpp"
 
-frame JavaThread::pd_last_frame() {
+frame JavaThread::pd_last_frame(bool forSignalHandler) {
   assert(has_last_Java_frame(), "must have last_Java_sp() when suspended");
   vmassert(_anchor.last_Java_pc() != NULL, "not walkable");
-  return frame(_anchor.last_Java_sp(), _anchor.last_Java_fp(), _anchor.last_Java_pc());
+  return frame(_anchor.last_Java_sp(), _anchor.last_Java_fp(), _anchor.last_Java_pc(), forSignalHandler);
 }
 
 // For Forte Analyzer AsyncGetCallTrace profiling support - thread is
 // currently interrupted by SIGPROF
 bool JavaThread::pd_get_top_frame_for_signal_handler(frame* fr_addr,
   void* ucontext, bool isInJava) {
   assert(Thread::current() == this, "caller must be current thread");
-  return pd_get_top_frame(fr_addr, ucontext, isInJava);
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, false);
 }
 
 bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava) {
-  return pd_get_top_frame(fr_addr, ucontext, isInJava);
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, true);
 }
 
-bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava) {
+bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler) {
   // If we have a last_Java_frame, then we should use it even if
   // isInJava == true.  It should be more reliable than ucontext info.
   if (has_last_Java_frame() && frame_anchor()->walkable()) {
-    *fr_addr = pd_last_frame();
+    *fr_addr = pd_last_frame(forSignalHandler);
     return true;
   }
 
@@ -66,11 +66,11 @@ bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava)
       return false;
     }
 
-    frame ret_frame(ret_sp, ret_fp, addr);
+    frame ret_frame(ret_sp, ret_fp, addr, forSignalHandler);
     if (!ret_frame.safe_for_sender(this)) {
 #if COMPILER2_OR_JVMCI
       // C2 and JVMCI use ebp as a general register see if NULL fp helps
-      frame ret_frame2(ret_sp, NULL, addr);
+      frame ret_frame2(ret_sp, NULL, addr, forSignalHandler);
       if (!ret_frame2.safe_for_sender(this)) {
         // nothing else to try if the frame isn't good
         return false;