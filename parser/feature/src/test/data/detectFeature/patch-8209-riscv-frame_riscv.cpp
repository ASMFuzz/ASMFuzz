@@ -338,13 +338,9 @@ frame frame::sender_for_entry_frame(RegisterMap* map) const {
   assert(jfa->last_Java_sp() > sp(), "must be above this frame on stack");
   // Since we are walking the stack now this nested anchor is obviously walkable
   // even if it wasn't when it was stacked.
-  if (!jfa->walkable()) {
-    // Capture _last_Java_pc (if needed) and mark anchor walkable.
-    jfa->capture_last_Java_pc();
-  }
+  jfa->make_walkable();
   map->clear();
   assert(map->include_argument_oops(), "should be set by clear");
-  vmassert(jfa->last_Java_pc() != NULL, "not walkable");
   frame fr(jfa->last_Java_sp(), jfa->last_Java_fp(), jfa->last_Java_pc());
   return fr;
 }
@@ -678,20 +674,13 @@ frame::frame(void* ptr_sp, void* ptr_fp, void* pc) {
 
 #endif
 
-void JavaFrameAnchor::make_walkable(JavaThread* thread) {
+void JavaFrameAnchor::make_walkable() {
   // last frame set?
   if (last_Java_sp() == NULL) { return; }
   // already walkable?
   if (walkable()) { return; }
-  vmassert(Thread::current() == (Thread*)thread, "not current thread");
   vmassert(last_Java_sp() != NULL, "not called from Java code?");
   vmassert(last_Java_pc() == NULL, "already walkable");
-  capture_last_Java_pc();
-  vmassert(walkable(), "something went wrong");
-}
-
-void JavaFrameAnchor::capture_last_Java_pc() {
-  vmassert(_last_Java_sp != NULL, "no last frame set");
-  vmassert(_last_Java_pc == NULL, "already walkable");
   _last_Java_pc = (address)_last_Java_sp[-1];
+  vmassert(walkable(), "something went wrong");
 }