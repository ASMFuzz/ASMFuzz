@@ -166,7 +166,7 @@
   // original sp we use that convention.
 
   intptr_t*     _unextended_sp;
-  void adjust_unextended_sp();
+  void adjust_unextended_sp() NOT_DEBUG_RETURN;
 
   intptr_t* ptr_at_addr(int offset) const {
     return (intptr_t*) addr_at(offset);
@@ -189,6 +189,7 @@
   frame(intptr_t* ptr_sp, intptr_t* ptr_fp);
 
   void init(intptr_t* ptr_sp, intptr_t* ptr_fp, address pc);
+  void setup(address pc);
 
   // accessors for the instance variables
   // Note: not necessarily the real 'frame pointer' (see real_fp)