@@ -2233,7 +2233,7 @@ JNI_ENTRY(const char*, jni_GetStringUTFChars(JNIEnv *env, jstring string, jboole
   if (s_value != NULL) {
     size_t length = java_lang_String::utf8_length(java_string, s_value);
     /* JNI Specification states return NULL on OOM */
-    result = AllocateHeap(length + 1, mtInternal, 0, AllocFailStrategy::RETURN_NULL);
+    result = AllocateHeap(length + 1, mtInternal, AllocFailStrategy::RETURN_NULL);
     if (result != NULL) {
       java_lang_String::as_utf8_string(java_string, s_value, result, (int) length + 1);
       if (isCopy != NULL) {