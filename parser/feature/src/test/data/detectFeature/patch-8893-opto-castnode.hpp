@@ -159,6 +159,7 @@ class CastPPNode: public ConstraintCastNode {
   public:
   CastPPNode (Node *n, const Type *t, DependencyType dependency = RegularDependency)
     : ConstraintCastNode(n, t, dependency) {
+      init_class_id(Class_CastPP);
   }
   virtual int Opcode() const;
   virtual uint ideal_reg() const { return Op_RegP; }