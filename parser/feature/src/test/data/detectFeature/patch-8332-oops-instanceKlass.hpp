@@ -136,7 +136,7 @@ class InstanceKlass: public Klass {
   static const KlassKind Kind = InstanceKlassKind;
 
  protected:
-  InstanceKlass(const ClassFileParser& parser, KlassKind kind = Kind);
+  InstanceKlass(const ClassFileParser& parser, KlassKind kind = Kind, ReferenceType reference_type = REF_NONE);
 
  public:
   InstanceKlass() { assert(DumpSharedSpaces || UseSharedSpaces, "only for CDS"); }
@@ -592,10 +592,6 @@ class InstanceKlass: public Klass {
 
   // reference type
   ReferenceType reference_type() const     { return (ReferenceType)_reference_type; }
-  void set_reference_type(ReferenceType t) {
-    assert(t == (u1)t, "overflow");
-    _reference_type = (u1)t;
-  }
 
   // this class cp index
   u2 this_class_index() const             { return _this_class_index; }