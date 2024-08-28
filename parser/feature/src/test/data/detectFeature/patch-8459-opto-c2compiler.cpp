@@ -518,6 +518,12 @@ bool C2Compiler::is_intrinsic_supported(const methodHandle& method, bool is_virt
   case vmIntrinsics::_fsignum:
     if (!Matcher::match_rule_supported(Op_SignumF)) return false;
     break;
+  case vmIntrinsics::_floatIsInfinite:
+    if (!Matcher::match_rule_supported(Op_IsInfiniteF)) return false;
+    break;
+  case vmIntrinsics::_doubleIsInfinite:
+    if (!Matcher::match_rule_supported(Op_IsInfiniteD)) return false;
+    break;
   case vmIntrinsics::_hashCode:
   case vmIntrinsics::_identityHashCode:
   case vmIntrinsics::_getClass: