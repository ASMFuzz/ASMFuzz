@@ -397,9 +397,9 @@ inline frame frame::sender_raw(RegisterMap* map) const {
     return map->stack_chunk()->sender(*this, map);
   }
 
-  if (is_entry_frame())           return sender_for_entry_frame(map);
-  if (is_optimized_entry_frame()) return sender_for_optimized_entry_frame(map);
-  if (is_interpreted_frame())     return sender_for_interpreter_frame(map);
+  if (is_entry_frame())       return sender_for_entry_frame(map);
+  if (is_upcall_stub_frame()) return sender_for_upcall_stub_frame(map);
+  if (is_interpreted_frame()) return sender_for_interpreter_frame(map);
 
   assert(_cb == CodeCache::find_blob(pc()), "Must be the same");
   if (_cb != NULL) return sender_for_compiled_frame(map);