@@ -114,7 +114,7 @@ class RegionTypeCounter {
 private:
   const char* _name;
 
-  size_t _rs_wasted_mem_size;
+  size_t _rs_unused_mem_size;
   size_t _rs_mem_size;
   size_t _cards_occupied;
   size_t _amount;
@@ -144,12 +144,12 @@ class RegionTypeCounter {
 
 public:
 
-  RegionTypeCounter(const char* name) : _name(name), _rs_wasted_mem_size(0), _rs_mem_size(0), _cards_occupied(0),
+  RegionTypeCounter(const char* name) : _name(name), _rs_unused_mem_size(0), _rs_mem_size(0), _cards_occupied(0),
     _amount(0), _amount_tracked(0), _code_root_mem_size(0), _code_root_elems(0) { }
 
-  void add(size_t rs_wasted_mem_size, size_t rs_mem_size, size_t cards_occupied,
+  void add(size_t rs_unused_mem_size, size_t rs_mem_size, size_t cards_occupied,
            size_t code_root_mem_size, size_t code_root_elems, bool tracked) {
-    _rs_wasted_mem_size += rs_wasted_mem_size;
+    _rs_unused_mem_size += rs_unused_mem_size;
     _rs_mem_size += rs_mem_size;
     _cards_occupied += cards_occupied;
     _code_root_mem_size += code_root_mem_size;
@@ -158,7 +158,7 @@ class RegionTypeCounter {
     _amount_tracked += tracked ? 1 : 0;
   }
 
-  size_t rs_wasted_mem_size() const { return _rs_wasted_mem_size; }
+  size_t rs_unused_mem_size() const { return _rs_unused_mem_size; }
   size_t rs_mem_size() const { return _rs_mem_size; }
   size_t cards_occupied() const { return _cards_occupied; }
 
@@ -167,10 +167,10 @@ class RegionTypeCounter {
 
   void print_rs_mem_info_on(outputStream * out, size_t total) {
     out->print_cr("    " SIZE_FORMAT_W(8) " (%5.1f%%) by " SIZE_FORMAT " "
-                  "(" SIZE_FORMAT ") %s regions wasted " SIZE_FORMAT,
+                  "(" SIZE_FORMAT ") %s regions unused " SIZE_FORMAT,
                   rs_mem_size(), rs_mem_size_percent_of(total),
                   amount_tracked(), amount(),
-                  _name, rs_wasted_mem_size());
+                  _name, rs_unused_mem_size());
   }
 
   void print_cards_occupied_info_on(outputStream * out, size_t total) {
@@ -206,7 +206,7 @@ class HRRSStatsIter: public HeapRegionClosure {
   size_t _max_rs_mem_sz;
   HeapRegion* _max_rs_mem_sz_region;
 
-  size_t total_rs_wasted_mem_sz() const     { return _all.rs_wasted_mem_size(); }
+  size_t total_rs_unused_mem_sz() const     { return _all.rs_unused_mem_size(); }
   size_t total_rs_mem_sz() const            { return _all.rs_mem_size(); }
   size_t total_cards_occupied() const       { return _all.cards_occupied(); }
 
@@ -234,7 +234,7 @@ class HRRSStatsIter: public HeapRegionClosure {
 
     // HeapRegionRemSet::mem_size() includes the
     // size of the code roots
-    size_t rs_wasted_mem_sz = hrrs->wasted_mem_size();
+    size_t rs_unused_mem_sz = hrrs->unused_mem_size();
     size_t rs_mem_sz = hrrs->mem_size();
     if (rs_mem_sz > _max_rs_mem_sz) {
       _max_rs_mem_sz = rs_mem_sz;
@@ -262,9 +262,9 @@ class HRRSStatsIter: public HeapRegionClosure {
     } else {
       ShouldNotReachHere();
     }
-    current->add(rs_wasted_mem_sz, rs_mem_sz, occupied_cards,
+    current->add(rs_unused_mem_sz, rs_mem_sz, occupied_cards,
                  code_root_mem_sz, code_root_elems, r->rem_set()->is_tracked());
-    _all.add(rs_wasted_mem_sz, rs_mem_sz, occupied_cards,
+    _all.add(rs_unused_mem_sz, rs_mem_sz, occupied_cards,
              code_root_mem_sz, code_root_elems, r->rem_set()->is_tracked());
 
     return false;
@@ -275,10 +275,10 @@ class HRRSStatsIter: public HeapRegionClosure {
 
     out->print_cr(" Current rem set statistics");
     out->print_cr("  Total per region rem sets sizes = " SIZE_FORMAT
-                  " Max = " SIZE_FORMAT " wasted = " SIZE_FORMAT,
+                  " Max = " SIZE_FORMAT " unused = " SIZE_FORMAT,
                   total_rs_mem_sz(),
                   max_rs_mem_sz(),
-                  total_rs_wasted_mem_sz());
+                  total_rs_unused_mem_sz());
     for (RegionTypeCounter** current = &counters[0]; *current != NULL; current++) {
       (*current)->print_rs_mem_info_on(out, total_rs_mem_sz());
     }