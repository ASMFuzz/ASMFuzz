@@ -909,8 +909,8 @@ size_t G1CardSet::mem_size() const {
          _mm->mem_size();
 }
 
-size_t G1CardSet::wasted_mem_size() const {
-  return _mm->wasted_mem_size();
+size_t G1CardSet::unused_mem_size() const {
+  return _mm->unused_mem_size();
 }
 
 size_t G1CardSet::static_mem_size() {