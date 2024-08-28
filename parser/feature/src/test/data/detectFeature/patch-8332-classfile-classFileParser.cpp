@@ -5577,7 +5577,6 @@ ClassFileParser::ClassFileParser(ClassFileStream* stream,
   _vtable_size(0),
   _itable_size(0),
   _num_miranda_methods(0),
-  _rt(REF_NONE),
   _protection_domain(cl_info->protection_domain()),
   _access_flags(),
   _pub_level(pub_level),
@@ -6058,10 +6057,6 @@ void ClassFileParser::post_process_parsed_stream(const ClassFileStream* const st
   FieldLayoutBuilder lb(class_name(), super_klass(), _cp, _fields,
                         _parsed_annotations->is_contended(), _field_info);
   lb.build_layout();
-
-  // Compute reference typ
-  _rt = (NULL ==_super_klass) ? REF_NONE : _super_klass->reference_type();
-
 }
 
 void ClassFileParser::set_klass(InstanceKlass* klass) {
@@ -6093,6 +6088,33 @@ const ClassFileStream* ClassFileParser::clone_stream() const {
 
   return _stream->clone();
 }
+
+ReferenceType ClassFileParser::super_reference_type() const {
+  return _super_klass == NULL ? REF_NONE : _super_klass->reference_type();
+}
+
+bool ClassFileParser::is_instance_ref_klass() const {
+  // Only the subclasses of j.l.r.Reference are InstanceRefKlass.
+  // j.l.r.Reference itself is InstanceKlass because InstanceRefKlass denotes a
+  // klass requiring special treatment in ref-processing. The abstract
+  // j.l.r.Reference cannot be instantiated so doesn't partake in
+  // ref-processing.
+  return is_java_lang_ref_Reference_subclass();
+}
+
+bool ClassFileParser::is_java_lang_ref_Reference_subclass() const {
+  if (_super_klass == NULL) {
+    return false;
+  }
+
+  if (_super_klass->name() == vmSymbols::java_lang_ref_Reference()) {
+    // Direct subclass of j.l.r.Reference: Soft|Weak|Final|Phantom
+    return true;
+  }
+
+  return _super_klass->reference_type() != REF_NONE;
+}
+
 // ----------------------------------------------------------------------------
 // debugging
 