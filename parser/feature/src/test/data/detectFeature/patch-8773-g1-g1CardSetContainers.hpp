@@ -157,6 +157,8 @@ class G1CardSetContainer {
 
   // Log of largest card index that can be stored in any G1CardSetContainer
   static uint LogCardsPerRegionLimit;
+
+  static uint cards_per_region_limit() { return 1u << LogCardsPerRegionLimit; }
 };
 
 class G1CardSetArray : public G1CardSetContainer {