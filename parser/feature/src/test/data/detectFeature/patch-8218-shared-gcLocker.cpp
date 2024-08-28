@@ -38,15 +38,9 @@ volatile jint GCLocker::_jni_lock_count = 0;
 volatile bool GCLocker::_needs_gc       = false;
 unsigned int GCLocker::_total_collections = 0;
 
-#ifdef ASSERT
-volatile jint GCLocker::_debug_jni_lock_count = 0;
-#endif
-
-
 #ifdef ASSERT
 void GCLocker::verify_critical_count() {
   if (SafepointSynchronize::is_at_safepoint()) {
-    assert(!needs_gc() || _debug_jni_lock_count == _jni_lock_count, "must agree");
     int count = 0;
     // Count the number of threads with critical operations in progress
     JavaThreadIteratorWithHandle jtiwh;
@@ -67,17 +61,6 @@ void GCLocker::verify_critical_count() {
     assert(_jni_lock_count == count, "must be equal");
   }
 }
-
-// In debug mode track the locking state at all times
-void GCLocker::increment_debug_jni_lock_count() {
-  assert(_debug_jni_lock_count >= 0, "bad value");
-  Atomic::inc(&_debug_jni_lock_count);
-}
-
-void GCLocker::decrement_debug_jni_lock_count() {
-  assert(_debug_jni_lock_count > 0, "bad value");
-  Atomic::dec(&_debug_jni_lock_count);
-}
 #endif
 
 void GCLocker::log_debug_jni(const char* msg) {
@@ -123,33 +106,30 @@ bool GCLocker::should_discard(GCCause::Cause cause, uint total_collections) {
          (_total_collections != total_collections);
 }
 
-void GCLocker::jni_lock(JavaThread* thread) {
+void GCLocker::stall_until_no_needs_gc(JavaThread* thread) {
   assert(!thread->in_critical(), "shouldn't currently be in a critical region");
   MonitorLocker ml(JNICritical_lock);
   // Block entering threads if there's a pending GC request.
   while (needs_gc()) {
     // There's at least one thread that has not left the critical region (CR)
     // completely. When that last thread (no new threads can enter CR due to the
-    // blocking) exits CR, it calls `jni_unlock`, which sets `_needs_gc`
+    // blocking) exits CR, it calls `unlock_critical`, which sets `_needs_gc`
     // to false and wakes up all blocked threads.
-    // We would like to assert #threads in CR to be > 0, `_jni_lock_count > 0`
-    // in the code, but it's too strong; it's possible that the last thread
-    // has called `jni_unlock`, but not yet finished the call, e.g. initiating
+    // We would like to assert #threads in CR to be > 0, i.e. `_jni_lock_count > 0`,
+    // but that would be too strong -- it's possible that the last thread
+    // has called `unlock_critical`, but not yet finished the call, e.g. initiating
     // a GCCause::_gc_locker GC.
     ml.wait();
   }
-  thread->enter_critical();
-  _jni_lock_count++;
-  increment_debug_jni_lock_count();
 }
 
-void GCLocker::jni_unlock(JavaThread* thread) {
-  assert(thread->in_last_critical(), "should be exiting critical region");
-  MutexLocker mu(JNICritical_lock);
-  _jni_lock_count--;
-  decrement_debug_jni_lock_count();
-  thread->exit_critical();
-  if (needs_gc() && !is_active_internal()) {
+void GCLocker::ack_needs_gc_if_last_thread(JavaThread* thread) {
+  assert(!thread->in_critical(), "shouldn't currently be in a critical region");
+  assert(needs_gc(), "precondition");
+  jint old_value = Atomic::fetch_and_add(&_jni_lock_count, -1);
+  assert(old_value > 0, "inv");
+  bool is_last_thread = (old_value == 1);
+  if (is_last_thread) {
     // We're the last thread out. Request a GC.
     // Capture the current total collections, to allow detection of
     // other collections that make this one unnecessary.  The value of
@@ -158,13 +138,12 @@ void GCLocker::jni_unlock(JavaThread* thread) {
     // getting the count, else there may be unnecessary GCLocker GCs.
     _total_collections = Universe::heap()->total_collections();
     GCLockerTracer::report_gc_locker();
+    log_debug_jni("Performing GC after exiting critical section.");
+    Universe::heap()->collect(GCCause::_gc_locker);
     {
-      // Must give up the lock while at a safepoint
-      MutexUnlocker munlock(JNICritical_lock);
-      log_debug_jni("Performing GC after exiting critical section.");
-      Universe::heap()->collect(GCCause::_gc_locker);
+      MutexLocker ml(JNICritical_lock);
+      _needs_gc = false;
+      JNICritical_lock->notify_all();
     }
-    _needs_gc = false;
-    JNICritical_lock->notify_all();
   }
 }