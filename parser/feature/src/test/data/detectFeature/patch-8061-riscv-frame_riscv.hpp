@@ -173,11 +173,13 @@
 
   frame(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc);
 
+  frame(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc, bool forSignalHandler = false);
+
   frame(intptr_t* ptr_sp, intptr_t* unextended_sp, intptr_t* ptr_fp, address pc);
 
   frame(intptr_t* ptr_sp, intptr_t* ptr_fp);
 
-  void init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc);
+  void init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc, bool forSignalHandler = false);
 
   // accessors for the instance variables
   // Note: not necessarily the real 'frame pointer' (see real_fp)