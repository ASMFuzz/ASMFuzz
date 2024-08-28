@@ -456,12 +456,14 @@ char* java_lang_String::as_platform_dependent_str(Handle java_string, TRAPS) {
   char *native_platform_string;
   { JavaThread* thread = THREAD;
     jstring js = (jstring) JNIHandles::make_local(thread, java_string());
-    bool is_copy;
-    HandleMark hm(thread);
-    ThreadToNativeFromVM ttn(thread);
-    JNIEnv *env = thread->jni_environment();
-    native_platform_string = (_to_platform_string_fn)(env, js, &is_copy);
-    assert(is_copy == JNI_TRUE, "is_copy value changed");
+    {
+      bool is_copy;
+      HandleMark hm(thread);
+      ThreadToNativeFromVM ttn(thread);
+      JNIEnv *env = thread->jni_environment();
+      native_platform_string = (_to_platform_string_fn)(env, js, &is_copy);
+      assert(is_copy == JNI_TRUE, "is_copy value changed");
+    }
     JNIHandles::destroy_local(js);
   }
   return native_platform_string;