@@ -287,6 +287,22 @@ class os: AllStatic {
   static void map_stack_shadow_pages(address sp);
   static bool stack_shadow_pages_available(Thread *thread, const methodHandle& method, address sp);
 
+ private:
+  // Minimum stack size a thread can be created with (allowing
+  // the VM to completely create the thread and enter user code).
+  // The initial values exclude any guard pages (by HotSpot or libc).
+  // set_minimum_stack_sizes() will add the size required for
+  // HotSpot guard pages depending on page size and flag settings.
+  // Libc guard pages are never considered by these values.
+  static size_t _compiler_thread_min_stack_allowed;
+  static size_t _java_thread_min_stack_allowed;
+  static size_t _vm_internal_thread_min_stack_allowed;
+  static size_t _os_min_stack_allowed;
+
+  // Check and sets minimum stack sizes
+  static jint set_minimum_stack_sizes();
+
+ public:
   // Find committed memory region within specified range (start, start + size),
   // return true if found any
   static bool committed_in_range(address start, size_t size, address& committed_start, size_t& committed_size);