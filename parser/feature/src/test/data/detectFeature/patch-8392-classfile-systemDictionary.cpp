@@ -1013,6 +1013,15 @@ bool SystemDictionary::is_shared_class_visible_impl(Symbol* class_name,
     return true;
   }
 
+  if (pkg_entry == NULL) {
+    // We might have looked up pkg_entry before the module system was initialized.
+    // Need to reload it now.
+    TempNewSymbol pkg_name = ClassLoader::package_from_class_name(class_name);
+    if (pkg_name != NULL) {
+      pkg_entry = ClassLoaderData::class_loader_data(class_loader())->packages()->lookup_only(pkg_name);
+    }
+  }
+
   ModuleEntry* mod_entry = (pkg_entry == NULL) ? NULL : pkg_entry->module();
   bool should_be_in_named_module = (mod_entry != NULL && mod_entry->is_named());
   bool was_archived_from_named_module = scp_entry->in_named_module();