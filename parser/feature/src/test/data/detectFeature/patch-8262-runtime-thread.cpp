@@ -1034,6 +1034,7 @@ JavaThread::JavaThread() :
   _in_retryable_allocation(false),
   _pending_failed_speculation(0),
   _jvmci{nullptr},
+  _libjvmci_runtime(nullptr),
   _jvmci_counters(nullptr),
   _jvmci_reserved0(0),
   _jvmci_reserved1(0),