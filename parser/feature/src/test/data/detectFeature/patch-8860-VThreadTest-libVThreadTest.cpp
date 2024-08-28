@@ -40,6 +40,9 @@ static jvmtiEnv *jvmti = NULL;
 static jrawMonitorID events_monitor = NULL;
 static Tinfo tinfo[MAX_WORKER_THREADS];
 
+static int vthread_mount_count = 0;
+static int vthread_unmount_count = 0;
+static jboolean passed = JNI_TRUE;
 
 static Tinfo*
 find_tinfo(JNIEnv* jni, const char* tname) {
@@ -535,6 +538,7 @@ VirtualThreadMount(jvmtiEnv *jvmti, ...) {
   va_end(ap);
 
   RawMonitorLocker rml(jvmti, jni, events_monitor);
+  vthread_mount_count++;
   processVThreadEvent(jvmti, jni, thread, "VirtualThreadMount");
 }
 
@@ -551,6 +555,7 @@ VirtualThreadUnmount(jvmtiEnv *jvmti, ...) {
   va_end(ap);
 
   RawMonitorLocker rml(jvmti, jni, events_monitor);
+  vthread_unmount_count++;
   processVThreadEvent(jvmti, jni, thread, "VirtualThreadUnmount");
 }
 
@@ -628,4 +633,25 @@ Agent_OnLoad(JavaVM *jvm, char *options,
   return JNI_OK;
 }
 
+JNIEXPORT jboolean JNICALL
+Java_VThreadTest_check(JNIEnv *jni, jclass cls) {
+  LOG("\n");
+  LOG("check: started\n");
+
+  LOG("check: vthread_mount_count:   %d\n", vthread_mount_count);
+  LOG("check: vthread_unmount_count: %d\n", vthread_unmount_count);
+
+  if (vthread_mount_count == 0) {
+    passed = JNI_FALSE;
+    LOG("FAILED: vthread_mount_count == 0\n");
+  }
+  if (vthread_unmount_count == 0) {
+    passed = JNI_FALSE;
+    LOG("FAILED: vthread_unmount_count == 0\n");
+  }
+  LOG("check: finished\n");
+  LOG("\n");
+  return passed;
+}
+
 } // extern "C"