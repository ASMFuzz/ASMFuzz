@@ -700,6 +700,8 @@ bool LibraryCallKit::try_to_inline(int predicate) {
     return inline_vector_insert();
   case vmIntrinsics::_VectorExtract:
     return inline_vector_extract();
+  case vmIntrinsics::_VectorCompressExpand:
+    return inline_vector_compress_expand();
 
   case vmIntrinsics::_getObjectSize:
     return inline_getObjectSize();