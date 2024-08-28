@@ -589,7 +589,7 @@ void MutableNUMASpace::initialize(MemRegion mr,
 
   // Compute chunk sizes
   size_t prev_page_size = page_size();
-  set_page_size(UseLargePages ? alignment() : os::vm_page_size());
+  set_page_size(alignment());
   HeapWord* rounded_bottom = align_up(bottom(), page_size());
   HeapWord* rounded_end = align_down(end(), page_size());
   size_t base_space_size_pages = pointer_delta(rounded_end, rounded_bottom, sizeof(char)) / page_size();