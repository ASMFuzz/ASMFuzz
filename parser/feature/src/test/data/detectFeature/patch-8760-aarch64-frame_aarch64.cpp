@@ -104,7 +104,7 @@ bool frame::safe_for_sender(JavaThread *thread) {
     // ok. adapter blobs never have a frame complete and are never ok.
 
     if (!_cb->is_frame_complete_at(_pc)) {
-      if (_cb->is_nmethod() || _cb->is_adapter_blob() || _cb->is_runtime_stub()) {
+      if (_cb->is_nmethod() || _cb->is_adapter_blob() || _cb->is_runtime_stub() || _cb->is_mh_intrinsic()) {
         return false;
       }
     }