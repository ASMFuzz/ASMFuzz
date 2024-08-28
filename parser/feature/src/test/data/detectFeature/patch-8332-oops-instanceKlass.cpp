@@ -445,23 +445,21 @@ InstanceKlass* InstanceKlass::allocate_instance_klass(const ClassFileParser& par
   InstanceKlass* ik;
 
   // Allocation
-  if (REF_NONE == parser.reference_type()) {
-    if (class_name == vmSymbols::java_lang_Class()) {
-      // mirror - java.lang.Class
-      ik = new (loader_data, size, THREAD) InstanceMirrorKlass(parser);
-    } else if (is_stack_chunk_class(class_name, loader_data)) {
-      // stack chunk
-      ik = new (loader_data, size, THREAD) InstanceStackChunkKlass(parser);
-    } else if (is_class_loader(class_name, parser)) {
-      // class loader - java.lang.ClassLoader
-      ik = new (loader_data, size, THREAD) InstanceClassLoaderKlass(parser);
-    } else {
-      // normal
-      ik = new (loader_data, size, THREAD) InstanceKlass(parser);
-    }
-  } else {
+  if (parser.is_instance_ref_klass()) {
     // java.lang.ref.Reference
     ik = new (loader_data, size, THREAD) InstanceRefKlass(parser);
+  } else if (class_name == vmSymbols::java_lang_Class()) {
+    // mirror - java.lang.Class
+    ik = new (loader_data, size, THREAD) InstanceMirrorKlass(parser);
+  } else if (is_stack_chunk_class(class_name, loader_data)) {
+    // stack chunk
+    ik = new (loader_data, size, THREAD) InstanceStackChunkKlass(parser);
+  } else if (is_class_loader(class_name, parser)) {
+    // class loader - java.lang.ClassLoader
+    ik = new (loader_data, size, THREAD) InstanceClassLoaderKlass(parser);
+  } else {
+    // normal
+    ik = new (loader_data, size, THREAD) InstanceKlass(parser);
   }
 
   // Check for pending exception before adding to the loader data and incrementing
@@ -499,7 +497,7 @@ static Monitor* create_init_monitor(const char* name) {
   return new Monitor(Mutex::safepoint, name);
 }
 
-InstanceKlass::InstanceKlass(const ClassFileParser& parser, KlassKind kind) :
+InstanceKlass::InstanceKlass(const ClassFileParser& parser, KlassKind kind, ReferenceType reference_type) :
   Klass(kind),
   _nest_members(NULL),
   _nest_host(NULL),
@@ -510,7 +508,7 @@ InstanceKlass::InstanceKlass(const ClassFileParser& parser, KlassKind kind) :
   _itable_len(parser.itable_size()),
   _nest_host_index(0),
   _init_state(allocated),
-  _reference_type(parser.reference_type()),
+  _reference_type(reference_type),
   _init_monitor(create_init_monitor("InstanceKlassInitMonitor_lock")),
   _init_thread(NULL)
 {