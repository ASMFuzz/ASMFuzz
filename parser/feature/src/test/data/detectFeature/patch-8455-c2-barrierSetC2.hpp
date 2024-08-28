@@ -168,22 +168,19 @@ class C2ParseAccess: public C2Access {
 class C2AtomicParseAccess: public C2ParseAccess {
   Node* _memory;
   uint  _alias_idx;
-  bool  _needs_pinning;
 
 public:
   C2AtomicParseAccess(GraphKit* kit, DecoratorSet decorators, BasicType type,
                  Node* base, C2AccessValuePtr& addr, uint alias_idx) :
     C2ParseAccess(kit, decorators, type, base, addr),
     _memory(NULL),
-    _alias_idx(alias_idx),
-    _needs_pinning(true) {}
+    _alias_idx(alias_idx) {}
 
   // Set the memory node based on the current memory slice.
   virtual void set_memory();
 
   Node* memory() const       { return _memory; }
   uint alias_idx() const     { return _alias_idx; }
-  bool needs_pinning() const { return _needs_pinning; }
 };
 
 // C2Access for optimization time calls to the BarrierSetC2 backend.