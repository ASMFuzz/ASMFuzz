@@ -3509,6 +3509,11 @@ void Compile::final_graph_reshaping_main_switch(Node* n, Final_Reshape_Counts& f
           UDivModINode* divmod = UDivModINode::make(n);
           d->subsume_by(divmod->div_proj(), this);
           n->subsume_by(divmod->mod_proj(), this);
+        } else {
+          // replace a%b with a-((a/b)*b)
+          Node* mult = new MulINode(d, d->in(2));
+          Node* sub  = new SubINode(d->in(1), mult);
+          n->subsume_by(sub, this);
         }
       }
     }
@@ -3524,6 +3529,11 @@ void Compile::final_graph_reshaping_main_switch(Node* n, Final_Reshape_Counts& f
           UDivModLNode* divmod = UDivModLNode::make(n);
           d->subsume_by(divmod->div_proj(), this);
           n->subsume_by(divmod->mod_proj(), this);
+        } else {
+          // replace a%b with a-((a/b)*b)
+          Node* mult = new MulLNode(d, d->in(2));
+          Node* sub  = new SubLNode(d->in(1), mult);
+          n->subsume_by(sub, this);
         }
       }
     }