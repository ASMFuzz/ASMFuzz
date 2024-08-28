@@ -121,16 +121,16 @@ class G1BlockOffsetTablePart {
   // at "end" to point back to the card before "start"; [start, end]
   void set_remainder_to_point_to_start_incl(size_t start, size_t end);
 
-  inline size_t block_size(const HeapWord* p) const;
+  inline size_t block_size(HeapWord* const p) const;
 
   // Returns the address of a block whose start is at most "addr".
-  inline HeapWord* block_at_or_preceding(const void* addr) const;
+  inline HeapWord* block_at_or_preceding(void* const addr) const;
 
   // Return the address of the beginning of the block that contains "addr".
   // "q" is a block boundary that is <= "addr"; "n" is the address of the
   // next block (or the end of the space.)
   inline HeapWord* forward_to_block_containing_addr(HeapWord* q, HeapWord* n,
-                                                    const void* addr) const;
+                                                    void* const addr) const;
 
   // Update BOT entries corresponding to the mem range [blk_start, blk_end).
   void update_for_block_work(HeapWord* blk_start, HeapWord* blk_end);
@@ -161,7 +161,7 @@ class G1BlockOffsetTablePart {
   // namely updating of shared array entries that "point" too far
   // backwards.  This can occur, for example, when lab allocation is used
   // in a space covered by the table.)
-  inline HeapWord* block_start(const void* addr);
+  inline HeapWord* block_start(void* const addr);
 
   void update_for_block(HeapWord* blk_start, HeapWord* blk_end) {
     if (is_crossing_card_boundary(blk_start, blk_end)) {