@@ -1588,25 +1588,51 @@ jfloat Node::getf() const {
 #ifndef PRODUCT
 
 // Call this from debugger:
+Node* old_root() {
+  Matcher* matcher = Compile::current()->matcher();
+  if (matcher != nullptr) {
+    Node* new_root = Compile::current()->root();
+    Node* old_root = matcher->find_old_node(new_root);
+    if (old_root != nullptr) {
+      return old_root;
+    }
+  }
+  tty->print("old_root: not found.\n");
+  return nullptr;
+}
+
+// Call this from debugger, search in same graph as n:
 Node* find_node(Node* n, const int idx) {
   return n->find(idx);
 }
 
-// Call this from debugger with root node as default:
+// Call this from debugger, search in new nodes:
 Node* find_node(const int idx) {
   return Compile::current()->root()->find(idx);
 }
 
-// Call this from debugger:
+// Call this from debugger, search in old nodes:
+Node* find_old_node(const int idx) {
+  Node* root = old_root();
+  return (root == nullptr) ? nullptr : root->find(idx);
+}
+
+// Call this from debugger, search in same graph as n:
 Node* find_ctrl(Node* n, const int idx) {
   return n->find_ctrl(idx);
 }
 
-// Call this from debugger with root node as default:
+// Call this from debugger, search in new nodes:
 Node* find_ctrl(const int idx) {
   return Compile::current()->root()->find_ctrl(idx);
 }
 
+// Call this from debugger, search in old nodes:
+Node* find_old_ctrl(const int idx) {
+  Node* root = old_root();
+  return (root == nullptr) ? nullptr : root->find_ctrl(idx);
+}
+
 //------------------------------find_ctrl--------------------------------------
 // Find an ancestor to this node in the control history with given _idx
 Node* Node::find_ctrl(int idx) {
@@ -1652,13 +1678,6 @@ Node* Node::find(const int idx, bool only_ctrl) {
         add_to_worklist(n->raw_out(i), &worklist, old_arena, &old_space, &new_space);
       }
     }
-#ifdef ASSERT
-    // Search along debug_orig edges last
-    Node* orig = n->debug_orig();
-    while (orig != NULL && add_to_worklist(orig, &worklist, old_arena, &old_space, &new_space)) {
-      orig = orig->debug_orig();
-    }
-#endif // ASSERT
   }
   return result;
 }