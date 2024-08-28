@@ -192,13 +192,18 @@ uint ReturnNode::match_edge(uint idx) const {
 
 
 #ifndef PRODUCT
-void ReturnNode::dump_req(outputStream *st) const {
-  // Dump the required inputs, enclosed in '(' and ')'
+void ReturnNode::dump_req(outputStream *st, DumpConfig* dc) const {
+  // Dump the required inputs, after printing "returns"
   uint i;                       // Exit value of loop
   for (i = 0; i < req(); i++) {    // For all required inputs
-    if (i == TypeFunc::Parms) st->print("returns");
-    if (in(i)) st->print("%c%d ", Compile::current()->node_arena()->contains(in(i)) ? ' ' : 'o', in(i)->_idx);
-    else st->print("_ ");
+    if (i == TypeFunc::Parms) st->print("returns ");
+    Node* p = in(i);
+    if (p != nullptr) {
+      p->dump_idx(false, st, dc);
+      st->print(" ");
+    } else {
+      st->print("_ ");
+    }
   }
 }
 #endif
@@ -235,13 +240,18 @@ uint RethrowNode::match_edge(uint idx) const {
 }
 
 #ifndef PRODUCT
-void RethrowNode::dump_req(outputStream *st) const {
-  // Dump the required inputs, enclosed in '(' and ')'
+void RethrowNode::dump_req(outputStream *st, DumpConfig* dc) const {
+  // Dump the required inputs, after printing "exception"
   uint i;                       // Exit value of loop
   for (i = 0; i < req(); i++) {    // For all required inputs
-    if (i == TypeFunc::Parms) st->print("exception");
-    if (in(i)) st->print("%c%d ", Compile::current()->node_arena()->contains(in(i)) ? ' ' : 'o', in(i)->_idx);
-    else st->print("_ ");
+    if (i == TypeFunc::Parms) st->print("exception ");
+    Node* p = in(i);
+    if (p != nullptr) {
+      p->dump_idx(false, st, dc);
+      st->print(" ");
+    } else {
+      st->print("_ ");
+    }
   }
 }
 #endif
@@ -689,13 +699,18 @@ int JVMState::interpreter_frame_size() const {
 bool CallNode::cmp( const Node &n ) const
 { return _tf == ((CallNode&)n)._tf && _jvms == ((CallNode&)n)._jvms; }
 #ifndef PRODUCT
-void CallNode::dump_req(outputStream *st) const {
+void CallNode::dump_req(outputStream *st, DumpConfig* dc) const {
   // Dump the required inputs, enclosed in '(' and ')'
   uint i;                       // Exit value of loop
   for (i = 0; i < req(); i++) {    // For all required inputs
     if (i == TypeFunc::Parms) st->print("(");
-    if (in(i)) st->print("%c%d ", Compile::current()->node_arena()->contains(in(i)) ? ' ' : 'o', in(i)->_idx);
-    else st->print("_ ");
+    Node* p = in(i);
+    if (p != nullptr) {
+      p->dump_idx(false, st, dc);
+      st->print(" ");
+    } else {
+      st->print("_ ");
+    }
   }
   st->print(")");
 }