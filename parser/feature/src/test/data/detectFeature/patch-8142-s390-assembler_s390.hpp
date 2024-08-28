@@ -690,6 +690,8 @@ class Assembler : public AbstractAssembler {
 #define ALY_ZOPC    (unsigned long)(227L << 40 | 94L)
 #define ALGF_ZOPC   (unsigned long)(227L << 40 | 26L)
 #define ALG_ZOPC    (unsigned long)(227L << 40 | 10L)
+#define ALC_ZOPC    (unsigned long)(227L << 40 | 152L)
+#define ALCG_ZOPC   (unsigned long)(227L << 40 | 136L)
 // In-memory arithmetic (add signed, add logical with signed immediate).
 // MI, Logical
 #define ALSI_ZOPC   (unsigned long)(0xebL << 40 | 0x6eL)
@@ -1449,7 +1451,8 @@ class Assembler : public AbstractAssembler {
     bcondLogNotZero_Borrow   =  4,
     bcondLogNotZero_NoBorrow =  1,
     bcondLogNotZero          =  bcondLogNotZero_Carry | bcondLogNotZero_NoCarry,
-    bcondLogCarry            =  bcondLogZero_Carry | bcondLogNotZero_Carry,
+    bcondLogCarry            =  bcondLogZero_Carry    | bcondLogNotZero_Carry,
+    bcondLogNoCarry          =  bcondLogZero_NoCarry  | bcondLogNotZero_NoCarry,
     bcondLogBorrow           =  /* bcondLogZero_Borrow | */ bcondLogNotZero_Borrow,
     // Vector compare instructions
     bcondVAlltrue    =  8,  // All  vector elements evaluate true
@@ -2126,6 +2129,8 @@ class Assembler : public AbstractAssembler {
   inline void z_aly( Register r1, int64_t d2, Register x2, Register b2);// add r1 = r1 + *(d2_imm20+x2+b2)  ; int32
   inline void z_alg( Register r1, int64_t d2, Register x2, Register b2);// add r1 = r1 + *(d2_imm20+x2+b2)  ; int64
   inline void z_algf(Register r1, int64_t d2, Register x2, Register b2);// add r1 = r1 + *(d2_imm20+x2+b2)  ; int64 <- int32
+  inline void z_alc( Register r1, int64_t d2, Register x2, Register b2);// add r1 = r1 + *(d2_imm20+x2+b2) + c ; int32
+  inline void z_alcg(Register r1, int64_t d2, Register x2, Register b2);// add r1 = r1 + *(d2_imm20+x2+b2) + c ; int64
   inline void z_a(   Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int32
   inline void z_ay(  Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int32
   inline void z_al(  Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int32
@@ -2134,6 +2139,8 @@ class Assembler : public AbstractAssembler {
   inline void z_agf( Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int64 <- int32
   inline void z_alg( Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int64
   inline void z_algf(Register r1, const Address& a);                  // add r1 = r1 + *(a)               ; int64 <- int32
+  inline void z_alc( Register r1, const Address& a);                  // add r1 = r1 + *(a) + c          ; int32
+  inline void z_alcg(Register r1, const Address& a);                  // add r1 = r1 + *(a) + c          ; int64
 
 
   inline void z_alhsik( Register r1, Register r3, int64_t i2);    // add logical r1 = r3 + i2_imm16   ; int32