@@ -371,6 +371,34 @@ void CastIINode::dump_spec(outputStream* st) const {
 }
 #endif
 
+Node* CastLLNode::Ideal(PhaseGVN* phase, bool can_reshape) {
+  Node* progress = ConstraintCastNode::Ideal(phase, can_reshape);
+  if (progress != NULL) {
+    return progress;
+  }
+  // transform (CastLL (ConvI2L ..)) into (ConvI2L (CastII ..)) if the type of the CastLL is narrower than the type of
+  // the ConvI2L.
+  Node* in1 = in(1);
+  if (in1 != NULL && in1->Opcode() == Op_ConvI2L) {
+    const Type* t = Value(phase);
+    const Type* t_in = phase->type(in1);
+    if (t != Type::TOP && t_in != Type::TOP) {
+      const TypeLong* tl = t->is_long();
+      const TypeLong* t_in_l = t_in->is_long();
+      assert(tl->_lo >= t_in_l->_lo && tl->_hi <= t_in_l->_hi, "CastLL type should be narrower than or equal to the type of its input");
+      assert((tl != t_in_l) == (tl->_lo > t_in_l->_lo || tl->_hi < t_in_l->_hi), "if type differs then this nodes's type must be narrower");
+      if (tl != t_in_l) {
+        const TypeInt* ti = TypeInt::make(checked_cast<jint>(tl->_lo), checked_cast<jint>(tl->_hi), tl->_widen);
+        Node* castii = phase->transform(new CastIINode(in(0), in1->in(1), ti));
+        Node* convi2l = in1->clone();
+        convi2l->set_req(1, castii);
+        return convi2l;
+      }
+    }
+  }
+  return NULL;
+}
+
 //=============================================================================
 //------------------------------Identity---------------------------------------
 // If input is already higher or equal to cast type, then this is an identity.