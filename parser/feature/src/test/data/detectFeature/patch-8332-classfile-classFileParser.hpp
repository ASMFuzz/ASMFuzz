@@ -154,7 +154,6 @@ class ClassFileParser {
 
   int _num_miranda_methods;
 
-  ReferenceType _rt;
   Handle _protection_domain;
   AccessFlags _access_flags;
 
@@ -561,7 +560,10 @@ class ClassFileParser {
   const Symbol* class_name() const { return _class_name; }
   const InstanceKlass* super_klass() const { return _super_klass; }
 
-  ReferenceType reference_type() const { return _rt; }
+  ReferenceType super_reference_type() const;
+  bool is_instance_ref_klass() const;
+  bool is_java_lang_ref_Reference_subclass() const;
+
   AccessFlags access_flags() const { return _access_flags; }
 
   bool is_internal() const { return INTERNAL == _pub_level; }