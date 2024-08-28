@@ -646,14 +646,23 @@ bool CodeCache::contains(nmethod *nm) {
   return contains((void *)nm);
 }
 
+static bool is_in_asgct() {
+  Thread* current_thread = Thread::current_or_null_safe();
+  return current_thread != NULL && current_thread->is_Java_thread() && JavaThread::cast(current_thread)->in_asgct();
+}
+
 // This method is safe to call without holding the CodeCache_lock, as long as a dead CodeBlob is not
 // looked up (i.e., one that has been marked for deletion). It only depends on the _segmap to contain
 // valid indices, which it will always do, as long as the CodeBlob is not in the process of being recycled.
 CodeBlob* CodeCache::find_blob(void* start) {
   CodeBlob* result = find_blob_unsafe(start);
   // We could potentially look up non_entrant methods
-  guarantee(result == NULL || !result->is_zombie() || result->is_locked_by_vm() || VMError::is_error_reported(), "unsafe access to zombie method");
-  return result;
+  bool is_zombie = result != NULL && result->is_zombie();
+  bool is_result_safe = !is_zombie || result->is_locked_by_vm() || VMError::is_error_reported();
+  guarantee(is_result_safe || is_in_asgct(), "unsafe access to zombie method");
+  // When in ASGCT the previous gurantee will pass for a zombie method but we still don't want that code blob returned in order
+  // to minimize the chance of accessing dead memory
+  return is_result_safe ? result : NULL;
 }
 
 // Lookup that does not fail if you lookup a zombie method (if you call this, be sure to know