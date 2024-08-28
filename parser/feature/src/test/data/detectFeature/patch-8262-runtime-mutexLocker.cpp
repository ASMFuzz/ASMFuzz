@@ -156,6 +156,7 @@ Mutex*   Bootclasspath_lock           = NULL;
 
 #if INCLUDE_JVMCI
 Monitor* JVMCI_lock                   = NULL;
+Monitor* JVMCIRuntime_lock            = NULL;
 #endif
 
 
@@ -336,7 +337,8 @@ void mutex_init() {
   def(Zip_lock                     , PaddedMonitor, nosafepoint-1); // Holds DumpTimeTable_lock
 
 #if INCLUDE_JVMCI
-  def(JVMCI_lock                   , PaddedMonitor, safepoint, true);
+  // JVMCIRuntime::_lock must be acquired before JVMCI_lock to avoid deadlock
+  def(JVMCIRuntime_lock            , PaddedMonitor, safepoint, true);
 #endif
 
   // These locks have relative rankings, and inherit safepoint checking attributes from that rank.
@@ -369,6 +371,10 @@ void mutex_init() {
   defl(Module_lock                 , PaddedMutex ,  ClassLoaderDataGraph_lock);
   defl(SystemDictionary_lock       , PaddedMonitor, Module_lock);
   defl(JNICritical_lock            , PaddedMonitor, MultiArray_lock); // used for JNI critical regions
+#if INCLUDE_JVMCI
+  // JVMCIRuntime_lock must be acquired before JVMCI_lock to avoid deadlock
+  defl(JVMCI_lock                  , PaddedMonitor, JVMCIRuntime_lock);
+#endif
 }
 
 GCMutexLocker::GCMutexLocker(Mutex* mutex) {