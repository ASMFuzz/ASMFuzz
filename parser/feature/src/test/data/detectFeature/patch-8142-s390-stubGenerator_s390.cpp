@@ -42,6 +42,7 @@
 #include "runtime/stubCodeGenerator.hpp"
 #include "runtime/stubRoutines.hpp"
 #include "runtime/thread.inline.hpp"
+#include "utilities/formatBuffer.hpp"
 #include "utilities/macros.hpp"
 #include "utilities/powerOfTwo.hpp"
 
@@ -55,9 +56,37 @@
 #define __ (Verbose ? (_masm->block_comment(FILE_AND_LINE),_masm):_masm)->
 #endif
 
-#define BLOCK_COMMENT(str) if (PrintAssembly) __ block_comment(str)
+#define BLOCK_COMMENT(str) if (PrintAssembly || PrintStubCode) __ block_comment(str)
 #define BIND(label)        bind(label); BLOCK_COMMENT(#label ":")
 
+// These static, partially const, variables are for the AES intrinsics.
+// They are declared/initialized here to make them available across function bodies.
+
+#if defined(JIT_TIMER)
+    static const int JIT_TIMER_space      = 8;                   // extra space for JIT_TIMER data
+#else
+    static const int JIT_TIMER_space      = 0;
+#endif
+    static const int AES_parmBlk_align    = 32;                  // octoword alignment.
+
+    static int AES_ctrVal_len  = 0;                              // ctr init value len (in bytes), expected: length of dataBlk (16)
+    static int AES_ctrVec_len  = 0;                              // # of ctr vector elements. That many block can be ciphered with one instruction execution
+    static int AES_ctrArea_len = 0;                              // reserved stack space (in bytes) for ctr (= ctrVal_len * ctrVec_len)
+
+    static int AES_parmBlk_addspace = 0;  // Must be multiple of AES_parmblk_align.
+                                          // Will be set by stub generator to stub specific value.
+    static int AES_dataBlk_space    = 0;  // Must be multiple of AES_parmblk_align.
+                                          // Will be set by stub generator to stub specific value.
+
+    static const int keylen_offset     =  -1;
+    static const int fCode_offset      =  -2;
+    static const int ctrVal_len_offset =  -4;
+    static const int msglen_offset     =  -8;
+    static const int unextSP_offset    = -16;
+    static const int remmsg_len_offset = -20;
+    static const int argsave_offset    = -2*AES_parmBlk_align;
+    static const int localSpill_offset = argsave_offset + 24;  // arg2..arg4 are saved
+
 // -----------------------------------------------------------------------
 // Stub Code definitions
 
@@ -1542,7 +1571,7 @@ class StubGenerator: public StubCodeGenerator {
   //   |        |
   //   +--------+ <-- SP before expansion
   //   |        |
-  //   :        :  alignment loss, 0..(AES_parmBlk_align-8) bytes
+  //   :        :  alignment loss (part 2), 0..(AES_parmBlk_align-1) bytes
   //   |        |
   //   +--------+
   //   |        |
@@ -1552,14 +1581,17 @@ class StubGenerator: public StubCodeGenerator {
   //   |        |
   //   :        :  additional stack space for spills etc., size AES_parmBlk_addspace, DW @ Z_SP not usable!!!
   //   |        |
+  //   +--------+ <-- Z_SP + alignment loss, octoword-aligned
+  //   |        |
+  //   :        :  alignment loss (part 1), 0..(AES_parmBlk_align-1) bytes. DW @ Z_SP not usable!!!
+  //   |        |
   //   +--------+ <-- Z_SP after expansion
 
   void generate_push_Block(int dataBlk_len, int parmBlk_len, int crypto_fCode,
                            Register parmBlk, Register keylen, Register fCode, Register cv, Register key) {
-    const int AES_parmBlk_align    = 32;  // octoword alignment.
-    const int AES_parmBlk_addspace = 24;  // Must be sufficiently large to hold all spilled registers
-                                          // (currently 2) PLUS 1 DW for the frame pointer.
 
+    AES_parmBlk_addspace = AES_parmBlk_align; // Must be multiple of AES_parmblk_align.
+                                              // spill space for regs etc., don't use DW @SP!
     const int cv_len     = dataBlk_len;
     const int key_len    = parmBlk_len - cv_len;
     // This len must be known at JIT compile time. Only then are we able to recalc the SP before resize.
@@ -1597,7 +1629,11 @@ class StubGenerator: public StubCodeGenerator {
     Label     parmBlk_128, parmBlk_192, parmBlk_256, parmBlk_set;
 
     BLOCK_COMMENT("push parmBlk {");
-    if (VM_Version::has_Crypto_AES()   ) { __ z_cghi(keylen, 52); }
+    // We have just three cipher strengths which translates into three
+    // possible extended key lengths: 44, 52, and 60 bytes.
+    // We therefore can compare the actual length against the "middle" length
+    // and get: lt -> len=44, eq -> len=52, gt -> len=60.
+    __ z_cghi(keylen, 52);
     if (VM_Version::has_Crypto_AES128()) { __ z_brl(parmBlk_128); }  // keyLen <  52: AES128
     if (VM_Version::has_Crypto_AES192()) { __ z_bre(parmBlk_192); }  // keyLen == 52: AES192
     if (VM_Version::has_Crypto_AES256()) { __ z_brh(parmBlk_256); }  // keyLen >  52: AES256
@@ -1811,7 +1847,7 @@ class StubGenerator: public StubCodeGenerator {
     return __ addr_at(start_off);
   }
 
-  // Compute chained AES encrypt function.
+  // Compute chained AES decrypt function.
   address generate_cipherBlockChaining_AES_decrypt(const char* name) {
     __ align(CodeEntryAlignment);
     StubCodeMark mark(this, "StubRoutines", name);
@@ -1822,6 +1858,562 @@ class StubGenerator: public StubCodeGenerator {
     return __ addr_at(start_off);
   }
 
+// *****************************************************************************
+
+  // AES CounterMode
+  // Push a parameter block for the cipher/decipher instruction on the stack.
+  // Layout of the additional stack space allocated for counterMode_AES_cipherBlock
+  //
+  //   |        |
+  //   +--------+ <-- SP before expansion
+  //   |        | JIT_TIMER timestamp buffer, only if JIT_TIMER is defined.
+  //   +--------+
+  //   |        |
+  //   :        :  alignment loss (part 2), 0..(AES_parmBlk_align-1) bytes.
+  //   |        |
+  //   +--------+ <-- gap = parmBlk + parmBlk_len + ctrArea_len
+  //   |        |
+  //   :        :  byte[] ctr - kmctr expects a counter vector the size of the input vector.
+  //   :        :         The interface only provides byte[16] iv, the init vector.
+  //   :        :         The size of this area is a tradeoff between stack space, init effort, and speed.
+  //   |        |         Each counter is a 128bit int. Vector element i is formed by incrementing element (i-1).
+  //   +--------+ <-- ctr = parmBlk + parmBlk_len
+  //   |        |
+  //   :        :  space for parameter block, size VM_Version::Cipher::_AES*_parmBlk_G
+  //   |        |
+  //   +--------+ <-- parmBlk = Z_SP + (alignment loss (part 1+2)) + AES_dataBlk_space + AES_parmBlk_addSpace, octoword-aligned, start of parameter block
+  //   |        |
+  //   :        :  additional stack space for spills etc., min. size AES_parmBlk_addspace, all bytes usable.
+  //   |        |
+  //   +--------+ <-- Z_SP + alignment loss (part 1+2) + AES_dataBlk_space, octoword-aligned
+  //   |        |
+  //   :        :  space for one source data block and one dest data block.
+  //   |        |
+  //   +--------+ <-- Z_SP + alignment loss (part 1+2), octoword-aligned
+  //   |        |
+  //   :        :  additional alignment loss. Blocks above can't tolerate unusable DW @SP.
+  //   |        |
+  //   +--------+ <-- Z_SP + alignment loss (part 1), octoword-aligned
+  //   |        |
+  //   :        :  alignment loss (part 1), 0..(AES_parmBlk_align-1) bytes. DW @ Z_SP holds frame ptr.
+  //   |        |
+  //   +--------+ <-- Z_SP after expansion
+  //
+  //   additional space allocation (per DW):
+  //    spillSpace = parmBlk - AES_parmBlk_addspace
+  //    dataBlocks = spillSpace - AES_dataBlk_space
+  //
+  //    parmBlk-8  various fields of various lengths
+  //               parmBlk-1: key_len (only one byte is stored at parmBlk-1)
+  //               parmBlk-2: fCode (only one byte is stored at parmBlk-2)
+  //               parmBlk-4: ctrVal_len (as retrieved from iv array), in bytes, as HW
+  //               parmBlk-8: msglen length (in bytes) of crypto msg, as passed in by caller
+  //                          return value is calculated from this: rv = msglen - processed.
+  //    parmBlk-16 old_SP (SP before resize)
+  //    parmBlk-24 temp values
+  //                up to and including main loop in generate_counterMode_AES
+  //                 - parmBlk-20: remmsg_len remaining msg len (aka unprocessed msg bytes)
+  //                after main loop in generate_counterMode_AES
+  //                 - parmBlk-24: spill slot for various address values
+  //
+  //    parmBlk-40 free spill slot, used for local spills.
+  //    parmBlk-64 ARG2(dst) ptr spill slot
+  //    parmBlk-56 ARG3(crypto key) ptr spill slot
+  //    parmBlk-48 ARG4(counter value) ptr spill slot
+  //
+  //
+  // Layout of the parameter block (instruction KMCTR, function KMCTR-AES*
+  //
+  //   +--------+ key_len: +16 (AES-128), +24 (AES-192), +32 (AES-256)
+  //   |        |
+  //   |        |  cryptographic key
+  //   |        |
+  //   +--------+ <-- parmBlk
+  //
+  // On exit:
+  //   Z_SP     points to resized frame
+  //            Z_SP before resize available from -16(parmBlk)
+  //   parmBlk  points to crypto instruction parameter block
+  //            parameter block is filled with crypto key.
+  //   msglen   unchanged, saved for later at -24(parmBlk)
+  //   fCode    contains function code for instruction
+  //   key      unchanged
+  //
+  void generate_counterMode_prepare_Stack(Register parmBlk, Register ctr, Register counter, Register scratch) {
+
+    BLOCK_COMMENT("prepare stack counterMode_AESCrypt {");
+
+    // save argument registers.
+    //   ARG1(from) is Z_RET as well. Not saved or restored.
+    //   ARG5(msglen) is restored by other means.
+    __ z_stmg(Z_ARG2, Z_ARG4, argsave_offset,    parmBlk);
+
+    assert(AES_ctrVec_len > 0, "sanity. We need a counter vector");
+    __ add2reg(counter, AES_parmBlk_align, parmBlk);       // counter array is located behind crypto key. Available range is disp12 only.
+    __ z_mvc(0, AES_ctrVal_len-1, counter, 0, ctr);        // move first copy of iv
+    for (int j = 1; j < AES_ctrVec_len; j+=j) {            // j (and amount of moved data) doubles with every iteration
+      int offset = j * AES_ctrVal_len;
+      if (offset <= 256) {
+        __ z_mvc(offset, offset-1, counter, 0, counter);   // move iv
+      } else {
+        for (int k = 0; k < offset; k += 256) {
+          __ z_mvc(offset+k, 255, counter, 0, counter);
+        }
+      }
+    }
+
+    Label noCarry, done;
+    __ z_lg(scratch, Address(ctr, 8));                     // get low-order DW of initial counter.
+    __ z_algfi(scratch, AES_ctrVec_len);                   // check if we will overflow during init.
+    __ z_brc(Assembler::bcondLogNoCarry, noCarry);         // No, 64-bit increment is sufficient.
+
+    for (int j = 1; j < AES_ctrVec_len; j++) {             // start with j = 1; no need to add 0 to the first counter value.
+      int offset = j * AES_ctrVal_len;
+      generate_increment128(counter, offset, j, scratch);  // increment iv by index value
+    }
+    __ z_bru(done);
+
+    __ bind(noCarry);
+    for (int j = 1; j < AES_ctrVec_len; j++) {             // start with j = 1; no need to add 0 to the first counter value.
+      int offset = j * AES_ctrVal_len;
+      generate_increment64(counter, offset, j);            // increment iv by index value
+    }
+
+    __ bind(done);
+
+    BLOCK_COMMENT("} prepare stack counterMode_AESCrypt");
+  }
+
+
+  void generate_counterMode_increment_ctrVector(Register parmBlk, Register counter, Register scratch, bool v0_only) {
+
+    BLOCK_COMMENT("increment ctrVector counterMode_AESCrypt {");
+
+    __ add2reg(counter, AES_parmBlk_align, parmBlk);       // ptr to counter array needs to be restored
+    for (int j = 0; j < AES_ctrVec_len; j++) {
+      int offset = j * AES_ctrVal_len;
+      generate_increment128(counter, offset, AES_ctrVec_len, scratch); // increment iv by # vector elements
+      if (v0_only) break;
+    }
+
+    BLOCK_COMMENT("} increment ctrVector counterMode_AESCrypt");
+  }
+
+  // IBM s390 (IBM z/Architecture, to be more exact) uses Big-Endian number representation.
+  // Therefore, the bits are ordered from most significant to least significant. The address
+  // of a number in memory points to its lowest location where the most significant bit is stored.
+  void generate_increment64(Register counter, int offset, int increment) {
+    __ z_algsi(offset + 8, counter, increment);            // increment, no overflow check
+  }
+
+  void generate_increment128(Register counter, int offset, int increment, Register scratch) {
+    __ clear_reg(scratch);                                 // prepare to add carry to high-order DW
+    __ z_algsi(offset + 8, counter, increment);            // increment low order DW
+    __ z_alcg(scratch, Address(counter, offset));          // add carry to high-order DW
+    __ z_stg(scratch, Address(counter, offset));           // store back
+  }
+
+  void generate_counterMode_push_Block(int dataBlk_len, int parmBlk_len, int crypto_fCode,
+                           Register parmBlk, Register msglen, Register fCode, Register key) {
+
+    // space for data blocks (src and dst, one each) for partial block processing)
+    AES_dataBlk_space    = roundup(2*dataBlk_len, AES_parmBlk_align);
+    AES_parmBlk_addspace = AES_parmBlk_align    // spill space (temp data)
+                         + AES_parmBlk_align    // for argument save/restore
+                         ;
+    const int key_len    = parmBlk_len;         // The length of the unextended key (16, 24, 32)
+
+    assert((AES_ctrVal_len == 0) || (AES_ctrVal_len == dataBlk_len), "varying dataBlk_len is not supported.");
+    AES_ctrVal_len  = dataBlk_len;               // ctr init value len (in bytes)
+    AES_ctrArea_len = AES_ctrVec_len * AES_ctrVal_len; // space required on stack for ctr vector
+
+    // This len must be known at JIT compile time. Only then are we able to recalc the SP before resize.
+    // We buy this knowledge by wasting some (up to AES_parmBlk_align) bytes of stack space.
+    const int resize_len = JIT_TIMER_space       // timestamp storage for JIT_TIMER
+                         + AES_parmBlk_align     // room for alignment of parmBlk
+                         + AES_parmBlk_align     // extra room for alignment
+                         + AES_dataBlk_space     // one src and one dst data blk
+                         + AES_parmBlk_addspace  // spill space for local data
+                         + roundup(parmBlk_len, AES_parmBlk_align)  // aligned length of parmBlk
+                         + AES_ctrArea_len       // stack space for ctr vector
+                         ;
+    Register scratch     = fCode;  // We can use fCode as a scratch register. It's contents on entry
+                                   // is irrelevant and it is set at the very end of this code block.
+
+    assert(key_len < 256, "excessive crypto key len: %d, limit: 256", key_len);
+
+    BLOCK_COMMENT(err_msg("push_Block (%d bytes) counterMode_AESCrypt%d {", resize_len, parmBlk_len*8));
+
+    // After the frame is resized, the parmBlk is positioned such
+    // that it is octoword-aligned. This potentially creates some
+    // alignment waste in addspace and/or in the gap area.
+    // After resize_frame, scratch contains the frame pointer.
+    __ resize_frame(-resize_len, scratch, true);
+
+    // calculate aligned parmBlk address from updated (resized) SP.
+    __ add2reg(parmBlk, AES_parmBlk_addspace + (AES_parmBlk_align-1), Z_SP);
+    __ z_nill(parmBlk, (~(AES_parmBlk_align-1)) & 0xffff); // Align parameter block.
+
+    // There is room to spill stuff in the range [parmBlk-AES_parmBlk_addspace+8, parmBlk).
+    __ z_mviy(keylen_offset, parmBlk, key_len - 1);        // Spill crypto key length for later use. Decrement by one for direct use with xc template.
+    __ z_mviy(fCode_offset,  parmBlk, crypto_fCode);       // Crypto function code, will be loaded into Z_R0 later.
+    __ z_sty(msglen, msglen_offset, parmBlk);              // full plaintext/ciphertext len.
+    __ z_sra(msglen, exact_log2(dataBlk_len));             // # full cipher blocks that can be formed from input text.
+    __ z_sty(msglen, remmsg_len_offset, parmBlk);
+
+    __ add2reg(scratch, resize_len, Z_SP);                 // calculate (SP before resize) from resized SP.
+    __ z_stg(scratch, unextSP_offset, parmBlk);            // Spill unextended SP for easy revert.
+
+    // Fill parmBlk with all required data
+    __ z_mvc(0, key_len-1, parmBlk, 0, key);               // Copy key. Need to do it here - key_len is only known here.
+    BLOCK_COMMENT(err_msg("} push_Block (%d bytes) counterMode_AESCrypt%d", resize_len, parmBlk_len*8));
+  }
+
+
+  void generate_counterMode_pop_Block(Register parmBlk, Register msglen, Label& eraser) {
+    // For added safety, clear the stack area where the crypto key was stored.
+    Register scratch = msglen;
+    assert_different_registers(scratch, Z_R0);            // can't use Z_R0 for exrl.
+
+    // wipe out key on stack
+    __ z_llgc(scratch, keylen_offset, parmBlk);           // get saved (key_len-1) value (we saved just one byte!)
+    __ z_exrl(scratch, eraser);                           // template relies on parmBlk still pointing to key on stack
+
+    // restore argument registers.
+    //   ARG1(from) is Z_RET as well. Not restored - will hold return value anyway.
+    //   ARG5(msglen) is restored further down.
+    __ z_lmg(Z_ARG2, Z_ARG4, argsave_offset,    parmBlk);
+
+    __ z_lgf(msglen, msglen_offset,  parmBlk);            // Restore msglen, only low order FW is valid
+    __ z_lg(Z_SP,    unextSP_offset, parmBlk);            // trim stack back to unextended size
+  }
+
+
+  void generate_counterMode_push_parmBlk(Register parmBlk, Register msglen, Register fCode, Register key, bool is_decipher) {
+    int       mode = is_decipher ? VM_Version::CipherMode::decipher : VM_Version::CipherMode::cipher;
+    Label     parmBlk_128, parmBlk_192, parmBlk_256, parmBlk_set;
+    Register  keylen = fCode;      // Expanded key length, as read from key array, Temp only.
+                                   // use fCode as scratch; fCode receives its final value later.
+
+    // Read key len of expanded key (in 4-byte words).
+    __ z_lgf(keylen, Address(key, arrayOopDesc::length_offset_in_bytes() - arrayOopDesc::base_offset_in_bytes(T_INT)));
+    __ z_cghi(keylen, 52);
+    if (VM_Version::has_Crypto_AES_CTR256()) { __ z_brh(parmBlk_256); }  // keyLen >  52: AES256. Assume: most frequent
+    if (VM_Version::has_Crypto_AES_CTR128()) { __ z_brl(parmBlk_128); }  // keyLen <  52: AES128.
+    if (VM_Version::has_Crypto_AES_CTR192()) { __ z_bre(parmBlk_192); }  // keyLen == 52: AES192. Assume: least frequent
+
+    // Safety net: requested AES_CTR function for requested keylen not available on this CPU.
+    __ stop_static("AES key strength not supported by CPU. Use -XX:-UseAESCTRIntrinsics as remedy.", 0);
+
+    if (VM_Version::has_Crypto_AES_CTR128()) {
+      __ bind(parmBlk_128);
+      generate_counterMode_push_Block(VM_Version::Cipher::_AES128_dataBlk,
+                          VM_Version::Cipher::_AES128_parmBlk_G,
+                          VM_Version::Cipher::_AES128 + mode,
+                          parmBlk, msglen, fCode, key);
+      if (VM_Version::has_Crypto_AES_CTR256() || VM_Version::has_Crypto_AES_CTR192()) {
+        __ z_bru(parmBlk_set);  // Fallthru otherwise.
+      }
+    }
+
+    if (VM_Version::has_Crypto_AES_CTR192()) {
+      __ bind(parmBlk_192);
+      generate_counterMode_push_Block(VM_Version::Cipher::_AES192_dataBlk,
+                          VM_Version::Cipher::_AES192_parmBlk_G,
+                          VM_Version::Cipher::_AES192 + mode,
+                          parmBlk, msglen, fCode, key);
+      if (VM_Version::has_Crypto_AES_CTR256()) {
+        __ z_bru(parmBlk_set);  // Fallthru otherwise.
+      }
+    }
+
+    if (VM_Version::has_Crypto_AES_CTR256()) {
+      __ bind(parmBlk_256);
+      generate_counterMode_push_Block(VM_Version::Cipher::_AES256_dataBlk,
+                          VM_Version::Cipher::_AES256_parmBlk_G,
+                          VM_Version::Cipher::_AES256 + mode,
+                          parmBlk, msglen, fCode, key);
+      // Fallthru
+    }
+
+    __ bind(parmBlk_set);
+  }
+
+
+  void generate_counterMode_pop_parmBlk(Register parmBlk, Register msglen, Label& eraser) {
+
+    BLOCK_COMMENT("pop parmBlk counterMode_AESCrypt {");
+
+    generate_counterMode_pop_Block(parmBlk, msglen, eraser);
+
+    BLOCK_COMMENT("} pop parmBlk counterMode_AESCrypt");
+  }
+
+  // Resize current stack frame to make room for some register data which needs
+  // to be spilled temporarily. All registers in the range [from..to] are spilled
+  // automatically. The actual length of the allocated aux block is returned.
+  // The extra spill space (if requested) is located at
+  //   [Z_SP+stackSpace-spillSpace, Z_SP+stackSpace)
+  // Kills Z__R0 (contains fp afterwards) and Z_R1 (contains old SP afterwards).
+  // All space in the range [SP..SP+regSpace) is reserved.
+  // As always (here): 0(SP) - stack linkage, 8(SP) - SP before resize for easy pop.
+  int generate_push_aux_block(Register from, Register to, unsigned int spillSpace) {
+    int n_regs     = to->encoding() - from->encoding() + 1;
+    int linkSpace  = 2*wordSize;
+    int regSpace   = n_regs*wordSize;
+    int stackSpace = roundup(linkSpace + regSpace + spillSpace, AES_parmBlk_align);
+    BLOCK_COMMENT(err_msg("push aux_block (%d bytes) counterMode_AESCrypt {", stackSpace));
+    __ z_lgr(Z_R1, Z_SP);
+    __ resize_frame(-stackSpace, Z_R0, true);
+    __ z_stg(Z_R1, 8, Z_SP);
+    __ z_stmg(from, to, linkSpace, Z_SP);
+    BLOCK_COMMENT(err_msg("} push aux_block (%d bytes) counterMode_AESCrypt", stackSpace));
+    return stackSpace;
+  }
+  // Reverts everything done by generate_push_aux_block().
+  void generate_pop_aux_block(Register from, Register to) {
+    BLOCK_COMMENT("pop aux_block counterMode_AESCrypt {");
+    __ z_lmg(from, to, 16, Z_SP);
+    __ z_lg(Z_SP, 8, Z_SP);
+    BLOCK_COMMENT("} pop aux_block counterMode_AESCrypt");
+  }
+
+  // Implementation of counter-mode AES encrypt/decrypt function.
+  //
+  void generate_counterMode_AES_impl(bool is_decipher) {
+
+    Register       from    = Z_ARG1; // byte[], source byte array (clear text)
+    Register       to      = Z_ARG2; // byte[], destination byte array (ciphered)
+    Register       key     = Z_ARG3; // byte[], expanded key array.
+    Register       ctr     = Z_ARG4; // byte[], counter byte array.
+    const Register msglen  = Z_ARG5; // int, Total length of the msg to be encrypted. Value must be
+                                     // returned in Z_RET upon completion of this stub.
+                                     // This is a jint. Negative values are illegal, but technically possible.
+                                     // Do not rely on high word. Contents is undefined.
+
+    const Register fCode   = Z_R0;   // crypto function code
+    const Register parmBlk = Z_R1;   // parameter block address (points to crypto key)
+    const Register src     = Z_ARG1; // is Z_R2
+    const Register srclen  = Z_ARG2; // Overwrites destination address.
+    const Register dst     = Z_ARG3; // Overwrites key address.
+    const Register counter = Z_ARG5; // Overwrites msglen. Must have counter array in an even register.
+
+    Label srcMover, dstMover, fromMover, ctrXOR, dataEraser;  // EXRL (execution) templates.
+    Label CryptoLoop, CryptoLoop_doit, CryptoLoop_end, CryptoLoop_setupAndDoLast, CryptoLoop_ctrVal_inc, allDone, Exit;
+
+    // Check if there is a leftover, partially used encrypted counter from last invocation.
+    // If so, use those leftover counter bytes first before starting the "normal" encryption.
+    {
+      Register cvIndex   = Z_R10;  // # unused bytes of last encrypted counter value
+      Register cvUnused  = Z_R11;  // # unused bytes of last encrypted counter value
+      Register encCtr    = Z_R12;  // encrypted counter value, points to first ununsed byte.
+      Label no_preLoop, preLoop_end;
+
+      // Before pushing an aux block, check if it's necessary at all (saves some cycles).
+      __ z_lt(Z_R0, _z_abi(remaining_cargs) + 8 + 4, Z_R0, Z_SP); // arg7: # unused bytes in encCTR.
+      __ z_brnp(no_preLoop);                                      // no unused bytes, nothing special to do.
+
+      int   oldSP_Offset  = generate_push_aux_block(Z_R10, Z_R12, 16);
+      int   arg6_Offset   = oldSP_Offset + _z_abi(remaining_cargs);
+      int   arg7_Offset   = oldSP_Offset + _z_abi(remaining_cargs) + 8;
+
+      __ z_ltgf(cvUnused, arg7_Offset+4, Z_R0, Z_SP); // arg7: # unused bytes in encCTR. (16-arg7) is index of first unused byte.
+      __ z_brnp(preLoop_end);                  // "not positive" means no unused bytes left
+      __ z_aghik(cvIndex, cvUnused, -16);      // calculate index of first unused byte. AES_ctrVal_len undefined at this point.
+      __ z_brnl(preLoop_end);                  // NotLow(=NotNegative): unused bytes >= 16? How that?
+      __ z_lcgr(cvIndex, cvIndex);
+
+      __ z_lg(encCtr, arg6_Offset, Z_SP);      // arg6: encrypted counter byte array.
+      __ z_agr(encCtr, cvIndex);               // first unused byte of encrypted ctr. Used in ctrXOR.
+
+      __ z_cr(cvUnused, msglen);               // check if msg is long enough
+      __ z_locr(cvUnused, msglen, Assembler::bcondHigh); // take the shorter length
+
+      __ z_aghi(cvUnused, -1);                 // decrement # unused bytes by 1 for exrl instruction
+      __ z_brl(preLoop_end);                   // negative result means nothing to do (msglen is zero)
+
+      __ z_exrl(cvUnused, fromMover);
+      __ z_exrl(cvUnused, ctrXOR);
+
+      __ add2reg(cvUnused, 1, cvUnused);
+      __ z_agr(from, cvUnused);
+      __ z_agr(to, cvUnused);
+      __ z_sr(msglen, cvUnused);
+      __ z_brnz(preLoop_end);                  // there is still work to do
+
+      // Remaining msglen is zero, i.e. all msg bytes were processed in preLoop.
+      // Take an early exit.
+      generate_pop_aux_block(Z_R10, Z_R12);
+      __ z_bru(Exit);
+
+      //-------------------------------------------
+      //---<  execution templates for preLoop  >---
+      //-------------------------------------------
+      __ bind(fromMover);
+      __ z_mvc(0, 0, to, 0, from);         // Template instruction to move input data to dst.
+      __ bind(ctrXOR);
+      __ z_xc(0,  0, to, 0, encCtr);       // Template instruction to XOR input data (now in to) with encrypted counter.
+
+      __ bind(preLoop_end);
+      generate_pop_aux_block(Z_R10, Z_R12);
+
+      __ bind(no_preLoop);
+    }
+
+    // Expand stack, load parm block address into parmBlk (== Z_R1), copy crypto key to parm block.
+    generate_counterMode_push_parmBlk(parmBlk, msglen, fCode, key, is_decipher);
+    // Create count vector on stack to accommodate up to AES_ctrVec_len blocks.
+    generate_counterMode_prepare_Stack(parmBlk, ctr, counter, fCode);
+
+    // Prepare other registers for instruction.
+    __ lgr_if_needed(src, from);     // Copy src address. Will not emit, src/from are identical.
+    __ z_lgr(dst, to);
+    __ z_llgc(fCode, fCode_offset, Z_R0, parmBlk);
+
+    __ bind(CryptoLoop);
+      __ z_lghi(srclen, AES_ctrArea_len);                     // preset len (#bytes) for next iteration: max possible.
+      __ z_asi(remmsg_len_offset, parmBlk, -AES_ctrVec_len);  // decrement #remaining blocks (16 bytes each). Range: [+127..-128]
+      __ z_brl(CryptoLoop_setupAndDoLast);                    // Handling the last iteration out-of-line
+
+      __ bind(CryptoLoop_doit);
+      __ kmctr(dst, counter, src);   // Cipher the message.
+
+      __ z_lt(srclen, remmsg_len_offset, Z_R0, parmBlk);      // check if this was the last iteration
+      __ z_brz(CryptoLoop_ctrVal_inc);                        // == 0: ctrVector fully used. Need to increment the first
+                                                              //       vector element to encrypt remaining unprocessed bytes.
+//    __ z_brl(CryptoLoop_end);                               //  < 0: this was detected before and handled at CryptoLoop_setupAndDoLast
+
+      generate_counterMode_increment_ctrVector(parmBlk, counter, srclen, false); // srclen unused here (serves as scratch)
+      __ z_bru(CryptoLoop);
+
+    __ bind(CryptoLoop_end);
+
+    // OK, when we arrive here, we have encrypted all of the "from" byte stream
+    // except for the last few [0..dataBlk_len) bytes. To encrypt these few bytes
+    // we need to form an extra src and dst data block of dataBlk_len each. This
+    // is because we can only process full blocks but we must not read or write
+    // beyond the boundaries of the argument arrays. Here is what we do:
+    //  - The src data block is filled with the remaining "from" bytes, padded with 0x00's.
+    //  - The single src data block is encrypted into the dst data block.
+    //  - The dst data block is copied into the "to" array, but only the leftmost few bytes
+    //    (as many as were left in the source byte stream).
+    //  - The counter value to be used is is pointed at by the counter register.
+    //  - Fortunately, the crypto instruction (kmctr) updates all related addresses such that we
+    //    know where to continue with "from" and "to" and which counter value to use next.
+
+    // Use speaking alias for temp register
+    Register dataBlk = counter;
+    __ z_stg(counter, -24, parmBlk);                      // spill address of counter array
+    __ add2reg(dataBlk, -(AES_parmBlk_addspace + AES_dataBlk_space), parmBlk);
+
+    __ z_lgf(srclen, msglen_offset, parmBlk);             // full plaintext/ciphertext len.
+    __ z_nilf(srclen, AES_ctrVal_len - 1);                // those rightmost bits indicate the unprocessed #bytes
+    __ z_braz(allDone);                                   // no unprocessed bytes? Then we are done.
+
+    __ add2reg(srclen, -1);                               // decrement for exrl
+    __ z_stg(srclen, localSpill_offset, parmBlk);         // save for later reuse
+    __ z_xc(0, AES_ctrVal_len - 1, dataBlk, 0, dataBlk);  // clear src block (zero padding)
+    __ z_exrl(srclen, srcMover);                          // copy src byte stream (remaining bytes)
+    __ load_const_optimized(srclen, AES_ctrVal_len);      // kmctr processes only complete blocks
+
+    __ z_lgr(src, dataBlk);                               // tmp src address for kmctr
+    __ z_lg(counter, -24, parmBlk);                       // restore counter
+    __ z_stg(dst, -24, parmBlk);                          // save current dst
+    __ add2reg(dst, AES_ctrVal_len, src);                 // tmp dst is right after tmp src
+
+    __ kmctr(dst, counter, src);   // Cipher the remaining bytes.
+
+    __ add2reg(dataBlk, -AES_ctrVal_len, dst);            // tmp dst address
+    __ z_lg(dst, -24, parmBlk);                           // real dst address
+    __ z_lg(srclen, localSpill_offset, parmBlk);          // reuse calc from above
+    __ z_exrl(srclen, dstMover);
+
+    __ bind(allDone);
+    __ z_llgf(srclen, msglen_offset, parmBlk);            // increment unencrypted ctr by #blocks processed.
+    __ z_srag(srclen, srclen, exact_log2(AES_ctrVal_len));
+    __ z_ag(srclen, 8, Z_R0, ctr);
+    __ z_stg(srclen, 8, Z_R0, ctr);
+    generate_counterMode_pop_parmBlk(parmBlk, msglen, dataEraser);
+
+    __ bind(Exit);
+    __ z_lgfr(Z_RET, msglen);
+
+    __ z_br(Z_R14);
+
+    //----------------------------
+    //---<  out-of-line code  >---
+    //----------------------------
+    __ bind(CryptoLoop_setupAndDoLast);
+      __ z_lgf(srclen, remmsg_len_offset, parmBlk);           // remaining #blocks in memory is < 0
+      __ z_aghi(srclen, AES_ctrVec_len);                      // recalculate the actually remaining #blocks
+      __ z_sllg(srclen, srclen, exact_log2(AES_ctrVal_len));  // convert to #bytes. Counter value is same length as data block
+      __ kmctr(dst, counter, src);                            // Cipher the last integral blocks of the message.
+      __ z_bru(CryptoLoop_end);
+
+    __ bind(CryptoLoop_ctrVal_inc);
+      generate_counterMode_increment_ctrVector(parmBlk, counter, srclen, true); // srclen unused here (serves as scratch)
+      __ z_bru(CryptoLoop_end);
+
+    //-------------------------------
+    //---<  execution templates  >---
+    //-------------------------------
+    __ bind(dataEraser);
+    __ z_xc(0, 0, parmBlk, 0, parmBlk);  // Template instruction to erase crypto key on stack.
+    __ bind(dstMover);
+    __ z_mvc(0, 0, dst, 0, dataBlk);     // Template instruction to move encrypted reminder from stack to dst.
+    __ bind(srcMover);
+    __ z_mvc(0, 0, dataBlk, 0, src);     // Template instruction to move reminder of source byte stream to stack.
+  }
+
+
+  // Create two intrinsic variants, optimized for short and long plaintexts.
+  //
+  void generate_counterMode_AES(bool is_decipher) {
+
+    const Register msglen  = Z_ARG5;    // int, Total length of the msg to be encrypted. Value must be
+                                        // returned in Z_RET upon completion of this stub.
+    const int threshold = 256;          // above this length (in bytes), text is considered long.
+    const int vec_short = threshold>>6; // that many blocks (16 bytes each) per iteration, max 4 loop iterations
+    const int vec_long  = threshold>>2; // that many blocks (16 bytes each) per iteration.
+
+    Label AESCTR_short, AESCTR_long;
+
+    __ z_chi(msglen, threshold);
+    __ z_brh(AESCTR_long);
+
+    BLOCK_COMMENT(err_msg("counterMode_AESCrypt (text len <= %d, block size = %d) {", threshold, vec_short*16));
+
+    __ bind(AESCTR_short);
+    AES_ctrVec_len = vec_short;
+    generate_counterMode_AES_impl(false);   // control of generated code will not return
+
+    BLOCK_COMMENT(err_msg("} counterMode_AESCrypt (text len <= %d, block size = %d)", threshold, vec_short*16));
+
+    __ align(32); // Octoword alignment benefits branch targets.
+
+    BLOCK_COMMENT(err_msg("counterMode_AESCrypt (text len > %d, block size = %d) {", threshold, vec_long*16));
+
+    __ bind(AESCTR_long);
+    AES_ctrVec_len = vec_long;
+    generate_counterMode_AES_impl(false);   // control of generated code will not return
+
+    BLOCK_COMMENT(err_msg("} counterMode_AESCrypt (text len > %d, block size = %d)", threshold, vec_long*16));
+  }
+
+
+  // Compute AES-CTR crypto function.
+  // Encrypt or decrypt is selected via parameters. Only one stub is necessary.
+  address generate_counterMode_AESCrypt(const char* name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", name);
+    unsigned int   start_off = __ offset();  // Remember stub start address (is rtn value).
+
+    generate_counterMode_AES(false);
+
+    return __ addr_at(start_off);
+  }
+
+// *****************************************************************************
 
   // Compute GHASH function.
   address generate_ghash_processBlocks() {
@@ -2169,6 +2761,7 @@ class StubGenerator: public StubCodeGenerator {
     const Register t2      = Z_R12;   // work reg for kernel* emitters
     const Register t3      = Z_R13;   // work reg for kernel* emitters
 
+
     assert_different_registers(crc, data, dataLen, table);
 
     // We pass these values as ints, not as longs as required by C calling convention.
@@ -2321,10 +2914,26 @@ class StubGenerator: public StubCodeGenerator {
 
     // Generate AES intrinsics code.
     if (UseAESIntrinsics) {
-      StubRoutines::_aescrypt_encryptBlock = generate_AES_encryptBlock("AES_encryptBlock");
-      StubRoutines::_aescrypt_decryptBlock = generate_AES_decryptBlock("AES_decryptBlock");
-      StubRoutines::_cipherBlockChaining_encryptAESCrypt = generate_cipherBlockChaining_AES_encrypt("AES_encryptBlock_chaining");
-      StubRoutines::_cipherBlockChaining_decryptAESCrypt = generate_cipherBlockChaining_AES_decrypt("AES_decryptBlock_chaining");
+      if (VM_Version::has_Crypto_AES()) {
+        StubRoutines::_aescrypt_encryptBlock = generate_AES_encryptBlock("AES_encryptBlock");
+        StubRoutines::_aescrypt_decryptBlock = generate_AES_decryptBlock("AES_decryptBlock");
+        StubRoutines::_cipherBlockChaining_encryptAESCrypt = generate_cipherBlockChaining_AES_encrypt("AES_encryptBlock_chaining");
+        StubRoutines::_cipherBlockChaining_decryptAESCrypt = generate_cipherBlockChaining_AES_decrypt("AES_decryptBlock_chaining");
+      } else {
+        // In PRODUCT builds, the function pointers will keep their initial (NULL) value.
+        // LibraryCallKit::try_to_inline() will return false then, preventing the intrinsic to be called.
+        assert(VM_Version::has_Crypto_AES(), "Inconsistent settings. Check vm_version_s390.cpp");
+      }
+    }
+
+    if (UseAESCTRIntrinsics) {
+      if (VM_Version::has_Crypto_AES_CTR()) {
+        StubRoutines::_counterMode_AESCrypt = generate_counterMode_AESCrypt("counterMode_AESCrypt");
+      } else {
+        // In PRODUCT builds, the function pointers will keep their initial (NULL) value.
+        // LibraryCallKit::try_to_inline() will return false then, preventing the intrinsic to be called.
+        assert(VM_Version::has_Crypto_AES_CTR(), "Inconsistent settings. Check vm_version_s390.cpp");
+      }
     }
 
     // Generate GHASH intrinsics code