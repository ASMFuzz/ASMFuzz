@@ -113,7 +113,7 @@ void LogTestFixture::clear_snapshot() {
   if (_configuration_snapshot == NULL) {
     return;
   }
-  assert(_n_snapshots > 0, "non-null array should have at least 1 element");
+  ASSERT_GT(_n_snapshots, size_t(0)) << "non-null array should have at least 1 element";
   for (size_t i = 0; i < _n_snapshots; i++) {
     os::free(_configuration_snapshot[i]);
   }