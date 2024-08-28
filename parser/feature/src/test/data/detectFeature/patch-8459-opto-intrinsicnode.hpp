@@ -262,4 +262,22 @@ class SignumFNode : public Node {
   virtual uint ideal_reg() const { return Op_RegF; }
 };
 
+//---------- IsInfiniteFNode -----------------------------------------------------
+class IsInfiniteFNode : public Node {
+  public:
+  IsInfiniteFNode(Node* in1) : Node(0, in1) {}
+  virtual int   Opcode() const;
+  const Type* bottom_type() const { return TypeInt::BOOL; }
+  virtual uint ideal_reg() const { return Op_RegI; }
+};
+
+//---------- IsInfiniteDNode -----------------------------------------------------
+class IsInfiniteDNode : public Node {
+  public:
+  IsInfiniteDNode(Node* in1) : Node(0, in1) {}
+  virtual int   Opcode() const;
+  const Type* bottom_type() const { return TypeInt::BOOL; }
+  virtual uint ideal_reg() const { return Op_RegI; }
+};
+
 #endif // SHARE_OPTO_INTRINSICNODE_HPP