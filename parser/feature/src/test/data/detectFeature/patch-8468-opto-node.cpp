@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1696,6 +1696,688 @@ bool Node::add_to_worklist(Node* n, Node_List* worklist, Arena* old_arena, Vecto
   return false;
 }
 
+class PrintBFS {
+public:
+  PrintBFS(Node* start, const int max_distance, Node* target, const char* options)
+  : _start(start), _max_distance(max_distance), _target(target), _options(options),
+    _dcc(this), _info_uid(cmpkey, hashkey) {}
+
+  void run();
+private:
+  // pipeline steps
+  bool configure();
+  void collect();
+  void select();
+  void select_all();
+  void select_all_paths();
+  void select_shortest_path();
+  void sort();
+  void print();
+
+  // inputs
+  Node* _start;
+  const int _max_distance;
+  Node* _target;
+  const char* _options;
+
+  // options
+  bool _traverse_inputs = false;
+  bool _traverse_outputs = false;
+  struct Filter {
+    bool _control = false;
+    bool _memory = false;
+    bool _data = false;
+    bool _mixed = false;
+    bool _other = false;
+    bool is_empty() const {
+      return !(_control || _memory || _data || _mixed || _other);
+    }
+    void set_all() {
+      _control = true;
+      _memory = true;
+      _data = true;
+      _mixed = true;
+      _other = true;
+    }
+  };
+  Filter _filter_visit;
+  Filter _filter_boundary;
+  bool _sort_idx = false;
+  bool _all_paths = false;
+  bool _use_color = false;
+  bool _print_blocks = false;
+  bool _print_old = false;
+  static void print_options_help(bool print_examples);
+  bool parse_options();
+
+  // node category (filter / color)
+  static bool filter_category(Node* n, Filter& filter); // filter node category against options
+public:
+  class DumpConfigColored : public Node::DumpConfig {
+  public:
+    DumpConfigColored(PrintBFS* bfs) : _bfs(bfs) {};
+    virtual void pre_dump(outputStream* st, const Node* n);
+    virtual void post_dump(outputStream* st);
+  private:
+    PrintBFS* _bfs;
+  };
+private:
+  DumpConfigColored _dcc;
+
+  // node info
+  static Node* old_node(Node* n); // mach node -> prior IR node
+  static void print_node_idx(Node* n); // to tty
+  static void print_block_id(Block* b); // to tty
+  static void print_node_block(Node* n); // to tty: _pre_order, head idx, _idom, _dom_depth
+
+  // traversal data structures
+  Node_List _worklist; // BFS queue
+  void maybe_traverse(Node* src, Node* dst);
+
+  // node info annotation
+  class Info {
+  public:
+    Info() : Info(nullptr, 0) {};
+    Info(Node* node, int distance)
+      : _node(node), _distance_from_start(distance) {};
+    Node* node() { return _node; };
+    int distance() const { return _distance_from_start; };
+    int distance_from_target() const { return _distance_from_target; }
+    void set_distance_from_target(int d) { _distance_from_target = d; }
+    Node_List edge_bwd; // pointing toward _start
+    bool is_marked() const { return _mark; } // marked to keep during select
+    void set_mark() { _mark = true; }
+  private:
+    Node* _node;
+    int _distance_from_start; // distance from _start
+    int _distance_from_target = 0; // distance from _target if _all_paths
+    bool _mark = false;
+  };
+  Dict _info_uid;            // Node -> uid
+  GrowableArray<Info> _info; // uid  -> info
+
+  Info* find_info(const Node* n) {
+    size_t uid = (size_t)_info_uid[n];
+    if (uid == 0) {
+      return nullptr;
+    }
+    return &_info.at((int)uid);
+  }
+
+  void make_info(Node* node, const int distance) {
+    assert(find_info(node) == nullptr, "node does not yet have info");
+    size_t uid = _info.length() + 1;
+    _info_uid.Insert(node, (void*)uid);
+    _info.at_put_grow((int)uid, Info(node, distance));
+    assert(find_info(node)->node() == node, "stored correct node");
+  };
+
+  // filled by sort, printed by print
+  GrowableArray<Node*> _print_list;
+
+  // print header + node table
+  void print_header() const;
+  void print_node(Node* n);
+};
+
+void PrintBFS::run() {
+  if (!configure()) {
+    return;
+  }
+  collect();
+  select();
+  sort();
+  print();
+}
+
+// set up configuration for BFS and print
+bool PrintBFS::configure() {
+  if (_max_distance < 0) {
+    tty->print("dump_bfs: max_distance must be non-negative!\n");
+    return false;
+  }
+  return parse_options();
+}
+
+// BFS traverse according to configuration, fill worklist and info
+void PrintBFS::collect() {
+  maybe_traverse(_start, _start);
+  uint pos = 0;
+  while (pos < _worklist.size()) {
+    Node* n = _worklist.at(pos++); // next node to traverse
+    Info* info = find_info(n);
+    if (!filter_category(n, _filter_visit) && n != _start) {
+      continue; // we hit boundary, do not traverse further
+    }
+    if (n != _start && n->is_Root()) {
+      continue; // traversing through root node would lead to unrelated nodes
+    }
+    if (_traverse_inputs && _max_distance > info->distance()) {
+      for (uint i = 0; i < n->req(); i++) {
+        maybe_traverse(n, n->in(i));
+      }
+    }
+    if (_traverse_outputs && _max_distance > info->distance()) {
+      for (uint i = 0; i < n->outcnt(); i++) {
+        maybe_traverse(n, n->raw_out(i));
+      }
+    }
+  }
+}
+
+// go through work list, mark those that we want to print
+void PrintBFS::select() {
+  if (_target == nullptr ) {
+    select_all();
+  } else {
+    if (find_info(_target) == nullptr) {
+      tty->print("Could not find target in BFS.\n");
+      return;
+    }
+    if (_all_paths) {
+      select_all_paths();
+    } else {
+      select_shortest_path();
+    }
+  }
+}
+
+// take all nodes from BFS
+void PrintBFS::select_all() {
+  for (uint i = 0; i < _worklist.size(); i++) {
+    Node* n = _worklist.at(i);
+    Info* info = find_info(n);
+    info->set_mark();
+  }
+}
+
+// traverse backward from target, along edges found in BFS
+void PrintBFS::select_all_paths() {
+  uint pos = 0;
+  Node_List backtrace;
+  // start from target
+  backtrace.push(_target);
+  find_info(_target)->set_mark();
+  // traverse backward
+  while (pos < backtrace.size()) {
+    Node* n = backtrace.at(pos++);
+    Info* info = find_info(n);
+    for (uint i = 0; i < info->edge_bwd.size(); i++) {
+      // all backward edges
+      Node* back = info->edge_bwd.at(i);
+      Info* back_info = find_info(back);
+      if (!back_info->is_marked()) {
+        // not yet found this on way back.
+        back_info->set_distance_from_target(info->distance_from_target() + 1);
+        if (back_info->distance_from_target() + back_info->distance() <= _max_distance) {
+          // total distance is small enough
+          back_info->set_mark();
+          backtrace.push(back);
+        }
+      }
+    }
+  }
+}
+
+void PrintBFS::select_shortest_path() {
+  Node* current = _target;
+  while (true) {
+    Info* info = find_info(current);
+    info->set_mark();
+    if (current == _start) {
+      break;
+    }
+    // first edge -> leads us one step closer to _start
+    current = info->edge_bwd.at(0);
+  }
+}
+
+int node_idx_cmp(Node** n1, Node** n2) {
+  return (*n1)->_idx - (*n2)->_idx;
+}
+
+// go through worklist in desired order, put the marked ones in print list
+void PrintBFS::sort() {
+  if (_traverse_inputs && !_traverse_outputs) {
+    // reverse order
+    for (int i = _worklist.size() - 1; i >= 0; i--) {
+      Node* n = _worklist.at(i);
+      Info* info = find_info(n);
+      if (info->is_marked()) {
+        _print_list.push(n);
+      }
+    }
+  } else {
+    // same order as worklist
+    for (uint i = 0; i < _worklist.size(); i++) {
+      Node* n = _worklist.at(i);
+      Info* info = find_info(n);
+      if (info->is_marked()) {
+        _print_list.push(n);
+      }
+    }
+  }
+  if (_sort_idx) {
+    _print_list.sort(node_idx_cmp);
+  }
+}
+
+// go through printlist and print
+void PrintBFS::print() {
+  if (_print_list.length() > 0 ) {
+    print_header();
+    for (int i = 0; i < _print_list.length(); i++) {
+      Node* n = _print_list.at(i);
+      print_node(n);
+    }
+  } else {
+    tty->print("No nodes to print.\n");
+  }
+}
+
+void PrintBFS::print_options_help(bool print_examples) {
+  tty->print("Usage: node->dump_bfs(int max_distance, Node* target, char* options)\n");
+  tty->print("\n");
+  tty->print("Use cases:\n");
+  tty->print("  BFS traversal: no target required\n");
+  tty->print("  shortest path: set target\n");
+  tty->print("  all paths: set target and put 'A' in options\n");
+  tty->print("  detect loop: subcase of all paths, have start==target\n");
+  tty->print("\n");
+  tty->print("Arguments:\n");
+  tty->print("  this/start: staring point of BFS\n");
+  tty->print("  target:\n");
+  tty->print("    if nullptr: simple BFS\n");
+  tty->print("    else: shortest path or all paths between this/start and target\n");
+  tty->print("  options:\n");
+  tty->print("    if nullptr: same as \"cdmxo@B\"\n");
+  tty->print("    else: use combination of following characters\n");
+  tty->print("      h: display this help info\n");
+  tty->print("      H: display this help info, with examples\n");
+  tty->print("      +: traverse in-edges (on if neither + nor -)\n");
+  tty->print("      -: traverse out-edges\n");
+  tty->print("      c: visit control nodes\n");
+  tty->print("      m: visit memory nodes\n");
+  tty->print("      d: visit data nodes\n");
+  tty->print("      x: visit mixed nodes\n");
+  tty->print("      o: visit other nodes\n");
+  tty->print("      C: boundary control nodes\n");
+  tty->print("      M: boundary memory nodes\n");
+  tty->print("      D: boundary data nodes\n");
+  tty->print("      X: boundary mixed nodes\n");
+  tty->print("      O: boundary other nodes\n");
+  tty->print("      S: sort displayed nodes by node idx\n");
+  tty->print("      A: all paths (not just shortest path to target)\n");
+  tty->print("      #: display node category in color (not supported in all terminals)\n");
+  tty->print("      @: print old nodes - before matching (if available)\n");
+  tty->print("      B: print scheduling blocks (if available)\n");
+  tty->print("\n");
+  tty->print("recursively follow edges to nodes with permitted visit types,\n");
+  tty->print("on the boundary additionally display nodes allowed in boundary types\n");
+  tty->print("\n");
+  tty->print("output columns:\n");
+  tty->print("  dist:  BFS distance to this/start\n");
+  tty->print("  apd:   all paths distance (d_start + d_target)\n");
+  tty->print("  block: block identifier, based on _pre_order\n");
+  tty->print("  head:  first node in block\n");
+  tty->print("  idom:  head node of idom block\n");
+  tty->print("  depth: depth of block (_dom_depth)\n");
+  tty->print("  old:   old IR node - before matching\n");
+  tty->print("  dump:  node->dump()\n");
+  tty->print("\n");
+  tty->print("Note: if none of the \"cmdxo\" characters are in the options string\n");
+  tty->print("      then we set all of them.\n");
+  tty->print("      This allows for short strings like \"#\" for colored input traversal\n");
+  tty->print("      or \"-#\" for colored output traversal.\n");
+  if (print_examples) {
+    tty->print("\n");
+    tty->print("Examples:\n");
+    tty->print("  if->dump_bfs(10, 0, \"+cxo\")\n");
+    tty->print("    starting at some if node, traverse inputs recursively\n");
+    tty->print("    only along control (mixed and other can also be control)\n");
+    tty->print("  phi->dump_bfs(5, 0, \"-dxo\")\n");
+    tty->print("    starting at phi node, traverse outputs recursively\n");
+    tty->print("    only along data (mixed and other can also have data flow)\n");
+    tty->print("  find_node(385)->dump_bfs(3, 0, \"cdmox+#@B\")\n");
+    tty->print("    find inputs of node 385, up to 3 nodes up (+)\n");
+    tty->print("    traverse all nodes (cdmox), use colors (#)\n");
+    tty->print("    display old nodes and blocks, if they exist\n");
+    tty->print("    useful call to start with\n");
+    tty->print("  find_node(102)->dump_bfs(10, 0, \"dCDMOX-\")\n");
+    tty->print("    find non-data dependencies of a data node\n");
+    tty->print("    follow data node outputs until we find another category\n");
+    tty->print("    node as the boundary\n");
+    tty->print("  x->dump_bfs(10, y, 0)\n");
+    tty->print("    find shortest path from x to y, along any edge or node\n");
+    tty->print("    will not find a path if it is longer than 10\n");
+    tty->print("    useful to find how x and y are related\n");
+    tty->print("  find_node(741)->dump_bfs(20, find_node(746), \"c+\")\n");
+    tty->print("    find shortest control path between two nodes\n");
+    tty->print("  find_node(741)->dump_bfs(8, find_node(746), \"cdmxo+A\")\n");
+    tty->print("    find all paths (A) between two nodes of length at most 8\n");
+    tty->print("  find_node(741)->dump_bfs(7, find_node(741), \"c+A\")\n");
+    tty->print("    find all control loops for this node\n");
+  }
+}
+
+bool PrintBFS::parse_options() {
+  if (_options == nullptr) {
+    _options = "cmdxo@B"; // default options
+  }
+  size_t len = strlen(_options);
+  for (size_t i = 0; i < len; i++) {
+    switch (_options[i]) {
+      case '+':
+        _traverse_inputs = true;
+        break;
+      case '-':
+        _traverse_outputs = true;
+        break;
+      case 'c':
+        _filter_visit._control = true;
+        break;
+      case 'm':
+        _filter_visit._memory = true;
+        break;
+      case 'd':
+        _filter_visit._data = true;
+        break;
+      case 'x':
+        _filter_visit._mixed = true;
+        break;
+      case 'o':
+        _filter_visit._other = true;
+        break;
+      case 'C':
+        _filter_boundary._control = true;
+        break;
+      case 'M':
+        _filter_boundary._memory = true;
+        break;
+      case 'D':
+        _filter_boundary._data = true;
+        break;
+      case 'X':
+        _filter_boundary._mixed = true;
+        break;
+      case 'O':
+        _filter_boundary._other = true;
+        break;
+      case 'S':
+        _sort_idx = true;
+        break;
+      case 'A':
+        _all_paths = true;
+        break;
+      case '#':
+        _use_color = true;
+        break;
+      case 'B':
+        _print_blocks = true;
+        break;
+      case '@':
+        _print_old = true;
+        break;
+      case 'h':
+        print_options_help(false);
+        return false;
+       case 'H':
+        print_options_help(true);
+        return false;
+      default:
+        tty->print_cr("dump_bfs: Unrecognized option \'%c\'", _options[i]);
+        tty->print_cr("for help, run: find_node(0)->dump_bfs(0,0,\"H\")");
+        return false;
+    }
+  }
+  if (!_traverse_inputs && !_traverse_outputs) {
+    _traverse_inputs = true;
+  }
+  if (_filter_visit.is_empty()) {
+    _filter_visit.set_all();
+  }
+  Compile* C = Compile::current();
+  _print_old &= (C->matcher() != nullptr); // only show old if there are new
+  _print_blocks &= (C->cfg() != nullptr); // only show blocks if available
+  return true;
+}
+
+bool PrintBFS::filter_category(Node* n, Filter& filter) {
+  const Type* t = n->bottom_type();
+  switch (t->category()) {
+    case Type::Category::Data:
+      return filter._data;
+    case Type::Category::Memory:
+      return filter._memory;
+    case Type::Category::Mixed:
+      return filter._mixed;
+    case Type::Category::Control:
+      return filter._control;
+    case Type::Category::Other:
+      return filter._other;
+    case Type::Category::Undef:
+      n->dump();
+      assert(false, "category undef ??");
+    default:
+      n->dump();
+      assert(false, "not covered");
+  }
+  return false;
+}
+
+void PrintBFS::DumpConfigColored::pre_dump(outputStream* st, const Node* n) {
+  if (!_bfs->_use_color) {
+    return;
+  }
+  Info* info = _bfs->find_info(n);
+  if (info == nullptr || !info->is_marked()) {
+    return;
+  }
+
+  const Type* t = n->bottom_type();
+  switch (t->category()) {
+    case Type::Category::Data:
+      st->print("\u001b[34m");
+      break;
+    case Type::Category::Memory:
+      st->print("\u001b[32m");
+      break;
+    case Type::Category::Mixed:
+      st->print("\u001b[35m");
+      break;
+    case Type::Category::Control:
+      st->print("\u001b[31m");
+      break;
+    case Type::Category::Other:
+      st->print("\u001b[33m");
+      break;
+    case Type::Category::Undef:
+      n->dump();
+      assert(false, "category undef ??");
+      break;
+    default:
+      n->dump();
+      assert(false, "not covered");
+      break;
+  }
+}
+
+void PrintBFS::DumpConfigColored::post_dump(outputStream* st) {
+  if (!_bfs->_use_color) {
+    return;
+  }
+  st->print("\u001b[0m"); // white
+}
+
+Node* PrintBFS::old_node(Node* n) {
+  Compile* C = Compile::current();
+  if (C->matcher() == nullptr || !C->node_arena()->contains(n)) {
+    return (Node*)nullptr;
+  } else {
+    return C->matcher()->find_old_node(n);
+  }
+}
+
+void PrintBFS::print_node_idx(Node* n) {
+  Compile* C = Compile::current();
+  char buf[30];
+  if (n == nullptr) {
+    sprintf(buf,"_");           // null
+  } else if (C->node_arena()->contains(n)) {
+    sprintf(buf, "%d", n->_idx);  // new node
+  } else {
+    sprintf(buf, "o%d", n->_idx); // old node
+  }
+  tty->print("%6s", buf);
+}
+
+void PrintBFS::print_block_id(Block* b) {
+  Compile* C = Compile::current();
+  char buf[30];
+  sprintf(buf, "B%d", b->_pre_order);
+  tty->print("%7s", buf);
+}
+
+void PrintBFS::print_node_block(Node* n) {
+  Compile* C = Compile::current();
+  Block* b = C->node_arena()->contains(n)
+             ? C->cfg()->get_block_for_node(n)
+             : nullptr; // guard against old nodes
+  if (b == nullptr) {
+    tty->print("      _"); // Block
+    tty->print("     _");  // head
+    tty->print("     _");  // idom
+    tty->print("      _"); // depth
+  } else {
+    print_block_id(b);
+    print_node_idx(b->head());
+    if (b->_idom) {
+      print_node_idx(b->_idom->head());
+    } else {
+      tty->print("     _"); // idom
+    }
+    tty->print("%6d ", b->_dom_depth);
+  }
+}
+
+// filter, and add to worklist, add info, note traversal edges
+void PrintBFS::maybe_traverse(Node* src, Node* dst) {
+  if (dst != nullptr &&
+     (filter_category(dst, _filter_visit) ||
+      filter_category(dst, _filter_boundary) ||
+      dst == _start)) { // correct category or start?
+    if (find_info(dst) == nullptr) {
+      // never visited - set up info
+      _worklist.push(dst);
+      int d = 0;
+      if (dst != _start) {
+        d = find_info(src)->distance() + 1;
+      }
+      make_info(dst, d);
+    }
+    if (src != dst) {
+      // traversal edges useful during select
+      find_info(dst)->edge_bwd.push(src);
+    }
+  }
+}
+
+void PrintBFS::print_header() const {
+  tty->print("dist");                         // distance
+  if (_all_paths) {
+    tty->print(" apd");                       // all paths distance
+  }
+  if (_print_blocks) {
+    tty->print(" [block  head  idom depth]"); // block
+  }
+  if (_print_old) {
+    tty->print("   old");                     // old node
+  }
+  tty->print(" dump\n");                      // node dump
+  tty->print("---------------------------------------------\n");
+}
+
+void PrintBFS::print_node(Node* n) {
+  tty->print("%4d", find_info(n)->distance());// distance
+  if (_all_paths) {
+    Info* info = find_info(n);
+    int apd = info->distance() + info->distance_from_target();
+    tty->print("%4d", apd);                   // all paths distance
+  }
+  if (_print_blocks) {
+    print_node_block(n);                      // block
+  }
+  if (_print_old) {
+    print_node_idx(old_node(n));              // old node
+  }
+  tty->print(" ");
+  n->dump("\n", false, tty, &_dcc);           // node dump
+}
+
+//------------------------------dump_bfs--------------------------------------
+// Call this from debugger
+// Useful for BFS traversal, shortest path, all path, loop detection, etc
+// Designed to be more readable, and provide additional info
+// To find all options, run:
+//   find_node(0)->dump_bfs(0,0,"H")
+void Node::dump_bfs(const int max_distance, Node* target, const char* options) {
+  PrintBFS bfs(this, max_distance, target, options);
+  bfs.run();
+}
+
+// Call this from debugger, with default arguments
+void Node::dump_bfs(const int max_distance) {
+  dump_bfs(max_distance, nullptr, nullptr);
+}
+
+// log10 rounded down
+uint log10(const uint i) {
+  uint v = 10;
+  uint e = 0;
+  while(v <= i) {
+    v *= 10;
+    e++;
+  }
+  return e;
+}
+
+// -----------------------------dump_idx---------------------------------------
+void Node::dump_idx(bool align, outputStream* st, DumpConfig* dc) const {
+  if (dc != nullptr) {
+    dc->pre_dump(st, this);
+  }
+  Compile* C = Compile::current();
+  bool is_new = C->node_arena()->contains(this);
+  if (align) { // print prefix empty spaces$
+    // +1 for leading digit, +1 for "o"
+    uint max_width = log10(C->unique()) + 2;
+    // +1 for leading digit, maybe +1 for "o"
+    uint width = log10(_idx) + 1 + (is_new ? 0 : 1);
+    while (max_width > width) {
+      st->print(" ");
+      width++;
+    }
+  }
+  if (!is_new) {
+    st->print("o");
+  }
+  st->print("%d", _idx);
+  if (dc != nullptr) {
+    dc->post_dump(st);
+  }
+}
+
+// -----------------------------dump_name--------------------------------------
+void Node::dump_name(outputStream* st, DumpConfig* dc) const {
+  if (dc != nullptr) {
+    dc->pre_dump(st, this);
+  }
+  st->print("%s", Name());
+  if (dc != nullptr) {
+    dc->post_dump(st);
+  }
+}
+
 // -----------------------------Name-------------------------------------------
 extern const char *NodeClassNames[];
 const char *Node::Name() const { return NodeClassNames[Opcode()]; }
@@ -1766,7 +2448,7 @@ void Node::set_debug_orig(Node* orig) {
 
 //------------------------------dump------------------------------------------
 // Dump a Node
-void Node::dump(const char* suffix, bool mark, outputStream *st) const {
+void Node::dump(const char* suffix, bool mark, outputStream* st, DumpConfig* dc) const {
   Compile* C = Compile::current();
   bool is_new = C->node_arena()->contains(this);
   C->_in_dump_cnt++;
@@ -1775,13 +2457,17 @@ void Node::dump(const char* suffix, bool mark, outputStream *st) const {
     st->print("%*s", (_indent << 1), "  ");
   }
 
-  st->print("%c%d%s%s  === ", is_new ? ' ' : 'o', _idx, mark ? " >" : "  ", Name());
+  // idx mark name ===
+  dump_idx(true, st, dc);
+  st->print(mark ? " >" : "  ");
+  dump_name(st, dc);
+  st->print("  === ");
 
   // Dump the required and precedence inputs
-  dump_req(st);
-  dump_prec(st);
+  dump_req(st, dc);
+  dump_prec(st, dc);
   // Dump the outputs
-  dump_out(st);
+  dump_out(st, dc);
 
   if (is_disconnected(this)) {
 #ifdef ASSERT
@@ -1848,7 +2534,7 @@ void Node::dump(const char* suffix, bool mark, outputStream *st) const {
 }
 
 //------------------------------dump_req--------------------------------------
-void Node::dump_req(outputStream *st) const {
+void Node::dump_req(outputStream* st, DumpConfig* dc) const {
   // Dump the required input edges
   for (uint i = 0; i < req(); i++) {    // For all required inputs
     Node* d = in(i);
@@ -1857,30 +2543,32 @@ void Node::dump_req(outputStream *st) const {
     } else if (not_a_node(d)) {
       st->print("not_a_node ");  // uninitialized, sentinel, garbage, etc.
     } else {
-      st->print("%c%d ", Compile::current()->node_arena()->contains(d) ? ' ' : 'o', d->_idx);
+      d->dump_idx(false, st, dc);
+      st->print(" ");
     }
   }
 }
 
 
 //------------------------------dump_prec-------------------------------------
-void Node::dump_prec(outputStream *st) const {
+void Node::dump_prec(outputStream* st, DumpConfig* dc) const {
   // Dump the precedence edges
   int any_prec = 0;
   for (uint i = req(); i < len(); i++) {       // For all precedence inputs
     Node* p = in(i);
     if (p != NULL) {
       if (!any_prec++) st->print(" |");
       if (not_a_node(p)) { st->print("not_a_node "); continue; }
-      st->print("%c%d ", Compile::current()->node_arena()->contains(in(i)) ? ' ' : 'o', in(i)->_idx);
+      p->dump_idx(false, st, dc);
+      st->print(" ");
     }
   }
 }
 
 //------------------------------dump_out--------------------------------------
-void Node::dump_out(outputStream *st) const {
+void Node::dump_out(outputStream* st, DumpConfig* dc) const {
   // Delimit the output edges
-  st->print(" [[");
+  st->print(" [[ ");
   // Dump the output edges
   for (uint i = 0; i < _outcnt; i++) {    // For all outputs
     Node* u = _out[i];
@@ -1889,7 +2577,8 @@ void Node::dump_out(outputStream *st) const {
     } else if (not_a_node(u)) {
       st->print("not_a_node ");
     } else {
-      st->print("%c%d ", Compile::current()->node_arena()->contains(u) ? ' ' : 'o', u->_idx);
+      u->dump_idx(false, st, dc);
+      st->print(" ");
     }
   }
   st->print("]] ");