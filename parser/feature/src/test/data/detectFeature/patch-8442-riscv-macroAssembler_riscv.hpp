@@ -512,8 +512,6 @@ class MacroAssembler: public Assembler {
     pop_call_clobbered_registers_except(RegSet());
   }
 
-  void pusha();
-  void popa();
   void push_CPU_state(bool save_vectors = false, int vector_size_in_bytes = 0);
   void pop_CPU_state(bool restore_vectors = false, int vector_size_in_bytes = 0);
 