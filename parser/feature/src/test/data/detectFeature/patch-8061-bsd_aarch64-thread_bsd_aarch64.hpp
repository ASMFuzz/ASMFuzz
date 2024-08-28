@@ -32,7 +32,7 @@
     _anchor.clear();
   }
 
-  frame pd_last_frame();
+  frame pd_last_frame(bool forSignalHandler = false);
 
  public:
   static ByteSize last_Java_fp_offset()          {
@@ -45,7 +45,7 @@
   bool pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext, bool isInJava);
 
 private:
-  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava);
+  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler);
 public:
 
   static Thread *aarch64_get_thread_helper() {