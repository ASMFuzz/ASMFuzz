@@ -3529,6 +3529,46 @@ void Compile::final_graph_reshaping_main_switch(Node* n, Final_Reshape_Counts& f
     }
     break;
 
+  case Op_NoOvfModI:
+    if (UseDivMod) {
+      // Check if a%b and a/b both exist
+      Node* d = n->find_similar(Op_NoOvfDivI);
+      if (d) {
+        // Replace them with a fused divmod if supported
+        if (Matcher::has_match_rule(Op_NoOvfDivModI)) {
+          NoOvfDivModINode* divmod = NoOvfDivModINode::make(n);
+          d->subsume_by(divmod->div_proj(), this);
+          n->subsume_by(divmod->mod_proj(), this);
+        } else {
+          // replace a%b with a-((a/b)*b)
+          Node* mult = new MulINode(d, d->in(2));
+          Node* sub  = new SubINode(d->in(1), mult);
+          n->subsume_by(sub, this);
+        }
+      }
+    }
+    break;
+
+  case Op_NoOvfModL:
+    if (UseDivMod) {
+      // Check if a%b and a/b both exist
+      Node* d = n->find_similar(Op_NoOvfDivL);
+      if (d) {
+        // Replace them with a fused divmod if supported
+        if (Matcher::has_match_rule(Op_NoOvfDivModL)) {
+          NoOvfDivModLNode* divmod = NoOvfDivModLNode::make(n);
+          d->subsume_by(divmod->div_proj(), this);
+          n->subsume_by(divmod->mod_proj(), this);
+        } else {
+          // replace a%b with a-((a/b)*b)
+          Node* mult = new MulLNode(d, d->in(2));
+          Node* sub  = new SubLNode(d->in(1), mult);
+          n->subsume_by(sub, this);
+        }
+      }
+    }
+    break;
+
   case Op_LoadVector:
   case Op_StoreVector:
   case Op_LoadVectorGather: