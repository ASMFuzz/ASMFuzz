@@ -224,7 +224,7 @@ class PhaseTransform : public Phase {
     assert(_pnum != Ideal_Loop, "should not be used from PhaseIdealLoop");
     assert(n != NULL, "must not be null");
     const Type* t = _types.fast_lookup(n->_idx);
-    assert(t != NULL, "must set before get");
+    assert(t != NULL, "must set type before getting it. %d:%s", n->_idx, n->Name());
     return t;
   }
   // Get a previously recorded type for the node n,