@@ -1580,7 +1580,7 @@ void MacroAssembler::atomic_incw(Register counter_addr, Register tmp, Register t
     return;
   }
   Label retry_load;
-  if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))
+  if (VM_Version::supports_stxr_prefetch())
     prfm(Address(counter_addr), PSTL1STRM);
   bind(retry_load);
   // flush and load exclusive from the memory location
@@ -2302,7 +2302,7 @@ void MacroAssembler::cmpxchgptr(Register oldv, Register newv, Register addr, Reg
     membar(AnyAny);
   } else {
     Label retry_load, nope;
-    if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))
+    if (VM_Version::supports_stxr_prefetch())
       prfm(Address(addr), PSTL1STRM);
     bind(retry_load);
     // flush and load exclusive from the memory location
@@ -2345,7 +2345,7 @@ void MacroAssembler::cmpxchgw(Register oldv, Register newv, Register addr, Regis
     membar(AnyAny);
   } else {
     Label retry_load, nope;
-    if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))
+    if (VM_Version::supports_stxr_prefetch())
       prfm(Address(addr), PSTL1STRM);
     bind(retry_load);
     // flush and load exclusive from the memory location
@@ -2387,7 +2387,7 @@ void MacroAssembler::cmpxchg(Register addr, Register expected,
     compare_eq(result, expected, size);
   } else {
     Label retry_load, done;
-    if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))
+    if (VM_Version::supports_stxr_prefetch())
       prfm(Address(addr), PSTL1STRM);
     bind(retry_load);
     load_exclusive(result, addr, size, acquire);
@@ -2446,7 +2446,7 @@ void MacroAssembler::atomic_##NAME(Register prev, RegisterOrConstant incr, Regis
     result = different(prev, incr, addr) ? prev : rscratch2;            \
                                                                         \
   Label retry_load;                                                     \
-  if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))         \
+  if (VM_Version::supports_stxr_prefetch())                             \
     prfm(Address(addr), PSTL1STRM);                                     \
   bind(retry_load);                                                     \
   LDXR(result, addr);                                                   \
@@ -2477,7 +2477,7 @@ void MacroAssembler::atomic_##OP(Register prev, Register newv, Register addr) {
     result = different(prev, newv, addr) ? prev : rscratch2;            \
                                                                         \
   Label retry_load;                                                     \
-  if ((VM_Version::features() & VM_Version::CPU_STXR_PREFETCH))         \
+  if (VM_Version::supports_stxr_prefetch())                             \
     prfm(Address(addr), PSTL1STRM);                                     \
   bind(retry_load);                                                     \
   LDXR(result, addr);                                                   \
@@ -5215,7 +5215,7 @@ void MacroAssembler::cache_wb(Address line) {
   assert(line.offset() == 0, "offset should be 0");
   // would like to assert this
   // assert(line._ext.shift == 0, "shift should be zero");
-  if (VM_Version::features() & VM_Version::CPU_DCPOP) {
+  if (VM_Version::supports_dcpop()) {
     // writeback using clear virtual address to point of persistence
     dc(Assembler::CVAP, line.base());
   } else {