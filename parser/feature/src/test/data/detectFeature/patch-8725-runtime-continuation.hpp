@@ -62,9 +62,19 @@ class Continuation : AllStatic {
   enum thaw_kind {
     thaw_top = 0,
     thaw_return_barrier = 1,
-    thaw_exception = 2,
+    thaw_return_barrier_exception = 2,
   };
 
+  static bool is_thaw_return_barrier(thaw_kind kind) {
+    return kind != thaw_top;
+  }
+
+  static bool is_thaw_return_barrier_exception(thaw_kind kind) {
+    bool r = (kind == thaw_return_barrier_exception);
+    assert(!r || is_thaw_return_barrier(kind), "must be");
+    return r;
+  }
+
   static void init();
 
   static address freeze_entry();