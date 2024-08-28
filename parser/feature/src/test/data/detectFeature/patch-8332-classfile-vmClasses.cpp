@@ -168,7 +168,7 @@ void vmClasses::resolve_all(TRAPS) {
 
   if (UseSharedSpaces) {
     // These should already have been initialized during CDS dump.
-    assert(vmClasses::Reference_klass()->reference_type() == REF_OTHER, "sanity");
+    assert(vmClasses::Reference_klass()->reference_type() == REF_NONE, "sanity");
     assert(vmClasses::SoftReference_klass()->reference_type() == REF_SOFT, "sanity");
     assert(vmClasses::WeakReference_klass()->reference_type() == REF_WEAK, "sanity");
     assert(vmClasses::FinalReference_klass()->reference_type() == REF_FINAL, "sanity");
@@ -186,14 +186,9 @@ void vmClasses::resolve_all(TRAPS) {
     java_lang_ref_Reference::compute_offsets();
 
     // Preload ref klasses and set reference types
-    vmClasses::Reference_klass()->set_reference_type(REF_OTHER);
     InstanceRefKlass::update_nonstatic_oop_maps(vmClasses::Reference_klass());
 
     resolve_through(VM_CLASS_ID(PhantomReference_klass), scan, CHECK);
-    vmClasses::SoftReference_klass()->set_reference_type(REF_SOFT);
-    vmClasses::WeakReference_klass()->set_reference_type(REF_WEAK);
-    vmClasses::FinalReference_klass()->set_reference_type(REF_FINAL);
-    vmClasses::PhantomReference_klass()->set_reference_type(REF_PHANTOM);
   }
 
   resolve_until(vmClassID::LIMIT, scan, CHECK);