@@ -274,6 +274,7 @@ class LibraryCallKit : public GraphKit {
   bool inline_unsafe_fence(vmIntrinsics::ID id);
   bool inline_onspinwait();
   bool inline_fp_conversions(vmIntrinsics::ID id);
+  bool inline_fp_range_check(vmIntrinsics::ID id);
   bool inline_number_methods(vmIntrinsics::ID id);
   bool inline_divmod_methods(vmIntrinsics::ID id);
   bool inline_reference_get();