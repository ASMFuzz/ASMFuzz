@@ -137,7 +137,7 @@ void G1Arguments::initialize_card_set_configuration() {
   if (FLAG_IS_DEFAULT(G1RemSetArrayOfCardsEntries)) {
     uint max_cards_in_inline_ptr = G1CardSetConfiguration::max_cards_in_inline_ptr(HeapRegion::LogOfHRGrainBytes - CardTable::card_shift());
     FLAG_SET_ERGO(G1RemSetArrayOfCardsEntries, MAX2(max_cards_in_inline_ptr * 2,
-                                                    G1RemSetArrayOfCardsEntriesBase * (1u << (region_size_log_mb + 1))));
+                                                    G1RemSetArrayOfCardsEntriesBase << region_size_log_mb));
   }
 
   // Round to next 8 byte boundary for array to maximize space usage.