@@ -93,8 +93,7 @@ inline void ContinuationHelper::InterpretedFrame::patch_sender_sp(frame& f, intp
 }
 
 inline address* ContinuationHelper::Frame::return_pc_address(const frame& f) {
-  Unimplemented();
-  return NULL;
+  return (address*)(f.real_fp() - 1);
 }
 
 inline address ContinuationHelper::Frame::real_pc(const frame& f) {