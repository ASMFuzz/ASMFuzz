@@ -591,6 +591,9 @@ void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
     return;
   }
 
+  // !important! make sure all to call thread->set_in_asgct(false) before every return
+  thread->set_in_asgct(true);
+
   switch (thread->thread_state()) {
   case _thread_new:
   case _thread_uninitialized:
@@ -648,6 +651,7 @@ void AsyncGetCallTrace(ASGCT_CallTrace *trace, jint depth, void* ucontext) {
     trace->num_frames = ticks_unknown_state; // -7
     break;
   }
+  thread->set_in_asgct(false);
 }
 
 