@@ -64,24 +64,15 @@ static char* jstr_to_utf(JNIEnv *env, jstring str, TRAPS) {
   return utfstr;
 }
 
-PERF_ENTRY(jobject, Perf_Attach(JNIEnv *env, jobject unused, jstring user, int vmid))
+PERF_ENTRY(jobject, Perf_Attach(JNIEnv *env, jobject unused, int vmid))
 
   PerfWrapper("Perf_Attach");
 
   char* address = 0;
   size_t capacity = 0;
-  const char* user_utf = NULL;
-
-  ResourceMark rm;
-
-  {
-    ThreadToNativeFromVM ttnfv(thread);
-
-    user_utf = user == NULL ? NULL : jstr_to_utf(env, user, CHECK_NULL);
-  }
 
   // attach to the PerfData memory region for the specified VM
-  PerfMemory::attach(user_utf, vmid, &address, &capacity, CHECK_NULL);
+  PerfMemory::attach(vmid, &address, &capacity, CHECK_NULL);
 
   {
     ThreadToNativeFromVM ttnfv(thread);
@@ -294,7 +285,7 @@ PERF_END
 
 static JNINativeMethod perfmethods[] = {
 
-  {CC "attach0",             CC "(" JLS "I)" BB,  FN_PTR(Perf_Attach)},
+  {CC "attach0",             CC "(I)" BB,         FN_PTR(Perf_Attach)},
   {CC "detach",              CC "(" BB ")V",      FN_PTR(Perf_Detach)},
   {CC "createLong",          CL_ARGS,             FN_PTR(Perf_CreateLong)},
   {CC "createByteArray",     CBA_ARGS,            FN_PTR(Perf_CreateByteArray)},