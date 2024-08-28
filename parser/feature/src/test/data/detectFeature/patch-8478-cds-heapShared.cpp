@@ -179,8 +179,9 @@ void HeapShared::fixup_regions() {
 }
 
 unsigned HeapShared::oop_hash(oop const& p) {
-  unsigned hash = (unsigned)p->identity_hash();
-  return hash;
+  // Do not call p->identity_hash() as that will update the
+  // object header.
+  return primitive_hash(cast_from_oop<intptr_t>(p));
 }
 
 static void reset_states(oop obj, TRAPS) {
@@ -1577,20 +1578,28 @@ class FindEmbeddedNonNullPointers: public BasicOopIterateClosure {
     : _start(start), _oopmap(oopmap), _num_total_oops(0),  _num_null_oops(0) {}
 
   virtual void do_oop(narrowOop* p) {
+    assert(UseCompressedOops, "sanity");
     _num_total_oops ++;
     narrowOop v = *p;
     if (!CompressedOops::is_null(v)) {
+      // Note: HeapShared::to_requested_address() is not necessary because
+      // the heap always starts at a deterministic address with UseCompressedOops==true.
       size_t idx = p - (narrowOop*)_start;
       _oopmap->set_bit(idx);
     } else {
       _num_null_oops ++;
     }
   }
   virtual void do_oop(oop* p) {
+    assert(!UseCompressedOops, "sanity");
     _num_total_oops ++;
     if ((*p) != NULL) {
       size_t idx = p - (oop*)_start;
       _oopmap->set_bit(idx);
+      if (DumpSharedSpaces) {
+        // Make heap content deterministic.
+        *p = HeapShared::to_requested_address(*p);
+      }
     } else {
       _num_null_oops ++;
     }
@@ -1599,6 +1608,34 @@ class FindEmbeddedNonNullPointers: public BasicOopIterateClosure {
   int num_null_oops()  const { return _num_null_oops; }
 };
 
+
+address HeapShared::to_requested_address(address dumptime_addr) {
+  assert(DumpSharedSpaces, "static dump time only");
+  if (dumptime_addr == NULL || UseCompressedOops) {
+    return dumptime_addr;
+  }
+
+  // With UseCompressedOops==false, actual_base is selected by the OS so
+  // it's different across -Xshare:dump runs.
+  address actual_base = (address)G1CollectedHeap::heap()->reserved().start();
+  address actual_end  = (address)G1CollectedHeap::heap()->reserved().end();
+  assert(actual_base <= dumptime_addr && dumptime_addr <= actual_end, "must be an address in the heap");
+
+  // We always write the objects as if the heap started at this address. This
+  // makes the heap content deterministic.
+  //
+  // Note that at runtime, the heap address is also selected by the OS, so
+  // the archive heap will not be mapped at 0x10000000. Instead, we will call
+  // HeapShared::patch_embedded_pointers() to relocate the heap contents
+  // accordingly.
+  const address REQUESTED_BASE = (address)0x10000000;
+  intx delta = REQUESTED_BASE - actual_base;
+
+  address requested_addr = dumptime_addr + delta;
+  assert(REQUESTED_BASE != 0 && requested_addr != NULL, "sanity");
+  return requested_addr;
+}
+
 ResourceBitMap HeapShared::calculate_oopmap(MemRegion region) {
   size_t num_bits = region.byte_size() / (UseCompressedOops ? sizeof(narrowOop) : sizeof(oop));
   ResourceBitMap oopmap(num_bits);
@@ -1619,7 +1656,7 @@ ResourceBitMap HeapShared::calculate_oopmap(MemRegion region) {
     ++ num_objs;
   }
 
-  log_info(cds, heap)("calculate_oopmap: objects = %6d, embedded oops = %7d, nulls = %7d",
+  log_info(cds, heap)("calculate_oopmap: objects = %6d, oop fields = %7d (nulls = %7d)",
                       num_objs, finder.num_total_oops(), finder.num_null_oops());
   return oopmap;
 }