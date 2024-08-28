@@ -23,11 +23,43 @@
  */
 
 #include "precompiled.hpp"
+#include "classfile/classFileParser.hpp"
 #include "classfile/javaClasses.hpp"
 #include "classfile/vmClasses.hpp"
+#include "classfile/vmSymbols.hpp"
 #include "oops/instanceRefKlass.inline.hpp"
 #include "oops/oop.inline.hpp"
 
+static ReferenceType reference_subclass_name_to_type(const Symbol* name) {
+  if (       name == vmSymbols::java_lang_ref_SoftReference()) {
+    return REF_SOFT;
+  } else if (name == vmSymbols::java_lang_ref_WeakReference()) {
+    return REF_WEAK;
+  } else if (name == vmSymbols::java_lang_ref_FinalReference()) {
+    return REF_FINAL;
+  } else if (name == vmSymbols::java_lang_ref_PhantomReference()) {
+    return REF_PHANTOM;
+  } else {
+    ShouldNotReachHere();
+    return REF_NONE;
+  }
+}
+
+static ReferenceType determine_reference_type(const ClassFileParser& parser) {
+  const ReferenceType rt = parser.super_reference_type();
+  if (rt != REF_NONE) {
+    // Inherit type from super class
+    return rt;
+  }
+
+  // Bootstrapping: this is one of the direct subclasses of java.lang.ref.Reference
+  const Symbol* const name = parser.class_name();
+  return reference_subclass_name_to_type(name);
+}
+
+InstanceRefKlass::InstanceRefKlass(const ClassFileParser& parser)
+  : InstanceKlass(parser, Kind, determine_reference_type(parser)) {}
+
 void InstanceRefKlass::update_nonstatic_oop_maps(Klass* k) {
   // Clear the nonstatic oop-map entries corresponding to referent
   // and discovered fields.  They are treated specially by the