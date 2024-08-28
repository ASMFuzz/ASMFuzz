@@ -188,12 +188,6 @@ class G1CardSetArray : public G1CardSetContainer {
       Atomic::release_store(_num_entries_addr, _local_num_entries);
     }
   };
-
-  template<typename Derived>
-  static size_t header_size_in_bytes_internal() {
-    return offset_of(Derived, _data);
-  }
-
 public:
   G1CardSetArray(uint const card_in_region, EntryCountType num_cards);
 
@@ -206,7 +200,7 @@ class G1CardSetArray : public G1CardSetContainer {
 
   size_t num_entries() const { return _num_entries & EntryMask; }
 
-  static size_t header_size_in_bytes() { return header_size_in_bytes_internal<G1CardSetArray>(); }
+  static size_t header_size_in_bytes();
 
   static size_t size_in_bytes(size_t num_cards) {
     return header_size_in_bytes() + sizeof(EntryDataType) * num_cards;
@@ -217,13 +211,6 @@ class G1CardSetBitMap : public G1CardSetContainer {
   size_t _num_bits_set;
   BitMap::bm_word_t _bits[1];
 
-  using ContainerPtr = G1CardSet::ContainerPtr;
-
-  template<typename Derived>
-  static size_t header_size_in_bytes_internal() {
-    return offset_of(Derived, _bits);
-  }
-
 public:
   G1CardSetBitMap(uint const card_in_region, uint const size_in_bits);
 
@@ -244,7 +231,7 @@ class G1CardSetBitMap : public G1CardSetContainer {
     return static_cast<uint>(bm.get_next_one_offset(idx));
   }
 
-  static size_t header_size_in_bytes() { return header_size_in_bytes_internal<G1CardSetBitMap>(); }
+  static size_t header_size_in_bytes();
 
   static size_t size_in_bytes(size_t size_in_bits) { return header_size_in_bytes() + BitMap::calc_size_in_words(size_in_bits) * BytesPerWord; }
 };
@@ -258,11 +245,6 @@ class G1CardSetHowl : public G1CardSetContainer {
   ContainerPtr _buckets[2];
   // Do not add class member variables beyond this point
 
-  template<typename Derived>
-  static size_t header_size_in_bytes_internal() {
-    return offset_of(Derived, _buckets);
-  }
-
   // Iterates over the given ContainerPtr with at index in this Howl card set,
   // applying a CardOrRangeVisitor on it.
   template <class CardOrRangeVisitor>
@@ -297,7 +279,7 @@ class G1CardSetHowl : public G1CardSetContainer {
     return round_up_power_of_2(num_cards);
   }
 
-  static size_t header_size_in_bytes() { return header_size_in_bytes_internal<G1CardSetHowl>(); }
+  static size_t header_size_in_bytes();
 
   static size_t size_in_bytes(size_t num_arrays) {
     return header_size_in_bytes() + sizeof(ContainerPtr) * num_arrays;