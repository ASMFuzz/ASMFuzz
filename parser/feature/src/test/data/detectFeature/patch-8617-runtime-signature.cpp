@@ -230,21 +230,39 @@ void Fingerprinter::do_type_calling_convention(BasicType type) {
   case T_BYTE:
   case T_SHORT:
   case T_INT:
+#if defined(PPC64)
+    if (_int_args < Argument::n_int_register_parameters_j) {
+      _int_args++;
+    } else {
+      _stack_arg_slots += 1;
+    }
+    break;
+#endif // defined(PPC64)
   case T_LONG:
   case T_OBJECT:
   case T_ARRAY:
   case T_ADDRESS:
     if (_int_args < Argument::n_int_register_parameters_j) {
       _int_args++;
     } else {
+      PPC64_ONLY(_stack_arg_slots = align_up(_stack_arg_slots, 2));
       _stack_arg_slots += 2;
     }
     break;
   case T_FLOAT:
+#if defined(PPC64)
+    if (_fp_args < Argument::n_float_register_parameters_j) {
+      _fp_args++;
+    } else {
+      _stack_arg_slots += 1;
+    }
+    break;
+#endif // defined(PPC64)
   case T_DOUBLE:
     if (_fp_args < Argument::n_float_register_parameters_j) {
       _fp_args++;
     } else {
+      PPC64_ONLY(_stack_arg_slots = align_up(_stack_arg_slots, 2));
       _stack_arg_slots += 2;
     }
     break;