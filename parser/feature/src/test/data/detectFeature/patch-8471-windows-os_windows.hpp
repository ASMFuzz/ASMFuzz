@@ -50,7 +50,6 @@ class win32 {
   static int    _processor_type;
   static int    _processor_level;
   static julong _physical_memory;
-  static size_t _default_stack_size;
   static bool   _is_windows_server;
   static bool   _has_exit_bug;
 
@@ -103,9 +102,6 @@ class win32 {
   // the structure passed in (see winnt.h).
   static void read_executable_headers(PIMAGE_NT_HEADERS);
 
-  // Default stack size for the current process.
-  static size_t default_stack_size() { return _default_stack_size; }
-
   static bool get_frame_at_stack_banging_point(JavaThread* thread,
                           struct _EXCEPTION_POINTERS* exceptionInfo,
                           address pc, frame* fr);