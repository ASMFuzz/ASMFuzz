@@ -818,14 +818,14 @@ inline T Atomic::cmpxchg_using_helper(Fn fn,
 inline uint32_t Atomic::CmpxchgByteUsingInt::set_byte_in_int(uint32_t n,
                                                              uint8_t b,
                                                              uint32_t idx) {
-  int bitsIdx = BitsPerByte * idx;
+  uint32_t bitsIdx = BitsPerByte * idx;
   return (n & ~(static_cast<uint32_t>(0xff) << bitsIdx))
           | (static_cast<uint32_t>(b) << bitsIdx);
 }
 
 inline uint8_t Atomic::CmpxchgByteUsingInt::get_byte_in_int(uint32_t n,
                                                             uint32_t idx) {
-  int bitsIdx = BitsPerByte * idx;
+  uint32_t bitsIdx = BitsPerByte * idx;
   return (uint8_t)(n >> bitsIdx);
 }
 