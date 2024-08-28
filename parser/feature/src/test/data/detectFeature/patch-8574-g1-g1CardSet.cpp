@@ -295,10 +295,6 @@ class G1CardSetHashTable : public CHeapObj<mtGCCardSet> {
     }
   }
 
-  void print(outputStream* os) {
-    os->print("TBL " PTR_FORMAT " size %zu mem %zu ", p2i(&_table), _table.get_size_log2(Thread::current()), _table.get_mem_size(Thread::current()));
-  }
-
   void grow() {
     size_t new_limit = _table.get_size_log2(Thread::current()) + 1;
     _table.grow(Thread::current(), new_limit);
@@ -922,8 +918,3 @@ void G1CardSet::clear() {
   _num_occupied = 0;
   _mm->flush();
 }
-
-void G1CardSet::print(outputStream* os) {
-  _table->print(os);
-  _mm->print(os);
-}