@@ -578,7 +578,7 @@ class StubGenerator: public StubCodeGenerator {
     __ bind(error);
     __ pop_reg(0x3000, sp);   // pop c_rarg2 and c_rarg3
 
-    __ pusha();
+    __ push_reg(0xffffffff, sp);
     // debug(char* msg, int64_t pc, int64_t regs[])
     __ mv(c_rarg0, t0);             // pass address of error message
     __ mv(c_rarg1, ra);             // pass return address