@@ -30,29 +30,18 @@
 #include "runtime/thread.inline.hpp"
 
 void GCLocker::lock_critical(JavaThread* thread) {
-  if (!thread->in_critical()) {
-    if (needs_gc()) {
-      // jni_lock call calls enter_critical under the lock so that the
-      // global lock count and per thread count are in agreement.
-      jni_lock(thread);
-      return;
-    }
-    increment_debug_jni_lock_count();
+  if (!thread->in_critical() && needs_gc()) {
+    stall_until_no_needs_gc(thread);
+    assert(!needs_gc(), "postcondition");
   }
   thread->enter_critical();
 }
 
 void GCLocker::unlock_critical(JavaThread* thread) {
-  if (thread->in_last_critical()) {
-    if (needs_gc()) {
-      // jni_unlock call calls exit_critical under the lock so that
-      // the global lock count and per thread count are in agreement.
-      jni_unlock(thread);
-      return;
-    }
-    decrement_debug_jni_lock_count();
-  }
   thread->exit_critical();
+  if (!thread->in_critical() && needs_gc()) {
+    ack_needs_gc_if_last_thread(thread);
+  }
 }
 
 #endif // SHARE_GC_SHARED_GCLOCKER_INLINE_HPP