@@ -651,6 +651,24 @@ void ConnectionGraph::add_node_to_connection_graph(Node *n, Unique_Node_List *de
       add_java_object(n, PointsToNode::ArgEscape);
       break;
     }
+    case Op_Blackhole: {
+      // All blackhole pointer arguments are globally escaping.
+      // Only do this if there is at least one pointer argument.
+      // Do not add edges during first iteration because some could be
+      // not defined yet, defer to final step.
+      for (uint i = 0; i < n->req(); i++) {
+        Node* in = n->in(i);
+        if (in != nullptr) {
+          const Type* at = _igvn->type(in);
+          if (!at->isa_ptr()) continue;
+
+          add_local_var(n, PointsToNode::GlobalEscape);
+          delayed_worklist->push(n);
+          break;
+        }
+      }
+      break;
+    }
     default:
       ; // Do nothing for nodes not related to EA.
   }
@@ -800,6 +818,26 @@ void ConnectionGraph::add_final_edges(Node *n) {
       }
       break;
     }
+    case Op_Blackhole: {
+      // All blackhole pointer arguments are globally escaping.
+      for (uint i = 0; i < n->req(); i++) {
+        Node* in = n->in(i);
+        if (in != nullptr) {
+          const Type* at = _igvn->type(in);
+          if (!at->isa_ptr()) continue;
+
+          if (in->is_AddP()) {
+            in = get_addp_base(in);
+          }
+
+          PointsToNode* ptn = ptnode_adr(in->_idx);
+          assert(ptn != nullptr, "should be defined already");
+          set_escape_state(ptn, PointsToNode::GlobalEscape NOT_PRODUCT(COMMA "blackhole"));
+          add_edge(n_ptn, ptn);
+        }
+      }
+      break;
+    }
     default: {
       // This method should be called only for EA specific nodes which may
       // miss some edges when they were created.