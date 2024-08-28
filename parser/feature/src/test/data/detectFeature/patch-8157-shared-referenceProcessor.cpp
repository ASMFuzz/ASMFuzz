@@ -828,9 +828,6 @@ inline DiscoveredList* ReferenceProcessor::get_discovered_list(ReferenceType rt)
   // Get the discovered queue to which we will add
   DiscoveredList* list = NULL;
   switch (rt) {
-    case REF_OTHER:
-      // Unknown reference type, no special treatment
-      break;
     case REF_SOFT:
       list = &_discoveredSoftRefs[id];
       break;
@@ -843,6 +840,8 @@ inline DiscoveredList* ReferenceProcessor::get_discovered_list(ReferenceType rt)
     case REF_PHANTOM:
       list = &_discoveredPhantomRefs[id];
       break;
+    case REF_OTHER:
+      // Unknown reference type, impossible
     case REF_NONE:
       // we should not reach here if we are an InstanceRefKlass
     default:
@@ -1036,10 +1035,6 @@ bool ReferenceProcessor::discover_reference(oop obj, ReferenceType rt) {
 
   // Get the right type of discovered queue head.
   DiscoveredList* list = get_discovered_list(rt);
-  if (list == NULL) {
-    return false;   // nothing special needs to be done
-  }
-
   add_to_discovered_list(*list, obj, discovered_addr);
 
   assert(oopDesc::is_oop(obj), "Discovered a bad reference");