@@ -117,7 +117,7 @@ class HeapRegion : public CHeapObj<mtGC> {
   // given address.
   bool is_in_reserved(const void* p) const { return _bottom <= p && p < _end; }
 
-  size_t capacity()     const { return byte_size(bottom(), end()); }
+  size_t capacity() const { return byte_size(bottom(), end()); }
   size_t used() const { return byte_size(bottom(), top()); }
   size_t free() const { return byte_size(top(), end()); }
 