@@ -103,7 +103,7 @@ class UDivINode : public Node {
   virtual uint ideal_reg() const { return Op_RegI; }
 };
 
-//------------------------------UDivLNode---------------------------------------
+//------------------------------UDivLNode--------------------------------------
 // Unsigned long division
 class UDivLNode : public Node {
 public:
@@ -116,6 +116,24 @@ class UDivLNode : public Node {
   virtual uint ideal_reg() const { return Op_RegL; }
 };
 
+//---------------------------NoOvfDivINode-------------------------------------
+// Non-overflow integer division, UB when dividend == min_jint and divisor == -1
+// so user has to ensure this combination does not appear
+class NoOvfDivINode : public DivINode {
+public:
+  NoOvfDivINode( Node *c, Node *dividend, Node *divisor ) : DivINode(c, dividend, divisor ) {}
+  virtual int Opcode() const;
+};
+
+//---------------------------NoOvfDivLNode-------------------------------------
+// Non-overflow long division, UB when dividend == min_jlong and divisor == -1
+// so user has to ensure this combination does not appear
+class NoOvfDivLNode : public DivLNode {
+public:
+  NoOvfDivLNode( Node *c, Node *dividend, Node *divisor ) : DivLNode(c, dividend, divisor ) {}
+  virtual int Opcode() const;
+};
+
 //------------------------------ModINode---------------------------------------
 // Integer modulus
 class ModINode : public Node {
@@ -162,7 +180,7 @@ class ModDNode : public Node {
   virtual uint ideal_reg() const { return Op_RegD; }
 };
 
-//------------------------------UModINode---------------------------------------
+//------------------------------UModINode--------------------------------------
 // Unsigned integer modulus
 class UModINode : public Node {
 public:
@@ -173,7 +191,7 @@ class UModINode : public Node {
   virtual uint ideal_reg() const { return Op_RegI; }
 };
 
-//------------------------------UModLNode---------------------------------------
+//------------------------------UModLNode--------------------------------------
 // Unsigned long modulus
 class UModLNode : public Node {
 public:
@@ -184,7 +202,25 @@ class UModLNode : public Node {
   virtual uint ideal_reg() const { return Op_RegL; }
 };
 
-//------------------------------DivModNode---------------------------------------
+//---------------------------NoOvfModINode-------------------------------------
+// Non-overflow integer modulus, UB when dividend == min_jint and divisor == -1
+// so user has to ensure this combination does not appear
+class NoOvfModINode : public ModINode {
+public:
+  NoOvfModINode( Node *c, Node *dividend, Node *divisor ) : ModINode(c, dividend, divisor ) {}
+  virtual int Opcode() const;
+};
+
+//---------------------------NoOvfModLNode-------------------------------------
+// Non-overflow long modulus, UB when dividend == min_jlong and divisor == -1
+// so user has to ensure this combination does not appear
+class NoOvfModLNode : public ModLNode {
+public:
+  NoOvfModLNode( Node *c, Node *dividend, Node *divisor ) : ModLNode(c, dividend, divisor ) {}
+  virtual int Opcode() const;
+};
+
+//-----------------------------DivModNode--------------------------------------
 // Division with remainder result.
 class DivModNode : public MultiNode {
 protected:
@@ -206,7 +242,7 @@ class DivModNode : public MultiNode {
   ProjNode* mod_proj() { return proj_out_or_null(mod_proj_num); }
 };
 
-//------------------------------DivModINode---------------------------------------
+//-----------------------------DivModINode-------------------------------------
 // Integer division with remainder result.
 class DivModINode : public DivModNode {
 public:
@@ -219,7 +255,7 @@ class DivModINode : public DivModNode {
   static DivModINode* make(Node* div_or_mod);
 };
 
-//------------------------------DivModLNode---------------------------------------
+//-----------------------------DivModLNode-------------------------------------
 // Long division with remainder result.
 class DivModLNode : public DivModNode {
 public:
@@ -233,7 +269,7 @@ class DivModLNode : public DivModNode {
 };
 
 
-//------------------------------UDivModINode---------------------------------------
+//----------------------------UDivModINode-------------------------------------
 // Unsigend integer division with remainder result.
 class UDivModINode : public DivModNode {
 public:
@@ -246,7 +282,7 @@ class UDivModINode : public DivModNode {
   static UDivModINode* make(Node* div_or_mod);
 };
 
-//------------------------------UDivModLNode---------------------------------------
+//----------------------------UDivModLNode-------------------------------------
 // Unsigned long division with remainder result.
 class UDivModLNode : public DivModNode {
 public:
@@ -259,4 +295,28 @@ class UDivModLNode : public DivModNode {
   static UDivModLNode* make(Node* div_or_mod);
 };
 
+//---------------------------NoOvfDivModINode----------------------------------
+// Non-overflow integer division with remainder result, UB when dividend == min_jint
+// and divisor == -1 so user has to ensure this combination does not appear
+class NoOvfDivModINode : public DivModINode {
+public:
+  NoOvfDivModINode( Node *c, Node *dividend, Node *divisor ) : DivModINode(c, dividend, divisor) {}
+  virtual int Opcode() const;
+
+  // Make a divmod and associated projections from a div or mod.
+  static NoOvfDivModINode* make(Node* div_or_mod);
+};
+
+//---------------------------NoOvfDivModLNode----------------------------------
+// Non-overflow long division with remainder result, UB when dividend == min_jlong
+// and divisor == -1 so user has to ensure this combination does not appear
+class NoOvfDivModLNode : public DivModLNode {
+public:
+  NoOvfDivModLNode( Node *c, Node *dividend, Node *divisor ) : DivModLNode(c, dividend, divisor) {}
+  virtual int Opcode() const;
+
+  // Make a divmod and associated projections from a div or mod.
+  static NoOvfDivModLNode* make(Node* div_or_mod);
+};
+
 #endif // SHARE_OPTO_DIVNODE_HPP