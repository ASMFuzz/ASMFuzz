@@ -4145,20 +4145,28 @@ bool GraphBuilder::try_method_handle_inline(ciMethod* callee, bool ignore_return
       const int args_base = state()->stack_size() - callee->arg_size();
       ValueType* type = state()->stack_at(args_base)->type();
       if (type->is_constant()) {
-        ciMethod* target = type->as_ObjectType()->constant_value()->as_method_handle()->get_vmtarget();
-        // We don't do CHA here so only inline static and statically bindable methods.
-        if (target->is_static() || target->can_be_statically_bound()) {
-          if (ciMethod::is_consistent_info(callee, target)) {
-            Bytecodes::Code bc = target->is_static() ? Bytecodes::_invokestatic : Bytecodes::_invokevirtual;
-            ignore_return = ignore_return || (callee->return_type()->is_void() && !target->return_type()->is_void());
-            if (try_inline(target, /*holder_known*/ !callee->is_static(), ignore_return, bc)) {
-              return true;
+        ciObject* mh = type->as_ObjectType()->constant_value();
+        if (mh->is_method_handle()) {
+          ciMethod* target = mh->as_method_handle()->get_vmtarget();
+
+          // We don't do CHA here so only inline static and statically bindable methods.
+          if (target->is_static() || target->can_be_statically_bound()) {
+            if (ciMethod::is_consistent_info(callee, target)) {
+              Bytecodes::Code bc = target->is_static() ? Bytecodes::_invokestatic : Bytecodes::_invokevirtual;
+              ignore_return = ignore_return || (callee->return_type()->is_void() && !target->return_type()->is_void());
+              if (try_inline(target, /*holder_known*/ !callee->is_static(), ignore_return, bc)) {
+                return true;
+              }
+            } else {
+              print_inlining(target, "signatures mismatch", /*success*/ false);
             }
           } else {
-            print_inlining(target, "signatures mismatch", /*success*/ false);
+            assert(false, "no inlining through MH::invokeBasic"); // missing optimization opportunity due to suboptimal LF shape
+            print_inlining(target, "not static or statically bindable", /*success*/ false);
           }
         } else {
-          print_inlining(target, "not static or statically bindable", /*success*/ false);
+          assert(mh->is_null_object(), "not a null");
+          print_inlining(callee, "receiver is always null", /*success*/ false);
         }
       } else {
         print_inlining(callee, "receiver not constant", /*success*/ false);