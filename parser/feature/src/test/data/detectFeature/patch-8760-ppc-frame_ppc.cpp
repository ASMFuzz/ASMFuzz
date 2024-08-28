@@ -87,7 +87,7 @@ bool frame::safe_for_sender(JavaThread *thread) {
     // so we just assume they are OK.
     // Adapter blobs never have a complete frame and are never OK
     if (!_cb->is_frame_complete_at(_pc)) {
-      if (_cb->is_compiled() || _cb->is_adapter_blob() || _cb->is_runtime_stub()) {
+      if (_cb->is_compiled() || _cb->is_adapter_blob() || _cb->is_runtime_stub() || _cb->is_mh_intrinsic()) {
         return false;
       }
     }