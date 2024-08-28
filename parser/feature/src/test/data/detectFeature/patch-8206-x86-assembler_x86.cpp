@@ -2235,6 +2235,13 @@ void Assembler::idivl(Register src) {
   emit_int16((unsigned char)0xF7, (0xF8 | encode));
 }
 
+void Assembler::idivl(Address src) {
+  InstructionMark im(this);
+  prefix(src);
+  emit_int8((unsigned char)0xF7);
+  emit_operand(as_Register(7), src);
+}
+
 void Assembler::divl(Register src) { // Unsigned
   int encode = prefix_and_encode(src->encoding());
   emit_int16((unsigned char)0xF7, (0xF0 | encode));
@@ -12366,6 +12373,13 @@ void Assembler::idivq(Register src) {
   emit_int16((unsigned char)0xF7, (0xF8 | encode));
 }
 
+void Assembler::idivq(Address src) {
+  InstructionMark im(this);
+  prefixq(src);
+  emit_int8((unsigned char)0xF7);
+  emit_operand(as_Register(7), src);
+}
+
 void Assembler::divq(Register src) {
   int encode = prefixq_and_encode(src->encoding());
   emit_int16((unsigned char)0xF7, (0xF0 | encode));