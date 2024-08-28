@@ -105,7 +105,7 @@
 
   frame(intptr_t* sp, intptr_t* fp);
 
-  void init(intptr_t* sp, intptr_t* fp, address pc);
+  void init(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc);
 
   // accessors for the instance variables
   // Note: not necessarily the real 'frame pointer' (see real_fp)