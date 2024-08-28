@@ -453,7 +453,7 @@ class StubGenerator: public StubCodeGenerator {
   // NOTE: At entry of this stub, exception-pc must be in LR !!
 
   // NOTE: this is always used as a jump target within generated code
-  // so it just needs to be generated code wiht no x86 prolog
+  // so it just needs to be generated code with no x86 prolog
 
   address generate_forward_exception() {
     StubCodeMark mark(this, "StubRoutines", "forward exception");
@@ -859,7 +859,7 @@ class StubGenerator: public StubCodeGenerator {
       // or -1.
       //
       // when forward copying we need to store 1 word, 3 pairs and
-      // then 1 word at offsets {0, 1, 3, 5, 7}. Rather thna use a
+      // then 1 word at offsets {0, 1, 3, 5, 7}. Rather than use a
       // zero offset We adjust the destination by -1 which means we
       // have to use offsets { 1, 2, 4, 6, 8} * unit for the stores.
       //
@@ -985,13 +985,13 @@ class StubGenerator: public StubCodeGenerator {
       }
       // now we need to copy any remaining part block which may
       // include a 4 word block subblock and/or a 2 word subblock.
-      // bits 2 and 1 in the count are the tell-tale for whetehr we
+      // bits 2 and 1 in the count are the tell-tale for whether we
       // have each such subblock
       {
         Label L1, L2;
         __ tbz(count, exact_log2(4), L1);
        // this is the same as above but copying only 4 longs hence
-       // with ony one intervening stp between the str instructions
+       // with only one intervening stp between the str instructions
        // but note that the offsets and registers still follow the
        // same pattern
         __ ldp(t0, t1, Address(s, 2 * unit));
@@ -4034,7 +4034,7 @@ class StubGenerator: public StubCodeGenerator {
    *   c_rarg1   - byte* buf
    *   c_rarg2   - int length
    *
-   * Ouput:
+   * Output:
    *       rax   - int crc result
    */
   address generate_updateBytesCRC32() {
@@ -4075,7 +4075,7 @@ class StubGenerator: public StubCodeGenerator {
    *   c_rarg2   - int length
    *   c_rarg3   - int* table
    *
-   * Ouput:
+   * Output:
    *       r0   - int crc result
    */
   address generate_updateBytesCRC32C() {
@@ -4336,7 +4336,7 @@ class StubGenerator: public StubCodeGenerator {
    *    c_rarg0   - x address
    *    c_rarg1   - x length
    *    c_rarg2   - y address
-   *    c_rarg3   - y lenth
+   *    c_rarg3   - y length
    *    c_rarg4   - z address
    *    c_rarg5   - z length
    */
@@ -5735,7 +5735,7 @@ class StubGenerator: public StubCodeGenerator {
     // everything big-endian or reverse the bits in each byte and do
     // it little-endian.  On AArch64 it's more idiomatic to reverse
     // the bits in each byte (we have an instruction, RBIT, to do
-    // that) and keep the data in little-endian bit order throught the
+    // that) and keep the data in little-endian bit order through the
     // calculation, bit-reversing the inputs and outputs.
 
     StubCodeMark mark(this, "StubRoutines", "ghash_processBlocks");
@@ -5923,7 +5923,7 @@ class StubGenerator: public StubCodeGenerator {
     Register send  = c_rarg2;  // source end offset
     Register dst   = c_rarg3;  // dest array
     Register doff  = c_rarg4;  // position for writing to dest array
-    Register isURL = c_rarg5;  // Base64 or URL chracter set
+    Register isURL = c_rarg5;  // Base64 or URL character set
 
     // c_rarg6 and c_rarg7 are free to use as temps
     Register codec  = c_rarg6;
@@ -6009,7 +6009,7 @@ class StubGenerator: public StubCodeGenerator {
 
     __ ld4(in0, in1, in2, in3, arrangement, __ post(src, 4 * size));
 
-    // we need unsigned saturating substract, to make sure all input values
+    // we need unsigned saturating subtract, to make sure all input values
     // in range [0, 63] will have 0U value in the higher half lookup
     __ uqsubv(decH0, __ T16B, in0, v27);
     __ uqsubv(decH1, __ T16B, in1, v27);
@@ -6113,7 +6113,7 @@ class StubGenerator: public StubCodeGenerator {
     // titled "Base64 decoding".
 
     // Non-SIMD lookup tables are mostly dumped from fromBase64 array used in java.util.Base64,
-    // except the trailing character '=' is also treated illegal value in this instrinsic. That
+    // except the trailing character '=' is also treated illegal value in this intrinsic. That
     // is java.util.Base64.fromBase64['='] = -2, while fromBase(URL)64ForNoSIMD['='] = 255 here.
     static const uint8_t fromBase64ForNoSIMD[256] = {
       255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u, 255u,