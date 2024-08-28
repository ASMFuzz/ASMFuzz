@@ -375,13 +375,13 @@
  private:
 
   // Find codeblob and set deopt_state.
-  inline void find_codeblob_and_set_pc_and_deopt_state(address pc);
+  inline void find_codeblob_and_set_pc_and_deopt_state(address pc, bool forSignalHandler = false);
 
  public:
 
   // Constructors
   inline frame(intptr_t* sp);
-  inline frame(intptr_t* sp, address pc);
+  inline frame(intptr_t* sp, address pc, bool forSignalHandler = false);
   inline frame(intptr_t* sp, address pc, intptr_t* unextended_sp);
 
  private: