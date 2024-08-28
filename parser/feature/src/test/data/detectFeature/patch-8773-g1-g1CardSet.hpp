@@ -110,7 +110,7 @@ class G1CardSetConfiguration {
   uint howl_bucket_index(uint card_idx) { return card_idx >> _log2_max_cards_in_howl_bitmap; }
 
   // Full card configuration
-  // Maximum number of cards in a non-full card set for a single region. Card sets
+  // Maximum number of cards in a non-full card set for a single card region. Card sets
   // with more entries per region are coarsened to Full.
   uint max_cards_in_region() const { return _max_cards_in_card_set; }
 