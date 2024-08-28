@@ -47,6 +47,7 @@ extern struct JavaVM_ main_vm;
 struct UpcallContext {
   Thread* attachedThread;
 
+  UpcallContext() {} // Explicit constructor to address XL C compiler bug.
   ~UpcallContext() {
     if (attachedThread != NULL) {
       JavaVM_ *vm = (JavaVM *)(&main_vm);