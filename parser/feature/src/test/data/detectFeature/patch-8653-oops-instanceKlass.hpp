@@ -574,9 +574,6 @@ class InstanceKlass: public Klass {
   void link_methods(TRAPS);
   Method* class_initializer() const;
 
-  // set the class to initialized if no static initializer is present
-  void eager_initialize(Thread *thread);
-
   // reference type
   ReferenceType reference_type() const     { return (ReferenceType)_reference_type; }
   void set_reference_type(ReferenceType t) {
@@ -1179,7 +1176,6 @@ class InstanceKlass: public Klass {
   bool verify_code                               (TRAPS);
   void initialize_impl                           (TRAPS);
   void initialize_super_interfaces               (TRAPS);
-  void eager_initialize_impl                     ();
 
   void add_initialization_error(JavaThread* current, Handle exception);
   oop get_initialization_error(JavaThread* current);