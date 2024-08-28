@@ -93,13 +93,13 @@
  public:
   // Constructors
 
-  frame(intptr_t* sp, intptr_t* fp, address pc);
+  frame(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler = false);
 
   frame(intptr_t* sp, intptr_t* unextended_sp, intptr_t* fp, address pc);
 
   frame(intptr_t* sp, intptr_t* fp);
 
-  void init(intptr_t* sp, intptr_t* fp, address pc);
+  void init(intptr_t* sp, intptr_t* fp, address pc, bool forSignalHandler = false);
 
   // accessors for the instance variables
   // Note: not necessarily the real 'frame pointer' (see real_fp)