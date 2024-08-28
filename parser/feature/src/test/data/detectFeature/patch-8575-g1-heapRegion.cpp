@@ -525,8 +525,7 @@ class VerifyLiveClosure : public G1VerificationClosure {
       oop obj = CompressedOops::decode_not_null(heap_oop);
       bool failed = false;
       if (!_g1h->is_in(obj) || _g1h->is_obj_dead_cond(obj, _vo)) {
-        MutexLocker x(ParGCRareEvent_lock,
-          Mutex::_no_safepoint_check_flag);
+        MutexLocker x(ParGCRareEvent_lock, Mutex::_no_safepoint_check_flag);
 
         if (!_failures) {
           log.error("----------");
@@ -597,8 +596,7 @@ class VerifyRemSetClosure : public G1VerificationClosure {
                 cv_field == dirty :
                 cv_obj == dirty || cv_field == dirty));
         if (is_bad) {
-          MutexLocker x(ParGCRareEvent_lock,
-            Mutex::_no_safepoint_check_flag);
+          MutexLocker x(ParGCRareEvent_lock, Mutex::_no_safepoint_check_flag);
 
           if (!_failures) {
             log.error("----------");