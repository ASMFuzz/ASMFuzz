@@ -2947,15 +2947,15 @@ void ClassVerifier::verify_invoke_instructions(
                   _klass, ref_class, method_name, method_sig, true)) {
               // It's protected access, check if stack object is
               // assignable to current class.
-              bool is_assignable = current_type().is_assignable_from(
-                stack_object_type, this, true, CHECK_VERIFY(this));
-              if (!is_assignable) {
-                if (ref_class_type.name() == vmSymbols::java_lang_Object()
-                    && stack_object_type.is_array()
-                    && method_name == vmSymbols::clone_name()) {
-                  // Special case: arrays pretend to implement public Object
-                  // clone().
-                } else {
+              if (ref_class_type.name() == vmSymbols::java_lang_Object()
+                  && stack_object_type.is_array()
+                  && method_name == vmSymbols::clone_name()) {
+                // Special case: arrays pretend to implement public Object
+                // clone().
+              } else {
+                bool is_assignable = current_type().is_assignable_from(
+                  stack_object_type, this, true, CHECK_VERIFY(this));
+                if (!is_assignable) {
                   verify_error(ErrorContext::bad_type(bci,
                       current_frame->stack_top_ctx(),
                       TypeOrigin::implicit(current_type())),