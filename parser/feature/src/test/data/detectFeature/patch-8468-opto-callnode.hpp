@@ -128,7 +128,7 @@ class ReturnNode : public Node {
   virtual uint ideal_reg() const { return NotAMachineReg; }
   virtual uint match_edge(uint idx) const;
 #ifndef PRODUCT
-  virtual void dump_req(outputStream *st = tty) const;
+  virtual void dump_req(outputStream *st = tty, DumpConfig* dc = nullptr) const;
 #endif
 };
 
@@ -149,7 +149,7 @@ class RethrowNode : public Node {
   virtual uint match_edge(uint idx) const;
   virtual uint ideal_reg() const { return NotAMachineReg; }
 #ifndef PRODUCT
-  virtual void dump_req(outputStream *st = tty) const;
+  virtual void dump_req(outputStream *st = tty, DumpConfig* dc = nullptr) const;
 #endif
 };
 
@@ -656,7 +656,7 @@ class CallNode : public SafePointNode {
   virtual void copy_call_debug_info(PhaseIterGVN* phase, SafePointNode* sfpt) {}
 
 #ifndef PRODUCT
-  virtual void        dump_req(outputStream* st = tty) const;
+  virtual void        dump_req(outputStream* st = tty, DumpConfig* dc = nullptr) const;
   virtual void        dump_spec(outputStream* st) const;
 #endif
 };