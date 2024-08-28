@@ -77,6 +77,16 @@ JNI_ENTRY(jlong, NEP_makeInvoker(JNIEnv* env, jclass _unused, jobject method_typ
     basic_type, pslots, ret_bt, abi, input_regs, output_regs, needs_return_buffer)->code_begin();
 JNI_END
 
+JNI_ENTRY(jboolean, NEP_freeInvoker(JNIEnv* env, jclass _unused, jlong invoker))
+  // safe to call without code cache lock, because stub is always alive
+  CodeBlob* cb = CodeCache::find_blob((char*) invoker);
+  if (cb == nullptr) {
+    return false;
+  }
+  RuntimeStub::free(cb->as_runtime_stub());
+  return true;
+JNI_END
+
 #define CC (char*)  /*cast a literal from (const char*)*/
 #define FN_PTR(f) CAST_FROM_FN_PTR(void*, &f)
 #define METHOD_TYPE "Ljava/lang/invoke/MethodType;"
@@ -85,6 +95,7 @@ JNI_END
 
 static JNINativeMethod NEP_methods[] = {
   {CC "makeInvoker", CC "(" METHOD_TYPE ABI_DESC VM_STORAGE_ARR VM_STORAGE_ARR "Z)J", FN_PTR(NEP_makeInvoker)},
+  {CC "freeInvoker0", CC "(J)Z", FN_PTR(NEP_freeInvoker)},
 };
 
 #undef METHOD_TYPE