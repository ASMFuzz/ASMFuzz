@@ -62,7 +62,7 @@ class MutableSpace: public CHeapObj<mtGC> {
 
   MutableSpaceMangler* mangler() { return _mangler; }
 
-  void numa_setup_pages(MemRegion mr, bool clear_space);
+  void numa_setup_pages(MemRegion mr, size_t page_size, bool clear_space);
 
   void set_last_setup_region(MemRegion mr) { _last_setup_region = mr;   }
   MemRegion last_setup_region() const      { return _last_setup_region; }