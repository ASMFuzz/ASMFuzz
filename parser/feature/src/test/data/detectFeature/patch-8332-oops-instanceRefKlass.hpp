@@ -53,7 +53,7 @@ class InstanceRefKlass: public InstanceKlass {
   static const KlassKind Kind = InstanceRefKlassKind;
 
  private:
-  InstanceRefKlass(const ClassFileParser& parser) : InstanceKlass(parser, Kind) {}
+  InstanceRefKlass(const ClassFileParser& parser);
 
  public:
   InstanceRefKlass() { assert(DumpSharedSpaces || UseSharedSpaces, "only for CDS"); }