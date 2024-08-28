@@ -392,8 +392,11 @@ class JVMCIEnv : public ResourceObj {
   JVMCIObject new_HotSpotStackFrameReference(JVMCI_TRAPS);
   JVMCIObject new_JVMCIError(JVMCI_TRAPS);
 
-  jlong make_handle(const Handle& obj);
-  oop resolve_handle(jlong objectHandle);
+  // Makes a handle to a HotSpot heap object. These handles are
+  // individually reclaimed by JVMCIRuntime::destroy_oop_handle and
+  // bulk reclaimed by JVMCIRuntime::release_and_clear_globals.
+  jlong make_oop_handle(const Handle& obj);
+  oop resolve_oop_handle(jlong oopHandle);
 
   // These are analagous to the JNI routines
   JVMCIObject make_local(JVMCIObject object);