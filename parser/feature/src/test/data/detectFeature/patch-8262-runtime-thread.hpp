@@ -80,6 +80,8 @@ class JvmtiDeferredUpdates;
 class ThreadClosure;
 class ICRefillVerifier;
 
+class JVMCIRuntime;
+
 class Metadata;
 class ResourceArea;
 
@@ -940,6 +942,9 @@ class JavaThread: public Thread {
     address   _alternate_call_target;
   } _jvmci;
 
+  // The JVMCIRuntime in a JVMCI shared library
+  JVMCIRuntime* _libjvmci_runtime;
+
   // Support for high precision, thread sensitive counters in JVMCI compiled code.
   jlong*    _jvmci_counters;
 
@@ -1219,6 +1224,12 @@ class JavaThread: public Thread {
 
   virtual bool in_retryable_allocation() const    { return _in_retryable_allocation; }
   void set_in_retryable_allocation(bool b)        { _in_retryable_allocation = b; }
+
+  JVMCIRuntime* libjvmci_runtime() const          { return _libjvmci_runtime; }
+  void set_libjvmci_runtime(JVMCIRuntime* rt) {
+    assert((_libjvmci_runtime == nullptr && rt != nullptr) || (_libjvmci_runtime != nullptr && rt == nullptr), "must be");
+    _libjvmci_runtime = rt;
+  }
 #endif // INCLUDE_JVMCI
 
   // Exception handling for compiled methods