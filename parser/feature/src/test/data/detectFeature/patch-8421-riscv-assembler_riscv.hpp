@@ -266,12 +266,32 @@ class InternalAddress: public Address {
 class Assembler : public AbstractAssembler {
 public:
 
-  enum { instruction_size = 4 };
+  enum {
+    instruction_size = 4,
+    compressed_instruction_size = 2,
+  };
+
+  // instruction must start at passed address
+  static bool is_compressed_instr(address instr) {
+    // The RISC-V ISA Manual, Section 'Base Instruction-Length Encoding':
+    // Instructions are stored in memory as a sequence of 16-bit little-endian parcels, regardless of
+    // memory system endianness. Parcels forming one instruction are stored at increasing halfword
+    // addresses, with the lowest-addressed parcel holding the lowest-numbered bits in the instruction
+    // specification.
+    if (UseRVC && (((uint16_t *)instr)[0] & 0b11) != 0b11) {
+      // 16-bit instructions have their lowest two bits equal to 0b00, 0b01, or 0b10
+      return true;
+    }
+    // 32-bit instructions have their lowest two bits set to 0b11
+    return false;
+  }
 
   //---<  calculate length of instruction  >---
   // We just use the values set above.
   // instruction must start at passed address
-  static unsigned int instr_len(unsigned char *instr) { return instruction_size; }
+  static unsigned int instr_len(address instr) {
+    return is_compressed_instr(instr) ? compressed_instruction_size : instruction_size;
+  }
 
   //---<  longest instructions  >---
   static unsigned int instr_maxlen() { return instruction_size; }