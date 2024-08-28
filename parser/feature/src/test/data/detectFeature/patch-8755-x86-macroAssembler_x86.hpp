@@ -674,10 +674,6 @@ class MacroAssembler: public Assembler {
   // prints msg and continues
   void warn(const char* msg);
 
-  void _assert_asm(Condition cc, const char* msg);
-#define assert_asm0(cc, msg) _assert_asm(cc, FILE_AND_LINE ": " msg)
-#define assert_asm(masm, command, cc, msg) DEBUG_ONLY((masm)->command; (masm)->_assert_asm(cc, FILE_AND_LINE ": " #command " " #cc ": " msg))
-
   // dumps registers and other state
   void print_state();
 