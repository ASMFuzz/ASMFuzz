@@ -118,7 +118,7 @@ bool frame::safe_for_sender(JavaThread *thread) {
     if (is_entry_frame()) {
       // an entry frame must have a valid fp.
       return fp_safe && is_entry_frame_valid(thread);
-    } else if (is_optimized_entry_frame()) {
+    } else if (is_upcall_stub_frame()) {
       return fp_safe;
     }
 
@@ -222,7 +222,7 @@ bool frame::safe_for_sender(JavaThread *thread) {
       address jcw = (address)sender.entry_frame_call_wrapper();
 
       return thread->is_in_stack_range_excl(jcw, (address)sender.fp());
-    } else if (sender_blob->is_optimized_entry_blob()) {
+    } else if (sender_blob->is_upcall_stub()) {
       return false;
     }
 
@@ -372,27 +372,27 @@ frame frame::sender_for_entry_frame(RegisterMap* map) const {
   return fr;
 }
 
-OptimizedEntryBlob::FrameData* OptimizedEntryBlob::frame_data_for_frame(const frame& frame) const {
-  assert(frame.is_optimized_entry_frame(), "wrong frame");
+UpcallStub::FrameData* UpcallStub::frame_data_for_frame(const frame& frame) const {
+  assert(frame.is_upcall_stub_frame(), "wrong frame");
   // need unextended_sp here, since normal sp is wrong for interpreter callees
-  return reinterpret_cast<OptimizedEntryBlob::FrameData*>(
+  return reinterpret_cast<UpcallStub::FrameData*>(
     reinterpret_cast<address>(frame.unextended_sp()) + in_bytes(_frame_data_offset));
 }
 
-bool frame::optimized_entry_frame_is_first() const {
-  assert(is_optimized_entry_frame(), "must be optimzed entry frame");
-  OptimizedEntryBlob* blob = _cb->as_optimized_entry_blob();
+bool frame::upcall_stub_frame_is_first() const {
+  assert(is_upcall_stub_frame(), "must be optimzed entry frame");
+  UpcallStub* blob = _cb->as_upcall_stub();
   JavaFrameAnchor* jfa = blob->jfa_for_frame(*this);
   return jfa->last_Java_sp() == NULL;
 }
 
-frame frame::sender_for_optimized_entry_frame(RegisterMap* map) const {
+frame frame::sender_for_upcall_stub_frame(RegisterMap* map) const {
   assert(map != NULL, "map must be set");
-  OptimizedEntryBlob* blob = _cb->as_optimized_entry_blob();
+  UpcallStub* blob = _cb->as_upcall_stub();
   // Java frame called from C; skip all C frames and return top C
   // frame of that chunk as the sender
   JavaFrameAnchor* jfa = blob->jfa_for_frame(*this);
-  assert(!optimized_entry_frame_is_first(), "must have a frame anchor to go back to");
+  assert(!upcall_stub_frame_is_first(), "must have a frame anchor to go back to");
   assert(jfa->last_Java_sp() > sp(), "must be above this frame on stack");
   // Since we are walking the stack now this nested anchor is obviously walkable
   // even if it wasn't when it was stacked.