@@ -331,8 +331,7 @@ class G1Policy: public CHeapObj<mtGC> {
   void record_concurrent_mark_cleanup_start();
   void record_concurrent_mark_cleanup_end(bool has_rebuilt_remembered_sets);
 
-  bool next_gc_should_be_mixed(const char* true_action_str,
-                               const char* false_action_str) const;
+  bool next_gc_should_be_mixed(const char* no_candidates_str) const;
 
   // Amount of allowed waste in bytes in the collection set.
   size_t allowed_waste_in_collection_set() const;