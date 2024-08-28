@@ -974,6 +974,9 @@ bool IdealLoopTree::policy_unroll(PhaseIdealLoop *phase) {
       case Op_RoundD: {
           body_size += Matcher::scalar_op_pre_select_sz_estimate(n->Opcode(), n->bottom_type()->basic_type());
       } break;
+      case Op_CountTrailingZerosV:
+      case Op_CountLeadingZerosV:
+      case Op_ReverseV:
       case Op_RoundVF:
       case Op_RoundVD:
       case Op_PopCountVI: