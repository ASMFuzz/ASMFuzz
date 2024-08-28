@@ -690,6 +690,7 @@ class os: AllStatic {
   static void print_dll_info(outputStream* st);
   static void print_environment_variables(outputStream* st, const char** env_list);
   static void print_context(outputStream* st, const void* context);
+  static void print_tos_pc(outputStream* st, const void* context);
   static void print_register_info(outputStream* st, const void* context);
   static bool signal_sent_by_kill(const void* siginfo);
   static void print_siginfo(outputStream* st, const void* siginfo);