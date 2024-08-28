@@ -29,10 +29,10 @@
 #include "runtime/frame.inline.hpp"
 #include "runtime/thread.inline.hpp"
 
-frame JavaThread::pd_last_frame() {
+frame JavaThread::pd_last_frame(bool forSignalHandler) {
   assert(has_last_Java_frame(), "must have last_Java_sp() when suspended");
   vmassert(_anchor.last_Java_pc() != NULL, "not walkable");
-  frame f = frame(_anchor.last_Java_sp(), _anchor.last_Java_fp(), _anchor.last_Java_pc());
+  frame f = frame(_anchor.last_Java_sp(), _anchor.last_Java_fp(), _anchor.last_Java_pc(), forSignalHandler);
   f.set_sp_is_trusted();
   return f;
 }
@@ -42,21 +42,21 @@ frame JavaThread::pd_last_frame() {
 bool JavaThread::pd_get_top_frame_for_signal_handler(frame* fr_addr,
   void* ucontext, bool isInJava) {
   assert(Thread::current() == this, "caller must be current thread");
-  return pd_get_top_frame(fr_addr, ucontext, isInJava);
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, false);
 }
 
 bool JavaThread::pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava) {
-  return pd_get_top_frame(fr_addr, ucontext, isInJava);
+  return pd_get_top_frame(fr_addr, ucontext, isInJava, false);
 }
 
-bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava) {
+bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler) {
   assert(this->is_Java_thread(), "must be JavaThread");
   JavaThread* jt = (JavaThread *)this;
 
   // If we have a last_Java_frame, then we should use it even if
   // isInJava == true.  It should be more reliable than ucontext info.
   if (jt->has_last_Java_frame() && jt->frame_anchor()->walkable()) {
-    *fr_addr = jt->pd_last_frame();
+    *fr_addr = jt->pd_last_frame(forSignalHandler);
     return true;
   }
 
@@ -74,11 +74,11 @@ bool JavaThread::pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava)
       return false;
     }
 
-    frame ret_frame(ret_sp, ret_fp, addr);
+    frame ret_frame(ret_sp, ret_fp, addr, forSignalHandler);
     if (!ret_frame.safe_for_sender(jt)) {
 #if COMPILER2_OR_JVMCI
       // C2 and JVMCI use ebp as a general register see if NULL fp helps
-      frame ret_frame2(ret_sp, NULL, addr);
+      frame ret_frame2(ret_sp, NULL, addr, forSignalHandler);
       if (!ret_frame2.safe_for_sender(jt)) {
         // nothing else to try if the frame isn't good
         return false;