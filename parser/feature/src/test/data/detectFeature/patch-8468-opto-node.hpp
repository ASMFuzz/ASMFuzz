@@ -1190,16 +1190,26 @@ class Node {
 public:
   Node* find(int idx, bool only_ctrl = false); // Search the graph for the given idx.
   Node* find_ctrl(int idx); // Search control ancestors for the given idx.
+  void dump_bfs(const int max_distance, Node* target, const char* options); // Print BFS traversal
+  void dump_bfs(const int max_distance); // dump_bfs(max_distance, nullptr, nullptr)
+  class DumpConfig {
+  public:
+    // overridden to implement coloring of node idx
+    virtual void pre_dump(outputStream *st, const Node* n) = 0;
+    virtual void post_dump(outputStream *st) = 0;
+  };
+  void dump_idx(bool align = false, outputStream* st = tty, DumpConfig* dc = nullptr) const;
+  void dump_name(outputStream* st = tty, DumpConfig* dc = nullptr) const;
   void dump() const { dump("\n"); }  // Print this node.
-  void dump(const char* suffix, bool mark = false, outputStream *st = tty) const; // Print this node.
+  void dump(const char* suffix, bool mark = false, outputStream* st = tty, DumpConfig* dc = nullptr) const; // Print this node.
   void dump(int depth) const;        // Print this node, recursively to depth d
   void dump_ctrl(int depth) const;   // Print control nodes, to depth d
   void dump_comp() const;            // Print this node in compact representation.
   // Print this node in compact representation.
   void dump_comp(const char* suffix, outputStream *st = tty) const;
-  virtual void dump_req(outputStream *st = tty) const;    // Print required-edge info
-  virtual void dump_prec(outputStream *st = tty) const;   // Print precedence-edge info
-  virtual void dump_out(outputStream *st = tty) const;    // Print the output edge info
+  virtual void dump_req(outputStream* st = tty, DumpConfig* dc = nullptr) const;    // Print required-edge info
+  virtual void dump_prec(outputStream* st = tty, DumpConfig* dc = nullptr) const;   // Print precedence-edge info
+  virtual void dump_out(outputStream* st = tty, DumpConfig* dc = nullptr) const;    // Print the output edge info
   virtual void dump_spec(outputStream *st) const {};      // Print per-node info
   // Print compact per-node info
   virtual void dump_compact_spec(outputStream *st) const { dump_spec(st); }