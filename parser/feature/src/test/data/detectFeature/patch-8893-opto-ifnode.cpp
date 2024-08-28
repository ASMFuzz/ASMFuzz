@@ -822,7 +822,7 @@ bool IfNode::has_only_uncommon_traps(ProjNode* proj, ProjNode*& success, ProjNod
         if (r->outcnt() != 2 || r->req() != 3 || r->find_edge(otherproj) == -1 || r->find_edge(unc_proj) == -1) {
           return false;
         }
-        assert(r->has_phi() == NULL, "simple region shouldn't have a phi");
+        assert(!r->has_phi(), "simple region shouldn't have a phi");
       } else if (dom_unc->in(0) != otherproj || unc->in(0) != unc_proj) {
         return false;
       }