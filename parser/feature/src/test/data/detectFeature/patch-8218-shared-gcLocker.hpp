@@ -46,19 +46,13 @@ class GCLocker: public AllStatic {
   static volatile bool _needs_gc;        // heap is filling, we need a GC
   static uint _total_collections;        // value for _gc_locker collection
 
-#ifdef ASSERT
-  // This lock count is updated for all operations and is used to
-  // validate the jni_lock_count that is computed during safepoints.
-  static volatile jint _debug_jni_lock_count;
-#endif
-
   // At a safepoint, visit all threads and count the number of active
   // critical sections.  This is used to ensure that all active
   // critical sections are exited before a new one is started.
   static void verify_critical_count() NOT_DEBUG_RETURN;
 
-  static void jni_lock(JavaThread* thread);
-  static void jni_unlock(JavaThread* thread);
+  static void stall_until_no_needs_gc(JavaThread* thread);
+  static void ack_needs_gc_if_last_thread(JavaThread* thread);
 
   static bool is_active_internal() {
     verify_critical_count();
@@ -85,10 +79,6 @@ class GCLocker: public AllStatic {
     return needs_gc() && is_active_internal();
   }
 
-  // In debug mode track the locking state at all times
-  static void increment_debug_jni_lock_count() NOT_DEBUG_RETURN;
-  static void decrement_debug_jni_lock_count() NOT_DEBUG_RETURN;
-
   // Set the current lock count
   static void set_jni_lock_count(int count) {
     _jni_lock_count = count;