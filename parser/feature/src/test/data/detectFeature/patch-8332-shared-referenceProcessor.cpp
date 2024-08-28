@@ -437,7 +437,6 @@ size_t ReferenceProcessor::total_reference_count(ReferenceType type) const {
     case REF_PHANTOM:
       list = _discoveredPhantomRefs;
       break;
-    case REF_OTHER:
     case REF_NONE:
     default:
       ShouldNotReachHere();
@@ -840,8 +839,6 @@ inline DiscoveredList* ReferenceProcessor::get_discovered_list(ReferenceType rt)
     case REF_PHANTOM:
       list = &_discoveredPhantomRefs[id];
       break;
-    case REF_OTHER:
-      // Unknown reference type, impossible
     case REF_NONE:
       // we should not reach here if we are an InstanceRefKlass
     default: