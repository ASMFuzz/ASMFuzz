@@ -374,16 +374,16 @@
 
  private:
 
-  // Find codeblob and set deopt_state.
-  inline void find_codeblob_and_set_pc_and_deopt_state(address pc);
+  // Initialize frame members (_pc and _sp must be given)
+  inline void setup();
 
  public:
 
   const ImmutableOopMap* get_oop_map() const;
 
   // Constructors
   inline frame(intptr_t* sp, address pc);
-  inline frame(intptr_t* sp, address pc, intptr_t* unextended_sp);
+  inline frame(intptr_t* sp, address pc, intptr_t* unextended_sp, intptr_t* fp = nullptr, CodeBlob* cb = nullptr);
 
  private:
 