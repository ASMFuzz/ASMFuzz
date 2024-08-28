@@ -1906,12 +1906,12 @@ bool FileMapInfo::relocate_pointers_in_core_regions(intx addr_delta) {
 
     BitMapView ptrmap((BitMap::bm_word_t*)bitmap_base, ptrmap_size_in_bits);
 
-    // Patch all pointers in the the mapped region that are marked by ptrmap.
+    // Patch all pointers in the mapped region that are marked by ptrmap.
     address patch_base = (address)mapped_base();
     address patch_end  = (address)mapped_end();
 
     // the current value of the pointers to be patched must be within this
-    // range (i.e., must be between the requesed base address, and the of the current archive).
+    // range (i.e., must be between the requested base address and the address of the current archive).
     // Note: top archive may point to objects in the base archive, but not the other way around.
     address valid_old_base = (address)header()->requested_base_address();
     address valid_old_end  = valid_old_base + mapping_end_offset();