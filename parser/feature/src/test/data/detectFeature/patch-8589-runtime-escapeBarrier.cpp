@@ -119,6 +119,11 @@ bool EscapeBarrier::deoptimize_objects_all_threads() {
   if (!barrier_active()) return true;
   ResourceMark rm(calling_thread());
   for (JavaThreadIteratorWithHandle jtiwh; JavaThread *jt = jtiwh.next(); ) {
+    oop vt_oop = jt->jvmti_vthread();
+    // Skip virtual threads
+    if (vt_oop != NULL && java_lang_VirtualThread::is_instance(vt_oop)) {
+      continue;
+    }
     if (jt->frames_to_pop_failed_realloc() > 0) {
       // The deoptee thread jt has frames with reallocation failures on top of its stack.
       // These frames are about to be removed. We must not interfere with that and signal failure.