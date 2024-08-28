@@ -147,13 +147,6 @@ class MacroAssembler: public Assembler {
   // thread in the default location (xthread)
   void reset_last_Java_frame(bool clear_fp);
 
-  void call_native(address entry_point,
-                   Register arg_0);
-  void call_native_base(
-    address entry_point,                // the entry point
-    Label*  retaddr = NULL
-  );
-
   virtual void call_VM_leaf_base(
     address entry_point,                // the entry point
     int     number_of_arguments,        // the number of arguments to pop after the call