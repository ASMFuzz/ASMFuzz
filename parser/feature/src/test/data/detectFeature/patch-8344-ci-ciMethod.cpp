@@ -82,7 +82,6 @@ ciMethod::ciMethod(const methodHandle& h_m, ciInstanceKlass* holder) :
   _max_stack          = h_m->max_stack();
   _max_locals         = h_m->max_locals();
   _code_size          = h_m->code_size();
-  _intrinsic_id       = h_m->intrinsic_id();
   _handler_count      = h_m->exception_table_length();
   _size_of_parameters = h_m->size_of_parameters();
   _uses_monitors      = h_m->access_flags().has_monitor_bytecodes();
@@ -102,6 +101,10 @@ ciMethod::ciMethod(const methodHandle& h_m, ciInstanceKlass* holder) :
   _bcea               = NULL;
 #endif // COMPILER2
 
+  // Check for blackhole intrinsic and then populate the intrinsic ID.
+  CompilerOracle::tag_blackhole_if_possible(h_m);
+  _intrinsic_id       = h_m->intrinsic_id();
+
   ciEnv *env = CURRENT_ENV;
   if (env->jvmti_can_hotswap_or_post_breakpoint()) {
     // 6328518 check hotswap conditions under the right lock.
@@ -157,8 +160,6 @@ ciMethod::ciMethod(const methodHandle& h_m, ciInstanceKlass* holder) :
     ciReplay::initialize(this);
   }
 #endif
-
-  CompilerOracle::tag_blackhole_if_possible(h_m);
 }
 
 