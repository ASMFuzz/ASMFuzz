@@ -86,7 +86,7 @@ class RegionNode : public Node {
       return nonnull_req();
     return NULL;  // not a copy!
   }
-  PhiNode* has_phi() const;        // returns an arbitrary phi user, or NULL
+  bool has_phi() const;        // returns true if there is an Phi or RAM use of this region
   PhiNode* has_unique_phi() const; // returns the unique phi user, or NULL
   // Is this region node unreachable from root?
   bool is_unreachable_region(const PhaseGVN* phase);