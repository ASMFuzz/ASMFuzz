@@ -118,4 +118,4 @@ void MemRegion::destroy_array(MemRegion* array, size_t length) {
     array[i].~MemRegion();
   }
   FREE_C_HEAP_ARRAY(MemRegion, array);
-}
\ No newline at end of file
+}