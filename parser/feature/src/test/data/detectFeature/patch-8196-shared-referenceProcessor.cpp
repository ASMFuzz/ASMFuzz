@@ -860,6 +860,8 @@ inline bool ReferenceProcessor::set_discovered_link(HeapWord* discovered_addr, o
 inline void ReferenceProcessor::add_to_discovered_list(DiscoveredList& refs_list,
                                                        oop obj,
                                                        HeapWord* discovered_addr) {
+  ResourceMark rm;
+
   oop current_head = refs_list.head();
   // Prepare value to put into the discovered field. The last ref must have its
   // discovered field pointing to itself.
@@ -993,29 +995,17 @@ bool ReferenceProcessor::discover_reference(oop obj, ReferenceType rt) {
     }
   }
 
-  ResourceMark rm;      // Needed for tracing.
-
   HeapWord* const discovered_addr = java_lang_ref_Reference::discovered_addr_raw(obj);
   const oop  discovered = java_lang_ref_Reference::discovered(obj);
   assert(oopDesc::is_oop_or_null(discovered), "Expected an oop or NULL for discovered field at " PTR_FORMAT, p2i(discovered));
   if (discovered != NULL) {
-    // The reference has already been discovered...
-    log_develop_trace(gc, ref)("Already discovered reference (" INTPTR_FORMAT ": %s)",
-                               p2i(obj), obj->klass()->internal_name());
-    if (RefDiscoveryPolicy == ReferentBasedDiscovery) {
-      // assumes that an object is not processed twice;
-      // if it's been already discovered it must be on another
-      // generation's discovered list; so we won't discover it.
-      return false;
-    } else {
-      assert(RefDiscoveryPolicy == ReferenceBasedDiscovery,
-             "Unrecognized policy");
-      // Check assumption that an object is not potentially
-      // discovered twice except by concurrent collectors that potentially
-      // trace the same Reference object twice.
-      assert(UseG1GC, "Only possible with a concurrent marking collector");
-      return true;
-    }
+    // A non-strong ref is "rediscovered". This is possible only for G1 in the
+    // following two cases:
+    //  1. `G1CMTask::make_reference_grey` can push the same oop twice onto the
+    //     mark stack.
+    //  2. CM restarts after mark-stack overflow.
+    assert(UseG1GC, "inv");
+    return true;
   }
 
   if (RefDiscoveryPolicy == ReferentBasedDiscovery) {