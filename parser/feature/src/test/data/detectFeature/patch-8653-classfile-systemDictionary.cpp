@@ -1453,7 +1453,6 @@ void SystemDictionary::define_instance_class(InstanceKlass* k, Handle class_load
     // Grabs and releases SystemDictionary_lock
     update_dictionary(name_hash, k, class_loader);
   }
-  k->eager_initialize(THREAD);
 
   // notify jvmti
   if (JvmtiExport::should_post_class_load()) {