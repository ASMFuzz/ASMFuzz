@@ -1018,22 +1018,29 @@ CallGenerator* CallGenerator::for_method_handle_inline(JVMState* jvms, ciMethod*
       Node* receiver = kit.argument(0);
       if (receiver->Opcode() == Op_ConP) {
         input_not_const = false;
-        const TypeOopPtr* oop_ptr = receiver->bottom_type()->is_oopptr();
-        ciMethod* target = oop_ptr->const_oop()->as_method_handle()->get_vmtarget();
-        const int vtable_index = Method::invalid_vtable_index;
+        const TypeOopPtr* recv_toop = receiver->bottom_type()->isa_oopptr();
+        if (recv_toop != NULL) {
+          ciMethod* target = recv_toop->const_oop()->as_method_handle()->get_vmtarget();
+          const int vtable_index = Method::invalid_vtable_index;
+
+          if (!ciMethod::is_consistent_info(callee, target)) {
+            print_inlining_failure(C, callee, jvms->depth() - 1, jvms->bci(),
+                                   "signatures mismatch");
+            return NULL;
+          }
 
-        if (!ciMethod::is_consistent_info(callee, target)) {
+          CallGenerator *cg = C->call_generator(target, vtable_index,
+                                                false /* call_does_dispatch */,
+                                                jvms,
+                                                allow_inline,
+                                                PROB_ALWAYS);
+          return cg;
+        } else {
+          assert(receiver->bottom_type() == TypePtr::NULL_PTR, "not a null: %s",
+                 Type::str(receiver->bottom_type()));
           print_inlining_failure(C, callee, jvms->depth() - 1, jvms->bci(),
-                                 "signatures mismatch");
-          return NULL;
+                                 "receiver is always null");
         }
-
-        CallGenerator* cg = C->call_generator(target, vtable_index,
-                                              false /* call_does_dispatch */,
-                                              jvms,
-                                              allow_inline,
-                                              PROB_ALWAYS);
-        return cg;
       } else {
         print_inlining_failure(C, callee, jvms->depth() - 1, jvms->bci(),
                                "receiver not constant");