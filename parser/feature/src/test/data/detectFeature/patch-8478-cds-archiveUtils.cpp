@@ -265,8 +265,13 @@ void WriteClosure::do_oop(oop* o) {
     _dump_region->append_intptr_t(0);
   } else {
     assert(HeapShared::can_write(), "sanity");
-    _dump_region->append_intptr_t(
-      UseCompressedOops ? (intptr_t)CompressedOops::encode_not_null(*o) : (intptr_t)((void*)(*o)));
+    intptr_t p;
+    if (UseCompressedOops) {
+      p = (intptr_t)CompressedOops::encode_not_null(*o);
+    } else {
+      p = cast_from_oop<intptr_t>(HeapShared::to_requested_address(*o));
+    }
+    _dump_region->append_intptr_t(p);
   }
 }
 