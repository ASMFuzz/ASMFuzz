@@ -148,7 +148,8 @@ extern Mutex*   CodeHeapStateAnalytics_lock;     // lock print functions against
                                                  // Only used locally in PrintCodeCacheLayout processing.
 
 #if INCLUDE_JVMCI
-extern Monitor* JVMCI_lock;                      // Monitor to control initialization of JVMCI
+extern Monitor* JVMCI_lock;                      // protects global JVMCI critical sections
+extern Monitor* JVMCIRuntime_lock;               // protects critical sections for a specific JVMCIRuntime object
 #endif
 
 extern Mutex*   Bootclasspath_lock;