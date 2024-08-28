@@ -176,7 +176,7 @@ void JVMCIEnv::init_env_mode_runtime(JavaThread* thread, JNIEnv* parent_env) {
       _runtime = JVMCI::java_runtime();
       return;
     }
-    _runtime = JVMCI::compiler_runtime();
+    _runtime = thread->libjvmci_runtime();
     assert(_runtime != NULL, "npe");
     _env = parent_env;
     return;
@@ -186,7 +186,7 @@ void JVMCIEnv::init_env_mode_runtime(JavaThread* thread, JNIEnv* parent_env) {
   // is loaded and initialized and get a shared library JNIEnv
   _is_hotspot = false;
 
-  _runtime = JVMCI::compiler_runtime();
+  _runtime = JVMCI::compiler_runtime(thread);
   _env = _runtime->init_shared_library_javavm();
 
   if (_env != NULL) {
@@ -1383,7 +1383,7 @@ JVMCIObject JVMCIEnv::get_object_constant(oop objOop, bool compressed, bool dont
     HotSpotJVMCI::HotSpotObjectConstantImpl::set_compressed(this, constant, compressed);
     return wrap(constant);
   } else {
-    jlong handle = make_handle(obj);
+    jlong handle = make_oop_handle(obj);
     JNIAccessMark jni(this, THREAD);
     jobject result = jni()->NewObject(JNIJVMCI::IndirectHotSpotObjectConstantImpl::clazz(),
                                       JNIJVMCI::IndirectHotSpotObjectConstantImpl::constructor(),
@@ -1407,7 +1407,7 @@ Handle JVMCIEnv::asConstant(JVMCIObject constant, JVMCI_TRAPS) {
     if (object_handle == 0L) {
       JVMCI_THROW_MSG_(NullPointerException, "Foreign object reference has been cleared", Handle());
     }
-    oop result = resolve_handle(object_handle);
+    oop result = resolve_oop_handle(object_handle);
     if (result == NULL) {
       JVMCI_THROW_MSG_(InternalError, "Constant was unexpectedly NULL", Handle());
     }
@@ -1421,15 +1421,14 @@ JVMCIObject JVMCIEnv::wrap(jobject object) {
   return JVMCIObject::create(object, is_hotspot());
 }
 
-jlong JVMCIEnv::make_handle(const Handle& obj) {
+jlong JVMCIEnv::make_oop_handle(const Handle& obj) {
   assert(!obj.is_null(), "should only create handle for non-NULL oops");
-  jobject handle = _runtime->make_global(obj);
-  return (jlong) handle;
+  return _runtime->make_oop_handle(obj);
 }
 
-oop JVMCIEnv::resolve_handle(jlong objectHandle) {
-  assert(objectHandle != 0, "should be a valid handle");
-  oop obj = *((oopDesc**)objectHandle);
+oop JVMCIEnv::resolve_oop_handle(jlong oopHandle) {
+  assert(oopHandle != 0, "should be a valid handle");
+  oop obj = *((oopDesc**) oopHandle);
   if (obj != NULL) {
     oopDesc::verify(obj);
   }