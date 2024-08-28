@@ -37,7 +37,7 @@
     _in_top_frame_unsafe_section = NULL;
   }
 
-  frame pd_last_frame();
+  frame pd_last_frame(bool forSignalHandler = false);
 
  public:
   static ByteSize last_Java_fp_offset()          {
@@ -59,7 +59,7 @@
 
   bool pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava);
 private:
-  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava);
+  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler);
 public:
 
 #endif // OS_CPU_LINUX_ARM_THREAD_LINUX_ARM_HPP