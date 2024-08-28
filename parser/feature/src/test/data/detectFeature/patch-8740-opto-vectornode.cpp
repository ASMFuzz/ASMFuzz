@@ -362,7 +362,6 @@ bool VectorNode::is_vector_rotate_supported(int vopc, uint vlen, BasicType bt) {
              Matcher::match_rule_supported_vector(Op_LShiftVL,  vlen, bt) &&
              Matcher::match_rule_supported_vector(Op_URShiftVL, vlen, bt);
     default:
-      assert(false, "not supported: %s", type2name(bt));
       return false;
   }
 }