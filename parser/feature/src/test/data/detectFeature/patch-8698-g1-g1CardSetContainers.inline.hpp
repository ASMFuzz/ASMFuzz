@@ -221,6 +221,10 @@ void G1CardSetArray::iterate(CardVisitor& found) {
   }
 }
 
+inline size_t G1CardSetArray::header_size_in_bytes() {
+  return offset_of(G1CardSetArray, _data);
+}
+
 inline G1CardSetBitMap::G1CardSetBitMap(uint card_in_region, uint size_in_bits) :
   G1CardSetContainer(), _num_bits_set(1) {
   assert(size_in_bits % (sizeof(_bits[0]) * BitsPerByte) == 0,
@@ -252,6 +256,10 @@ inline void G1CardSetBitMap::iterate(CardVisitor& found, size_t size_in_bits, ui
   }
 }
 
+inline size_t G1CardSetBitMap::header_size_in_bytes() {
+    return offset_of(G1CardSetBitMap, _bits);
+}
+
 inline G1CardSetHowl::G1CardSetHowl(EntryCountType card_in_region, G1CardSetConfiguration* config) :
   G1CardSetContainer(),
   _num_entries((config->max_cards_in_array() + 1)) /* Card Transfer will not increment _num_entries */ {
@@ -352,4 +360,8 @@ inline G1CardSetHowl::EntryCountType G1CardSetHowl::num_buckets(size_t size_in_b
   return (EntryCountType)num_arrays;
 }
 
+inline size_t G1CardSetHowl::header_size_in_bytes() {
+  return offset_of(G1CardSetHowl, _buckets);
+}
+
 #endif // SHARE_GC_G1_G1CARDSETCONTAINERS_INLINE_HPP