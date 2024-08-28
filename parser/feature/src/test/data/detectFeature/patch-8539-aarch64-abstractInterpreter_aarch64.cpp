@@ -123,9 +123,9 @@ void AbstractInterpreter::layout_activation(Method* method,
   // It is also guaranteed to be walkable even though it is in a
   // skeletal state
 
-  int max_locals = method->max_locals() * Interpreter::stackElementWords;
-  int extra_locals = (method->max_locals() - method->size_of_parameters()) *
-    Interpreter::stackElementWords;
+  const int max_locals = method->max_locals() * Interpreter::stackElementWords;
+  const int params = method->size_of_parameters() * Interpreter::stackElementWords;
+  const int extra_locals = max_locals - params;
 
 #ifdef ASSERT
   assert(caller->sp() == interpreter_frame->sender_sp(), "Frame not properly walkable");
@@ -144,12 +144,9 @@ void AbstractInterpreter::layout_activation(Method* method,
   // align the incoming parameters with the caller's temporary
   // expression stack. For other types of caller frame it doesn't
   // matter.
-  intptr_t* locals;
-  if (caller->is_interpreted_frame()) {
-    locals = caller->interpreter_frame_last_sp() + caller_actual_parameters - 1;
-  } else {
-    locals = interpreter_frame->sender_sp() + max_locals - 1;
-  }
+  intptr_t* const locals = caller->is_interpreted_frame()
+    ? caller->interpreter_frame_last_sp() + caller_actual_parameters - 1
+    : interpreter_frame->sender_sp() + max_locals - 1;
 
 #ifdef ASSERT
   if (caller->is_interpreted_frame()) {
@@ -171,14 +168,10 @@ void AbstractInterpreter::layout_activation(Method* method,
   // All frames but the initial (oldest) interpreter frame we fill in have
   // a value for sender_sp that allows walking the stack but isn't
   // truly correct. Correct the value here.
-  if (extra_locals != 0 &&
-      interpreter_frame->sender_sp() ==
-      interpreter_frame->interpreter_frame_sender_sp()) {
-    interpreter_frame->set_interpreter_frame_sender_sp(caller->sp() +
-                                                       extra_locals);
+  if (extra_locals != 0 && interpreter_frame->sender_sp() == interpreter_frame->interpreter_frame_sender_sp()) {
+    interpreter_frame->set_interpreter_frame_sender_sp(caller->sp() + extra_locals);
   }
-  *interpreter_frame->interpreter_frame_cache_addr() =
-    method->constants()->cache();
-  *interpreter_frame->interpreter_frame_mirror_addr() =
-    method->method_holder()->java_mirror();
+
+  *interpreter_frame->interpreter_frame_cache_addr()  = method->constants()->cache();
+  *interpreter_frame->interpreter_frame_mirror_addr() = method->method_holder()->java_mirror();
 }