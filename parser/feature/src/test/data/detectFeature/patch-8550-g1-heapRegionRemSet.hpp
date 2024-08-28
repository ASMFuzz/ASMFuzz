@@ -136,8 +136,8 @@ class HeapRegionRemSet : public CHeapObj<mtGC> {
            + code_roots_mem_size();
   }
 
-  size_t wasted_mem_size() {
-    return _card_set.wasted_mem_size();
+  size_t unused_mem_size() {
+    return _card_set.unused_mem_size();
   }
 
   // Returns the memory occupancy of all static data structures associated