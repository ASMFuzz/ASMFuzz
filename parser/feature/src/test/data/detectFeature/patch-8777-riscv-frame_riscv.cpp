@@ -343,17 +343,17 @@ frame frame::sender_for_entry_frame(RegisterMap* map) const {
   return fr;
 }
 
-OptimizedEntryBlob::FrameData* OptimizedEntryBlob::frame_data_for_frame(const frame& frame) const {
+UpcallStub::FrameData* UpcallStub::frame_data_for_frame(const frame& frame) const {
   ShouldNotCallThis();
   return nullptr;
 }
 
-bool frame::optimized_entry_frame_is_first() const {
+bool frame::upcall_stub_frame_is_first() const {
   ShouldNotCallThis();
   return false;
 }
 
-frame frame::sender_for_optimized_entry_frame(RegisterMap* map) const {
+frame frame::sender_for_upcall_stub_frame(RegisterMap* map) const {
   ShouldNotCallThis();
   return {};
 }