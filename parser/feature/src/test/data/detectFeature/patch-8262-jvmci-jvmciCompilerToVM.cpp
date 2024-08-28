@@ -1022,7 +1022,6 @@ C2V_VMENTRY_NULL(jlongArray, getLineNumberTable, (JNIEnv* env, jobject, jobject
   int i = 0;
   jlong value;
   while (stream.read_pair()) {
-    // FIXME: Why was this long before?
     value = ((jlong) stream.bci());
     JVMCIENV->put_long_at(result, i, value);
     value = ((jlong) stream.line());
@@ -2071,7 +2070,7 @@ C2V_VMENTRY_0(jboolean, equals, (JNIEnv* env, jobject, jobject x, jlong xHandle,
   if (x == NULL || y == NULL) {
     JVMCI_THROW_0(NullPointerException);
   }
-  return JVMCIENV->resolve_handle(xHandle) == JVMCIENV->resolve_handle(yHandle);
+  return JVMCIENV->resolve_oop_handle(xHandle) == JVMCIENV->resolve_oop_handle(yHandle);
 C2V_END
 
 C2V_VMENTRY_NULL(jobject, getJavaMirror, (JNIEnv* env, jobject, jobject object))
@@ -2161,10 +2160,9 @@ C2V_VMENTRY_0(jint, arrayIndexScale, (JNIEnv* env, jobject, jobject kind))
   return type2aelembytes(type);
 C2V_END
 
-C2V_VMENTRY(void, deleteGlobalHandle, (JNIEnv* env, jobject, jlong h))
-  jobject handle = (jobject)(address)h;
-  if (handle != NULL) {
-    JVMCIENV->runtime()->destroy_global(handle);
+C2V_VMENTRY(void, deleteGlobalHandle, (JNIEnv* env, jobject, jlong handle))
+  if (handle != 0) {
+    JVMCIENV->runtime()->destroy_oop_handle(handle);
   }
 }
 
@@ -2179,13 +2177,13 @@ C2V_VMENTRY_NULL(jlongArray, registerNativeMethods, (JNIEnv* env, jobject, jclas
   requireInHotSpot("registerNativeMethods", JVMCI_CHECK_NULL);
   char* sl_path;
   void* sl_handle;
-  JVMCIRuntime* runtime = JVMCI::compiler_runtime();
+  JVMCIRuntime* runtime;
   {
     // Ensure the JVMCI shared library runtime is initialized.
     JVMCIEnv __peer_jvmci_env__(thread, false, __FILE__, __LINE__);
     JVMCIEnv* peerEnv = &__peer_jvmci_env__;
     HandleMark hm(THREAD);
-    JVMCIObject receiver = runtime->get_HotSpotJVMCIRuntime(peerEnv);
+    runtime = JVMCI::compiler_runtime(thread);
     if (peerEnv->has_pending_exception()) {
       peerEnv->describe_pending_exception(true);
     }
@@ -2260,16 +2258,16 @@ C2V_VMENTRY_NULL(jlongArray, registerNativeMethods, (JNIEnv* env, jobject, jclas
 }
 
 C2V_VMENTRY_PREFIX(jboolean, isCurrentThreadAttached, (JNIEnv* env, jobject c2vm))
-  if (thread == NULL) {
+  if (thread == nullptr || thread->libjvmci_runtime() == nullptr) {
     // Called from unattached JVMCI shared library thread
     return false;
   }
   JVMCITraceMark jtm("isCurrentThreadAttached");
   if (thread->jni_environment() == env) {
     C2V_BLOCK(jboolean, isCurrentThreadAttached, (JNIEnv* env, jobject))
     requireJVMCINativeLibrary(JVMCI_CHECK_0);
-    JVMCIRuntime* runtime = JVMCI::compiler_runtime();
-    if (runtime == NULL || !runtime->has_shared_library_javavm()) {
+    JVMCIRuntime* runtime = thread->libjvmci_runtime();
+    if (runtime == nullptr || !runtime->has_shared_library_javavm()) {
       JVMCI_THROW_MSG_0(IllegalStateException, "Require JVMCI shared library JavaVM to be initialized in isCurrentThreadAttached");
     }
     JNIEnv* peerEnv;
@@ -2287,54 +2285,90 @@ C2V_VMENTRY_PREFIX(jlong, getCurrentJavaThread, (JNIEnv* env, jobject c2vm))
   return (jlong) p2i(thread);
 C2V_END
 
-C2V_VMENTRY_PREFIX(jboolean, attachCurrentThread, (JNIEnv* env, jobject c2vm, jbyteArray name, jboolean as_daemon))
-  if (thread == NULL) {
-    // Called from unattached JVMCI shared library thread
-    guarantee(name != NULL, "libjvmci caller must pass non-null name");
-
-    extern struct JavaVM_ main_vm;
-    JNIEnv* hotspotEnv;
+// Attaches a thread started in a JVMCI shared library to a JavaThread and JVMCI runtime.
+static void attachSharedLibraryThread(JNIEnv* env, jbyteArray name, jboolean as_daemon) {
+  JavaVM* javaVM = nullptr;
+  jint res = env->GetJavaVM(&javaVM);
+  if (res != JNI_OK) {
+    JNI_THROW("attachSharedLibraryThread", InternalError, err_msg("Error getting shared library JavaVM from shared library JNIEnv: %d", res));
+  }
+  extern struct JavaVM_ main_vm;
+  JNIEnv* hotspotEnv;
+
+  int name_len = env->GetArrayLength(name);
+  char name_buf[64]; // Cannot use Resource heap as it requires a current thread
+  int to_copy = MIN2(name_len, (int) sizeof(name_buf) - 1);
+  env->GetByteArrayRegion(name, 0, to_copy, (jbyte*) name_buf);
+  name_buf[to_copy] = '\0';
+  JavaVMAttachArgs attach_args;
+  attach_args.version = JNI_VERSION_1_2;
+  attach_args.name = name_buf;
+  attach_args.group = nullptr;
+  res = as_daemon ? main_vm.AttachCurrentThreadAsDaemon((void**)&hotspotEnv, &attach_args) :
+                    main_vm.AttachCurrentThread((void**)&hotspotEnv, &attach_args);
+  if (res != JNI_OK) {
+    JNI_THROW("attachSharedLibraryThread", InternalError, err_msg("Trying to attach thread returned %d", res));
+  }
+  JavaThread* thread = get_current_thread(false);
+  const char* attach_error;
+  {
+    // Transition to VM
+    JVMCI_VM_ENTRY_MARK
+    attach_error = JVMCIRuntime::attach_shared_library_thread(thread, javaVM);
+    // Transition back to Native
+  }
+  if (attach_error != nullptr) {
+    JNI_THROW("attachCurrentThread", InternalError, attach_error);
+  }
+}
 
-    int name_len = env->GetArrayLength(name);
-    char name_buf[64]; // Cannot use Resource heap as it requires a current thread
-    int to_copy = MIN2(name_len, (int) sizeof(name_buf) - 1);
-    env->GetByteArrayRegion(name, 0, to_copy, (jbyte*) name_buf);
-    name_buf[to_copy] = '\0';
-    JavaVMAttachArgs attach_args;
-    attach_args.version = JNI_VERSION_1_2;
-    attach_args.name = name_buf;
-    attach_args.group = NULL;
-    jint res = as_daemon ? main_vm.AttachCurrentThreadAsDaemon((void**) &hotspotEnv, &attach_args) :
-                           main_vm.AttachCurrentThread((void**) &hotspotEnv, &attach_args);
-    if (res != JNI_OK) {
-      JNI_THROW_("attachCurrentThread", InternalError, err_msg("Trying to attach thread returned %d", res), false);
-    }
+C2V_VMENTRY_PREFIX(jboolean, attachCurrentThread, (JNIEnv* env, jobject c2vm, jbyteArray name, jboolean as_daemon, jlongArray javaVM_info))
+  if (thread == nullptr) {
+    attachSharedLibraryThread(env, name, as_daemon);
     return true;
   }
   JVMCITraceMark jtm("attachCurrentThread");
   if (thread->jni_environment() == env) {
     // Called from HotSpot
     C2V_BLOCK(jboolean, attachCurrentThread, (JNIEnv* env, jobject, jboolean))
     requireJVMCINativeLibrary(JVMCI_CHECK_0);
-    JVMCIRuntime* runtime = JVMCI::compiler_runtime();
-    if (runtime == NULL || !runtime->has_shared_library_javavm()) {
-        JVMCI_THROW_MSG_0(IllegalStateException, "Require JVMCI shared library JavaVM to be initialized in attachCurrentThread");
+
+    JVMCIRuntime* runtime = JVMCI::compiler_runtime(thread);
+    JNIEnv* peerJNIEnv;
+    if (runtime->has_shared_library_javavm()) {
+      if (runtime->GetEnv(thread, (void**)&peerJNIEnv, JNI_VERSION_1_2) == JNI_OK) {
+        // Already attached
+        runtime->init_JavaVM_info(javaVM_info, JVMCI_CHECK_0);
+        return false;
+      }
+    }
+
+    {
+      // Ensure the JVMCI shared library runtime is initialized.
+      JVMCIEnv __peer_jvmci_env__(thread, false, __FILE__, __LINE__);
+      JVMCIEnv* peerJVMCIEnv = &__peer_jvmci_env__;
+      HandleMark hm(thread);
+      JVMCIObject receiver = runtime->get_HotSpotJVMCIRuntime(peerJVMCIEnv);
+      if (peerJVMCIEnv->has_pending_exception()) {
+        peerJVMCIEnv->describe_pending_exception(true);
+      }
+      char* sl_path;
+      if (JVMCI::get_shared_library(sl_path, false) == nullptr) {
+        JVMCI_THROW_MSG_0(InternalError, "Error initializing JVMCI runtime");
+      }
     }
 
     JavaVMAttachArgs attach_args;
     attach_args.version = JNI_VERSION_1_2;
     attach_args.name = const_cast<char*>(thread->name());
-    attach_args.group = NULL;
-    JNIEnv* peerJNIEnv;
-    if (runtime->GetEnv(thread, (void**) &peerJNIEnv, JNI_VERSION_1_2) == JNI_OK) {
-      return false;
-    }
+    attach_args.group = nullptr;
     jint res = as_daemon ? runtime->AttachCurrentThreadAsDaemon(thread, (void**) &peerJNIEnv, &attach_args) :
                            runtime->AttachCurrentThread(thread, (void**) &peerJNIEnv, &attach_args);
 
     if (res == JNI_OK) {
-      guarantee(peerJNIEnv != NULL, "must be");
-      JVMCI_event_1("attached to JavaVM for JVMCI runtime %d", runtime->id());
+      guarantee(peerJNIEnv != nullptr, "must be");
+      runtime->init_JavaVM_info(javaVM_info, JVMCI_CHECK_0);
+      JVMCI_event_1("attached to JavaVM[%d] for JVMCI runtime %d", runtime->get_shared_library_javavm_id(), runtime->id());
       return true;
     }
     JVMCI_THROW_MSG_0(InternalError, err_msg("Error %d while attaching %s", res, attach_args.name));
@@ -2343,37 +2377,59 @@ C2V_VMENTRY_PREFIX(jboolean, attachCurrentThread, (JNIEnv* env, jobject c2vm, jb
   return false;
 C2V_END
 
-C2V_VMENTRY_PREFIX(void, detachCurrentThread, (JNIEnv* env, jobject c2vm))
-  if (thread == NULL) {
+C2V_VMENTRY_PREFIX(jboolean, detachCurrentThread, (JNIEnv* env, jobject c2vm, jboolean release))
+  if (thread == nullptr) {
     // Called from unattached JVMCI shared library thread
-    JNI_THROW("detachCurrentThread", IllegalStateException, "Cannot detach non-attached thread");
+    JNI_THROW_("detachCurrentThread", IllegalStateException, "Cannot detach non-attached thread", false);
   }
   JVMCITraceMark jtm("detachCurrentThread");
   if (thread->jni_environment() == env) {
     // Called from HotSpot
     C2V_BLOCK(void, detachCurrentThread, (JNIEnv* env, jobject))
-    requireJVMCINativeLibrary(JVMCI_CHECK);
-    requireInHotSpot("detachCurrentThread", JVMCI_CHECK);
-    JVMCIRuntime* runtime = JVMCI::compiler_runtime();
-    if (runtime == NULL || !runtime->has_shared_library_javavm()) {
-      JVMCI_THROW_MSG(IllegalStateException, "Require JVMCI shared library JavaVM to be initialized in detachCurrentThread");
+    requireJVMCINativeLibrary(JVMCI_CHECK_0);
+    requireInHotSpot("detachCurrentThread", JVMCI_CHECK_0);
+    JVMCIRuntime* runtime = thread->libjvmci_runtime();
+    if (runtime == nullptr || !runtime->has_shared_library_javavm()) {
+      JVMCI_THROW_MSG_0(IllegalStateException, "Require JVMCI shared library JavaVM to be initialized in detachCurrentThread");
     }
-    JNIEnv* peerJNIEnv;
-    if (runtime->GetEnv(thread, (void**) &peerJNIEnv, JNI_VERSION_1_2) != JNI_OK) {
-      JVMCI_THROW_MSG(IllegalStateException, err_msg("Cannot detach non-attached thread: %s", thread->name()));
+    JNIEnv* peerEnv;
+
+    if (runtime->GetEnv(thread, (void**) &peerEnv, JNI_VERSION_1_2) != JNI_OK) {
+      JVMCI_THROW_MSG_0(IllegalStateException, err_msg("Cannot detach non-attached thread: %s", thread->name()));
     }
     jint res = runtime->DetachCurrentThread(thread);
     if (res != JNI_OK) {
-      JVMCI_THROW_MSG(InternalError, err_msg("Error %d while attaching %s", res, thread->name()));
+      JVMCI_THROW_MSG_0(InternalError, err_msg("Error %d while attaching %s", res, thread->name()));
+    }
+    JVMCI_event_1("detached from JavaVM[%d] for JVMCI runtime %d",
+        runtime->get_shared_library_javavm_id(), runtime->id());
+    if (release) {
+      return runtime->detach_thread(thread, "user thread detach");
     }
   } else {
     // Called from attached JVMCI shared library thread
+    if (release) {
+      JNI_THROW_("detachCurrentThread", InternalError, "JVMCI shared library thread cannot release JVMCI shared library JavaVM", false);
+    }
+    JVMCIRuntime* runtime = thread->libjvmci_runtime();
+    if (runtime == nullptr) {
+      JNI_THROW_("detachCurrentThread", InternalError, "JVMCI shared library thread should have a JVMCI runtime", false);
+    }
+    {
+      // Transition to VM
+      C2V_BLOCK(jboolean, detachCurrentThread, (JNIEnv* env, jobject))
+      // Cannot destroy shared library JavaVM as we're about to return to it.
+      runtime->detach_thread(thread, "shared library thread detach", false);
+      JVMCI_event_1("detaching JVMCI shared library thread from HotSpot JavaVM");
+      // Transition back to Native
+    }
     extern struct JavaVM_ main_vm;
     jint res = main_vm.DetachCurrentThread();
     if (res != JNI_OK) {
-      JNI_THROW("detachCurrentThread", InternalError, "Cannot detach non-attached thread");
+      JNI_THROW_("detachCurrentThread", InternalError, "Cannot detach non-attached thread", false);
     }
   }
+  return false;
 C2V_END
 
 C2V_VMENTRY_0(jlong, translate, (JNIEnv* env, jobject, jobject obj_handle, jboolean callPostTranslation))
@@ -2468,7 +2524,7 @@ C2V_VMENTRY_NULL(jobject, unhand, (JNIEnv* env, jobject, jlong obj_handle))
     return NULL;
   }
   jobject global_handle = (jobject) obj_handle;
-  JVMCIObject global_handle_obj = JVMCIENV->wrap((jobject) obj_handle);
+  JVMCIObject global_handle_obj = JVMCIENV->wrap(global_handle);
   jobject result = JVMCIENV->make_local(global_handle_obj).as_jobject();
 
   JVMCIENV->destroy_global(global_handle_obj);
@@ -2797,8 +2853,8 @@ JNINativeMethod CompilerToVM::methods[] = {
   {CC "registerNativeMethods",                        CC "(" CLASS ")[J",                                                                   FN_PTR(registerNativeMethods)},
   {CC "isCurrentThreadAttached",                      CC "()Z",                                                                             FN_PTR(isCurrentThreadAttached)},
   {CC "getCurrentJavaThread",                         CC "()J",                                                                             FN_PTR(getCurrentJavaThread)},
-  {CC "attachCurrentThread",                          CC "([BZ)Z",                                                                          FN_PTR(attachCurrentThread)},
-  {CC "detachCurrentThread",                          CC "()V",                                                                             FN_PTR(detachCurrentThread)},
+  {CC "attachCurrentThread",                          CC "([BZ[J)Z",                                                                        FN_PTR(attachCurrentThread)},
+  {CC "detachCurrentThread",                          CC "(Z)Z",                                                                            FN_PTR(detachCurrentThread)},
   {CC "translate",                                    CC "(" OBJECT "Z)J",                                                                  FN_PTR(translate)},
   {CC "unhand",                                       CC "(J)" OBJECT,                                                                      FN_PTR(unhand)},
   {CC "updateHotSpotNmethod",                         CC "(" HS_NMETHOD ")V",                                                               FN_PTR(updateHotSpotNmethod)},