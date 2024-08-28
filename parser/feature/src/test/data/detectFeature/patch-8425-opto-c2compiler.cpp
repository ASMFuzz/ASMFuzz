@@ -715,6 +715,7 @@ bool C2Compiler::is_intrinsic_supported(const methodHandle& method, bool is_virt
   case vmIntrinsics::_Continuation_doYield:
     break;
 
+  case vmIntrinsics::_VectorCompressExpand:
   case vmIntrinsics::_VectorUnaryOp:
   case vmIntrinsics::_VectorBinaryOp:
   case vmIntrinsics::_VectorTernaryOp: