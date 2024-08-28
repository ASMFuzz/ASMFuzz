@@ -516,6 +516,9 @@ bool LibraryCallKit::try_to_inline(int predicate) {
   case vmIntrinsics::_doubleToLongBits:
   case vmIntrinsics::_longBitsToDouble:         return inline_fp_conversions(intrinsic_id());
 
+  case vmIntrinsics::_floatIsInfinite:
+  case vmIntrinsics::_doubleIsInfinite:         return inline_fp_range_check(intrinsic_id());
+
   case vmIntrinsics::_numberOfLeadingZeros_i:
   case vmIntrinsics::_numberOfLeadingZeros_l:
   case vmIntrinsics::_numberOfTrailingZeros_i:
@@ -4642,6 +4645,25 @@ bool LibraryCallKit::inline_fp_conversions(vmIntrinsics::ID id) {
   return true;
 }
 
+bool LibraryCallKit::inline_fp_range_check(vmIntrinsics::ID id) {
+  Node* arg = argument(0);
+  Node* result = NULL;
+
+  switch (id) {
+  case vmIntrinsics::_floatIsInfinite:
+    result = new IsInfiniteFNode(arg);
+    break;
+  case vmIntrinsics::_doubleIsInfinite:
+    result = new IsInfiniteDNode(arg);
+    break;
+  default:
+    fatal_unexpected_iid(id);
+    break;
+  }
+  set_result(_gvn.transform(result));
+  return true;
+}
+
 //----------------------inline_unsafe_copyMemory-------------------------
 // public native void Unsafe.copyMemory0(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes);
 