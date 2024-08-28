@@ -226,10 +226,10 @@ class LoadNode : public MemNode {
   }
 
   // Polymorphic factory method:
-  static Node* make(PhaseGVN& gvn, Node *c, Node *mem, Node *adr,
-                    const TypePtr* at, const Type *rt, BasicType bt,
+  static Node* make(PhaseGVN& gvn, Node* c, Node* mem, Node* adr,
+                    const TypePtr* at, const Type* rt, BasicType bt,
                     MemOrd mo, ControlDependency control_dependency = DependsOnlyOnTest,
-                    bool unaligned = false, bool mismatched = false, bool unsafe = false,
+                    bool require_atomic_access = false, bool unaligned = false, bool mismatched = false, bool unsafe = false,
                     uint8_t barrier_data = 0);
 
   virtual uint hash()   const;  // Check the type
@@ -414,9 +414,7 @@ class LoadLNode : public LoadNode {
   virtual int store_Opcode() const { return Op_StoreL; }
   virtual BasicType memory_type() const { return T_LONG; }
   bool require_atomic_access() const { return _require_atomic_access; }
-  static LoadLNode* make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type,
-                                const Type* rt, MemOrd mo, ControlDependency control_dependency = DependsOnlyOnTest,
-                                bool unaligned = false, bool mismatched = false, bool unsafe = false, uint8_t barrier_data = 0);
+
 #ifndef PRODUCT
   virtual void dump_spec(outputStream *st) const {
     LoadNode::dump_spec(st);
@@ -466,9 +464,7 @@ class LoadDNode : public LoadNode {
   virtual int store_Opcode() const { return Op_StoreD; }
   virtual BasicType memory_type() const { return T_DOUBLE; }
   bool require_atomic_access() const { return _require_atomic_access; }
-  static LoadDNode* make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type,
-                                const Type* rt, MemOrd mo, ControlDependency control_dependency = DependsOnlyOnTest,
-                                bool unaligned = false, bool mismatched = false, bool unsafe = false, uint8_t barrier_data = 0);
+
 #ifndef PRODUCT
   virtual void dump_spec(outputStream *st) const {
     LoadNode::dump_spec(st);
@@ -609,8 +605,9 @@ class StoreNode : public MemNode {
   // procedure must indicate that the store requires `release'
   // semantics, if the stored value is an object reference that might
   // point to a new object and may become externally visible.
-  static StoreNode* make(PhaseGVN& gvn, Node *c, Node *mem, Node *adr,
-                         const TypePtr* at, Node *val, BasicType bt, MemOrd mo);
+  static StoreNode* make(PhaseGVN& gvn, Node* c, Node* mem, Node* adr,
+                         const TypePtr* at, Node* val, BasicType bt,
+                         MemOrd mo, bool require_atomic_access = false);
 
   virtual uint hash() const;    // Check the type
 
@@ -691,7 +688,7 @@ class StoreLNode : public StoreNode {
   virtual int Opcode() const;
   virtual BasicType memory_type() const { return T_LONG; }
   bool require_atomic_access() const { return _require_atomic_access; }
-  static StoreLNode* make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, MemOrd mo);
+
 #ifndef PRODUCT
   virtual void dump_spec(outputStream *st) const {
     StoreNode::dump_spec(st);
@@ -727,7 +724,7 @@ class StoreDNode : public StoreNode {
   virtual int Opcode() const;
   virtual BasicType memory_type() const { return T_DOUBLE; }
   bool require_atomic_access() const { return _require_atomic_access; }
-  static StoreDNode* make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, MemOrd mo);
+
 #ifndef PRODUCT
   virtual void dump_spec(outputStream *st) const {
     StoreNode::dump_spec(st);