@@ -617,11 +617,10 @@ class UnregisteredClassesDuplicationChecker : StackObj {
 public:
   UnregisteredClassesDuplicationChecker() : _thread(Thread::current()) {}
 
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+  void do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
     if (!SystemDictionaryShared::is_builtin(k)) {
       _list.append(k);
     }
-    return true;  // keep on iterating
   }
 
   static int compare_by_loader(InstanceKlass** a, InstanceKlass** b) {
@@ -653,29 +652,23 @@ class UnregisteredClassesDuplicationChecker : StackObj {
   }
 };
 
-class ExcludeDumpTimeSharedClasses : StackObj {
-public:
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
-    SystemDictionaryShared::check_for_exclusion(k, &info);
-    return true; // keep on iterating
-  }
-};
-
 void SystemDictionaryShared::check_excluded_classes() {
   assert(no_class_loading_should_happen(), "sanity");
   assert_lock_strong(DumpTimeTable_lock);
 
   if (DynamicDumpSharedSpaces) {
     // Do this first -- if a base class is excluded due to duplication,
-    // all of its subclasses will also be excluded by ExcludeDumpTimeSharedClasses
+    // all of its subclasses will also be excluded.
     ResourceMark rm;
     UnregisteredClassesDuplicationChecker dup_checker;
-    _dumptime_table->iterate(&dup_checker);
+    _dumptime_table->iterate_all_live_classes(&dup_checker);
     dup_checker.mark_duplicated_classes();
   }
 
-  ExcludeDumpTimeSharedClasses excl;
-  _dumptime_table->iterate(&excl);
+  auto check_for_exclusion = [&] (InstanceKlass* k, DumpTimeClassInfo& info) {
+    SystemDictionaryShared::check_for_exclusion(k, &info);
+  };
+  _dumptime_table->iterate_all_live_classes(check_for_exclusion);
   _dumptime_table->update_counts();
 
   cleanup_lambda_proxy_class_dictionary();
@@ -725,42 +718,24 @@ bool SystemDictionaryShared::has_class_failed_verification(InstanceKlass* ik) {
   return (p == NULL) ? false : p->failed_verification();
 }
 
-class IterateDumpTimeSharedClassTable : StackObj {
-  MetaspaceClosure *_it;
-public:
-  IterateDumpTimeSharedClassTable(MetaspaceClosure* it) : _it(it) {}
+void SystemDictionaryShared::dumptime_classes_do(class MetaspaceClosure* it) {
+  assert_lock_strong(DumpTimeTable_lock);
 
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
-    assert_lock_strong(DumpTimeTable_lock);
+  auto do_klass = [&] (InstanceKlass* k, DumpTimeClassInfo& info) {
     if (k->is_loader_alive() && !info.is_excluded()) {
-      info.metaspace_pointers_do(_it);
+      info.metaspace_pointers_do(it);
     }
-    return true; // keep on iterating
-  }
-};
+  };
+  _dumptime_table->iterate_all_live_classes(do_klass);
 
-class IterateDumpTimeLambdaProxyClassDictionary : StackObj {
-  MetaspaceClosure *_it;
-public:
-  IterateDumpTimeLambdaProxyClassDictionary(MetaspaceClosure* it) : _it(it) {}
-
-  bool do_entry(LambdaProxyClassKey& key, DumpTimeLambdaProxyClassInfo& info) {
-    assert_lock_strong(DumpTimeTable_lock);
-    if (key.caller_ik()->is_loader_alive()) {
-      info.metaspace_pointers_do(_it);
-      key.metaspace_pointers_do(_it);
-    }
-    return true; // keep on iterating
-  }
-};
-
-void SystemDictionaryShared::dumptime_classes_do(class MetaspaceClosure* it) {
-  assert_lock_strong(DumpTimeTable_lock);
-  IterateDumpTimeSharedClassTable iter(it);
-  _dumptime_table->iterate(&iter);
   if (_dumptime_lambda_proxy_class_dictionary != NULL) {
-    IterateDumpTimeLambdaProxyClassDictionary iter_lambda(it);
-    _dumptime_lambda_proxy_class_dictionary->iterate(&iter_lambda);
+    auto do_lambda = [&] (LambdaProxyClassKey& key, DumpTimeLambdaProxyClassInfo& info) {
+      if (key.caller_ik()->is_loader_alive()) {
+        info.metaspace_pointers_do(it);
+        key.metaspace_pointers_do(it);
+      }
+    };
+    _dumptime_lambda_proxy_class_dictionary->iterate_all(do_lambda);
   }
 }
 
@@ -1172,12 +1147,11 @@ class EstimateSizeForArchive : StackObj {
     _num_unregistered_klasses = 0;
   }
 
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+  void do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
     if (!info.is_excluded()) {
       size_t byte_size = info.runtime_info_bytesize();
       _shared_class_info_size += align_up(byte_size, SharedSpaceObjectAlignment);
     }
-    return true; // keep on iterating
   }
 
   size_t total() {
@@ -1187,7 +1161,7 @@ class EstimateSizeForArchive : StackObj {
 
 size_t SystemDictionaryShared::estimate_size_for_archive() {
   EstimateSizeForArchive est;
-  _dumptime_table->iterate(&est);
+  _dumptime_table->iterate_all_live_classes(&est);
   size_t total_size = est.total() +
     CompactHashtableWriter::estimate_size(_dumptime_table->count_of(true)) +
     CompactHashtableWriter::estimate_size(_dumptime_table->count_of(false));
@@ -1281,7 +1255,7 @@ class CopySharedClassInfoToArchive : StackObj {
                                bool is_builtin)
     : _writer(writer), _is_builtin(is_builtin), _builder(ArchiveBuilder::current()) {}
 
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+  void do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
     if (!info.is_excluded() && info.is_builtin() == _is_builtin) {
       size_t byte_size = info.runtime_info_bytesize();
       RunTimeClassInfo* record;
@@ -1305,7 +1279,6 @@ class CopySharedClassInfoToArchive : StackObj {
       // Save this for quick runtime lookup of InstanceKlass* -> RunTimeClassInfo*
       RunTimeClassInfo::set_for(info._klass, record);
     }
-    return true; // keep on iterating
   }
 };
 
@@ -1325,7 +1298,7 @@ void SystemDictionaryShared::write_dictionary(RunTimeSharedDictionary* dictionar
   CompactHashtableWriter writer(_dumptime_table->count_of(is_builtin), &stats);
   CopySharedClassInfoToArchive copy(&writer, is_builtin);
   assert_lock_strong(DumpTimeTable_lock);
-  _dumptime_table->iterate(&copy);
+  _dumptime_table->iterate_all_live_classes(&copy);
   writer.dump(dictionary, is_builtin ? "builtin dictionary" : "unregistered dictionary");
 }
 
@@ -1558,12 +1531,11 @@ class CloneDumpTimeClassTable: public StackObj {
     assert(_table != NULL, "_dumptime_table is NULL");
     assert(_cloned_table != NULL, "_cloned_table is NULL");
   }
-  bool do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
+  void do_entry(InstanceKlass* k, DumpTimeClassInfo& info) {
     if (!info.is_excluded()) {
       bool created;
       _cloned_table->put_if_absent(k, info.clone(), &created);
     }
-    return true; // keep on iterating
   }
 };
 
@@ -1596,7 +1568,7 @@ void SystemDictionaryShared::clone_dumptime_tables() {
     assert(_cloned_dumptime_table == NULL, "_cloned_dumptime_table must be cleaned");
     _cloned_dumptime_table = new (ResourceObj::C_HEAP, mtClass) DumpTimeSharedClassTable;
     CloneDumpTimeClassTable copy_classes(_dumptime_table, _cloned_dumptime_table);
-    _dumptime_table->iterate(&copy_classes);
+    _dumptime_table->iterate_all_live_classes(&copy_classes);
     _cloned_dumptime_table->update_counts();
   }
   if (_dumptime_lambda_proxy_class_dictionary != NULL) {