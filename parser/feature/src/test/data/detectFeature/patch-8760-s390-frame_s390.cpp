@@ -90,7 +90,7 @@ bool frame::safe_for_sender(JavaThread *thread) {
     // Adapter blobs never have a complete frame and are never OK.
     // nmethods should be OK on s390.
     if (!_cb->is_frame_complete_at(_pc)) {
-      if (_cb->is_adapter_blob() || _cb->is_runtime_stub()) {
+      if (_cb->is_adapter_blob() || _cb->is_runtime_stub() || _cb->is_mh_intrinsic()) {
         return false;
       }
     }