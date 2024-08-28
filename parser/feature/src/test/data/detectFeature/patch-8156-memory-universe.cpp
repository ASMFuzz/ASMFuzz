@@ -84,6 +84,7 @@
 // Known objects
 Klass* Universe::_typeArrayKlassObjs[T_LONG+1]        = { NULL /*, NULL...*/ };
 Klass* Universe::_objectArrayKlassObj                 = NULL;
+Klass* Universe::_fillerArrayKlassObj                 = NULL;
 OopHandle Universe::_mirrors[T_VOID+1];
 
 OopHandle Universe::_main_thread_group;
@@ -200,13 +201,19 @@ void Universe::basic_type_classes_do(KlassClosure *closure) {
   for (int i = T_BOOLEAN; i < T_LONG+1; i++) {
     closure->do_klass(_typeArrayKlassObjs[i]);
   }
+  // We don't do the following because it will confuse JVMTI.
+  // _fillerArrayKlassObj is used only by GC, which doesn't need to see
+  // this klass from basic_type_classes_do().
+  //
+  // closure->do_klass(_fillerArrayKlassObj);
 }
 
 void LatestMethodCache::metaspace_pointers_do(MetaspaceClosure* it) {
   it->push(&_klass);
 }
 
 void Universe::metaspace_pointers_do(MetaspaceClosure* it) {
+  it->push(&_fillerArrayKlassObj);
   for (int i = 0; i < T_LONG+1; i++) {
     it->push(&_typeArrayKlassObjs[i]);
   }
@@ -255,6 +262,7 @@ void Universe::serialize(SerializeClosure* f) {
   }
 #endif
 
+  f->do_ptr((void**)&_fillerArrayKlassObj);
   for (int i = 0; i < T_LONG+1; i++) {
     f->do_ptr((void**)&_typeArrayKlassObjs[i]);
   }
@@ -314,6 +322,10 @@ void Universe::genesis(TRAPS) {
       compute_base_vtable_size();
 
       if (!UseSharedSpaces) {
+        // Initialization of the fillerArrayKlass must come before regular
+        // int-TypeArrayKlass so that the int-Array mirror points to the
+        // int-TypeArrayKlass.
+        _fillerArrayKlassObj = TypeArrayKlass::create_klass(T_INT, "Ljava/internal/vm/FillerArray;", CHECK);
         for (int i = T_BOOLEAN; i < T_LONG+1; i++) {
           _typeArrayKlassObjs[i] = TypeArrayKlass::create_klass((BasicType)i, CHECK);
         }
@@ -355,6 +367,8 @@ void Universe::genesis(TRAPS) {
       _the_array_interfaces_array->at_put(1, vmClasses::Serializable_klass());
     }
 
+    initialize_basic_type_klass(_fillerArrayKlassObj, CHECK);
+
     initialize_basic_type_klass(boolArrayKlassObj(), CHECK);
     initialize_basic_type_klass(charArrayKlassObj(), CHECK);
     initialize_basic_type_klass(floatArrayKlassObj(), CHECK);
@@ -363,6 +377,9 @@ void Universe::genesis(TRAPS) {
     initialize_basic_type_klass(shortArrayKlassObj(), CHECK);
     initialize_basic_type_klass(intArrayKlassObj(), CHECK);
     initialize_basic_type_klass(longArrayKlassObj(), CHECK);
+
+    assert(_fillerArrayKlassObj != intArrayKlassObj(),
+           "Internal filler array klass should be different to int array Klass");
   } // end of core bootstrapping
 
   {