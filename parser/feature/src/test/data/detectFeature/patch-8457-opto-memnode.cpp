@@ -3112,7 +3112,7 @@ Node* ClearArrayNode::Identity(PhaseGVN* phase) {
 // Clearing a short array is faster with stores
 Node *ClearArrayNode::Ideal(PhaseGVN *phase, bool can_reshape) {
   // Already know this is a large node, do not try to ideal it
-  if (!IdealizeClearArrayNode || _is_large) return NULL;
+  if (_is_large) return NULL;
 
   const int unit = BytesPerLong;
   const TypeX* t = phase->type(in(2))->isa_intptr_t();
@@ -3133,6 +3133,7 @@ Node *ClearArrayNode::Ideal(PhaseGVN *phase, bool can_reshape) {
   } else if (size > 2 && Matcher::match_rule_supported_vector(Op_ClearArray, 4, T_LONG)) {
     return NULL;
   }
+  if (!IdealizeClearArrayNode) return NULL;
   Node *mem = in(1);
   if( phase->type(mem)==Type::TOP ) return NULL;
   Node *adr = in(3);