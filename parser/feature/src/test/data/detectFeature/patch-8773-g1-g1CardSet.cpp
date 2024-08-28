@@ -50,12 +50,13 @@ static uint default_log2_card_regions_per_region() {
 }
 
 G1CardSetConfiguration::G1CardSetConfiguration() :
-  G1CardSetConfiguration(HeapRegion::LogCardsPerRegion,                             /* inline_ptr_bits_per_card */
+  G1CardSetConfiguration(HeapRegion::LogCardsPerRegion - default_log2_card_regions_per_region(),                                                                                   /* inline_ptr_bits_per_card */
                          G1RemSetArrayOfCardsEntries,                               /* max_cards_in_array */
                          (double)G1RemSetCoarsenHowlBitmapToHowlFullPercent / 100,  /* cards_in_bitmap_threshold_percent */
                          G1RemSetHowlNumBuckets,                                    /* num_buckets_in_howl */
                          (double)G1RemSetCoarsenHowlToFullPercent / 100,            /* cards_in_howl_threshold_percent */
-                         (uint)HeapRegion::CardsPerRegion,                          /* max_cards_in_cardset */
+                         (uint)HeapRegion::CardsPerRegion >> default_log2_card_regions_per_region(),
+                                                                                    /* max_cards_in_card_set */
                          default_log2_card_regions_per_region())                    /* log2_card_regions_per_region */
 {
   assert((_log2_card_regions_per_heap_region + _log2_cards_per_card_region) == (uint)HeapRegion::LogCardsPerRegion,
@@ -75,7 +76,7 @@ G1CardSetConfiguration::G1CardSetConfiguration(uint max_cards_in_array,
                                                     max_cards_in_array,
                                                     max_buckets_in_howl),
                          cards_in_howl_threshold_percent,                      /* cards_in_howl_threshold_percent */
-                         max_cards_in_card_set,                                /* max_cards_in_cardset */
+                         max_cards_in_card_set,                                /* max_cards_in_card_set */
                          log2_card_regions_per_region)
 { }
 
@@ -96,10 +97,35 @@ G1CardSetConfiguration::G1CardSetConfiguration(uint inline_ptr_bits_per_card,
   _log2_max_cards_in_howl_bitmap(log2i_exact(_max_cards_in_howl_bitmap)),
   _bitmap_hash_mask(~(~(0) << _log2_max_cards_in_howl_bitmap)),
   _log2_card_regions_per_heap_region(log2_card_regions_per_heap_region),
-  _log2_cards_per_card_region(log2i_exact(_max_cards_in_card_set) - _log2_card_regions_per_heap_region) {
+  _log2_cards_per_card_region(log2i_exact(_max_cards_in_card_set)) {
+
+  assert(_inline_ptr_bits_per_card <= G1CardSetContainer::LogCardsPerRegionLimit,
+         "inline_ptr_bits_per_card (%u) is wasteful, can represent more than maximum possible card indexes (%u)",
+         _inline_ptr_bits_per_card, G1CardSetContainer::LogCardsPerRegionLimit);
+  assert(_inline_ptr_bits_per_card >= _log2_cards_per_card_region,
+         "inline_ptr_bits_per_card (%u) must be larger than possible card indexes (%u)",
+         _inline_ptr_bits_per_card, _log2_cards_per_card_region);
+
+  assert(cards_in_bitmap_threshold_percent >= 0.0 && cards_in_bitmap_threshold_percent <= 1.0,
+         "cards_in_bitmap_threshold_percent (%1.2f) out of range", cards_in_bitmap_threshold_percent);
+
+  assert(cards_in_howl_threshold_percent >= 0.0 && cards_in_howl_threshold_percent <= 1.0,
+         "cards_in_howl_threshold_percent (%1.2f) out of range", cards_in_howl_threshold_percent);
 
   assert(is_power_of_2(_max_cards_in_card_set),
          "max_cards_in_card_set must be a power of 2: %u", _max_cards_in_card_set);
+  assert(_max_cards_in_card_set <= G1CardSetContainer::cards_per_region_limit(),
+         "Specified number of cards (%u) exceeds maximum representable (%u)",
+         _max_cards_in_card_set, G1CardSetContainer::cards_per_region_limit());
+
+  assert(_cards_in_howl_bitmap_threshold <= _max_cards_in_howl_bitmap,
+         "Threshold to coarsen Howl Bitmap to Howl Full (%u) must be "
+         "smaller than or equal to max number of cards in Howl bitmap (%u)",
+         _cards_in_howl_bitmap_threshold, _max_cards_in_howl_bitmap);
+  assert(_cards_in_howl_threshold <= _max_cards_in_card_set,
+         "Threshold to coarsen Howl to Full (%u) must be "
+         "smaller than or equal to max number of cards in card region (%u)",
+         _cards_in_howl_threshold, _max_cards_in_card_set);
 
   init_card_set_alloc_options();
   log_configuration();
@@ -129,7 +155,7 @@ void G1CardSetConfiguration::log_configuration() {
                           num_buckets_in_howl(), cards_in_howl_threshold(),
                           max_cards_in_howl_bitmap(), G1CardSetBitMap::size_in_bytes(max_cards_in_howl_bitmap()), cards_in_howl_bitmap_threshold(),
                           (uint)1 << log2_card_regions_per_heap_region(),
-                          (uint)1 << log2_cards_per_card_region());
+                          max_cards_in_region());
 }
 
 uint G1CardSetConfiguration::max_cards_in_inline_ptr() const {