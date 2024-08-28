@@ -32,7 +32,7 @@
   }
 
   // The `last' frame is the youngest Java frame on the thread's stack.
-  frame pd_last_frame();
+  frame pd_last_frame(bool forSignalHandler = false);
 
  public:
   bool pd_get_top_frame_for_signal_handler(frame* fr_addr, void* ucontext,
@@ -41,4 +41,8 @@
   bool pd_get_top_frame_for_profiling(frame* fr_addr, void* ucontext,
                                       bool isInJava);
 
+ private:
+  bool pd_get_top_frame(frame* fr_addr, void* ucontext,
+                                      bool isInJava, bool forSignalHandler = false);
+
 #endif // OS_CPU_AIX_PPC_THREAD_AIX_PPC_HPP