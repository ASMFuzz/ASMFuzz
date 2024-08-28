@@ -30,7 +30,7 @@
     _anchor.clear();
   }
 
-  frame pd_last_frame();
+  frame pd_last_frame(bool forSignalHandler = false);
 
  public:
   static ByteSize last_Java_fp_offset()          {
@@ -44,6 +44,6 @@
     bool isInJava);
 
 private:
-  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava);
+  bool pd_get_top_frame(frame* fr_addr, void* ucontext, bool isInJava, bool forSignalHandler);
 
 #endif // OS_CPU_BSD_X86_THREAD_BSD_X86_HPP