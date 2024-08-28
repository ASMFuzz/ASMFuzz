@@ -32,7 +32,7 @@
 #include "runtime/atomic.hpp"
 #include "oops/oop.inline.hpp"
 
-inline HeapWord* G1BlockOffsetTablePart::block_start(const void* addr) {
+inline HeapWord* G1BlockOffsetTablePart::block_start(void* const addr) {
   assert(addr >= _hr->bottom() && addr < _hr->top(), "invalid address");
   HeapWord* q = block_at_or_preceding(addr);
   HeapWord* n = q + block_size(q);
@@ -95,11 +95,11 @@ inline HeapWord* G1BlockOffsetTable::address_for_index(size_t index) const {
   return result;
 }
 
-inline size_t G1BlockOffsetTablePart::block_size(const HeapWord* p) const {
+inline size_t G1BlockOffsetTablePart::block_size(HeapWord* const p) const {
   return _hr->block_size(p);
 }
 
-inline HeapWord* G1BlockOffsetTablePart::block_at_or_preceding(const void* addr) const {
+inline HeapWord* G1BlockOffsetTablePart::block_at_or_preceding(void* const addr) const {
 #ifdef ASSERT
   if (!_hr->is_continues_humongous()) {
     // For non-ContinuesHumongous regions, the first obj always starts from bottom.
@@ -126,7 +126,7 @@ inline HeapWord* G1BlockOffsetTablePart::block_at_or_preceding(const void* addr)
 }
 
 inline HeapWord* G1BlockOffsetTablePart::forward_to_block_containing_addr(HeapWord* q, HeapWord* n,
-                                                                          const void* addr) const {
+                                                                          void* const addr) const {
   while (n <= addr) {
     // When addr is not covered by the block starting at q we need to
     // step forward until we find the correct block. With the BOT