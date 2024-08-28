@@ -367,9 +367,17 @@ class VerifyRegionClosure: public HeapRegionClosure {
     guarantee(!r->is_young() || r->rem_set()->is_complete(), "Remembered set for Young region %u must be complete, is %s", r->hrm_index(), r->rem_set()->get_state_str());
     // Humongous and old regions regions might be of any state, so can't check here.
     guarantee(!r->is_free() || !r->rem_set()->is_tracked(), "Remembered set for free region %u must be untracked, is %s", r->hrm_index(), r->rem_set()->get_state_str());
-    // Verify that the continues humongous regions' remembered set state matches the
-    // one from the starts humongous region.
-    if (r->is_continues_humongous()) {
+
+    // For archive regions, verify there are no heap pointers to non-pinned regions.
+    if (r->is_closed_archive()) {
+      VerifyObjectInArchiveRegionClosure verify_oop_pointers(r, false);
+      r->object_iterate(&verify_oop_pointers);
+    } else if (r->is_open_archive()) {
+      VerifyObjsInRegionClosure verify_open_archive_oop(r, _vo);
+      r->object_iterate(&verify_open_archive_oop);
+    } else if (r->is_continues_humongous()) {
+      // Verify that the continues humongous regions' remembered set state
+      // matches the one from the starts humongous region.
       if (r->rem_set()->get_state_str() != r->humongous_start_region()->rem_set()->get_state_str()) {
          log_error(gc, verify)("Remset states differ: Region %u (%s) remset %s with starts region %u (%s) remset %s",
                                r->hrm_index(),
@@ -380,18 +388,7 @@ class VerifyRegionClosure: public HeapRegionClosure {
                                r->humongous_start_region()->rem_set()->get_state_str());
          _failures = true;
       }
-    }
-    // For archive regions, verify there are no heap pointers to
-    // non-pinned regions. For all others, verify liveness info.
-    if (r->is_closed_archive()) {
-      VerifyObjectInArchiveRegionClosure verify_oop_pointers(r, false);
-      r->object_iterate(&verify_oop_pointers);
-      return true;
-    } else if (r->is_open_archive()) {
-      VerifyObjsInRegionClosure verify_open_archive_oop(r, _vo);
-      r->object_iterate(&verify_open_archive_oop);
-      return true;
-    } else if (!r->is_continues_humongous()) {
+    } else {
       bool failures = false;
       r->verify(_vo, &failures);
       if (failures) {
@@ -406,7 +403,9 @@ class VerifyRegionClosure: public HeapRegionClosure {
         }
       }
     }
-    return false; // stop the region iteration if we hit a failure
+
+    // stop the region iteration if we hit a failure
+    return _failures;
   }
 };
 