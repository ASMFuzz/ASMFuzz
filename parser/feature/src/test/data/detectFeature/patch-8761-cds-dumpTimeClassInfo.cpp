@@ -193,21 +193,20 @@ class CountClassByCategory : StackObj {
   DumpTimeSharedClassTable* _table;
 public:
   CountClassByCategory(DumpTimeSharedClassTable* table) : _table(table) {}
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+  void do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
     if (!info.is_excluded()) {
       if (info.is_builtin()) {
         _table->inc_builtin_count();
       } else {
         _table->inc_unregistered_count();
       }
     }
-    return true; // keep on iterating
   }
 };
 
 void DumpTimeSharedClassTable::update_counts() {
   _builtin_count = 0;
   _unregistered_count = 0;
   CountClassByCategory counter(this);
-  iterate(&counter);
+  iterate_all_live_classes(&counter);
 }