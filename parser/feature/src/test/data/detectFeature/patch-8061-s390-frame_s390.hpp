@@ -460,14 +460,14 @@
 
  private:
 
-  inline void find_codeblob_and_set_pc_and_deopt_state(address pc);
+  inline void find_codeblob_and_set_pc_and_deopt_state(address pc, bool forSignalHandler = false);
 
  // Constructors
 
  public:
   inline frame(intptr_t* sp);
   // To be used, if sp was not extended to match callee's calling convention.
-  inline frame(intptr_t* sp, address pc);
+  inline frame(intptr_t* sp, address pc, bool forSignalHandler = false);
   inline frame(intptr_t* sp, address pc, intptr_t* unextended_sp);
 
   // Access frame via stack pointer.