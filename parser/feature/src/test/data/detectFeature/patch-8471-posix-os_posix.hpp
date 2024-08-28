@@ -50,24 +50,12 @@ class Posix {
   static void print_load_average(outputStream* st);
   static void print_uptime_info(outputStream* st);
 
-  // Minimum stack size a thread can be created with (allowing
-  // the VM to completely create the thread and enter user code).
-  // The initial values exclude any guard pages (by HotSpot or libc).
-  // set_minimum_stack_sizes() will add the size required for
-  // HotSpot guard pages depending on page size and flag settings.
-  // Libc guard pages are never considered by these values.
-  static size_t _compiler_thread_min_stack_allowed;
-  static size_t _java_thread_min_stack_allowed;
-  static size_t _vm_internal_thread_min_stack_allowed;
-
 public:
   static void init(void);  // early initialization - no logging available
   static void init_2(void);// later initialization - logging available
 
   // Return default stack size for the specified thread type
   static size_t default_stack_size(os::ThreadType thr_type);
-  // Check and sets minimum stack sizes
-  static jint set_minimum_stack_sizes();
   static size_t get_initial_stack_size(ThreadType thr_type, size_t req_stack_size);
 
   // Helper function; describes pthread attributes as short string. String is written