@@ -157,6 +157,14 @@ void G1CardSetCoarsenStats::reset() {
   }
 }
 
+void G1CardSetCoarsenStats::set(G1CardSetCoarsenStats& other) {
+  STATIC_ASSERT(ARRAY_SIZE(_coarsen_from) == ARRAY_SIZE(_coarsen_collision));
+  for (uint i = 0; i < ARRAY_SIZE(_coarsen_from); i++) {
+    _coarsen_from[i] = other._coarsen_from[i];
+    _coarsen_collision[i] = other._coarsen_collision[i];
+  }
+}
+
 void G1CardSetCoarsenStats::subtract_from(G1CardSetCoarsenStats& other) {
   STATIC_ASSERT(ARRAY_SIZE(_coarsen_from) == ARRAY_SIZE(_coarsen_collision));
   for (uint i = 0; i < ARRAY_SIZE(_coarsen_from); i++) {
@@ -893,10 +901,13 @@ G1CardSetCoarsenStats G1CardSet::coarsen_stats() {
 
 void G1CardSet::print_coarsen_stats(outputStream* out) {
   _last_coarsen_stats.subtract_from(_coarsen_stats);
+
   out->print("Coarsening (recent): ");
   _last_coarsen_stats.print_on(out);
   out->print("Coarsening (all): ");
   _coarsen_stats.print_on(out);
+
+  _last_coarsen_stats.set(_coarsen_stats);
 }
 
 size_t G1CardSet::mem_size() const {