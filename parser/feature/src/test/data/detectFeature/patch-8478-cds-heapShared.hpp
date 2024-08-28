@@ -36,6 +36,7 @@
 #include "oops/objArrayKlass.hpp"
 #include "oops/oop.hpp"
 #include "oops/oopHandle.hpp"
+#include "oops/oopsHierarchy.hpp"
 #include "oops/typeArrayKlass.hpp"
 #include "utilities/bitMap.hpp"
 #include "utilities/growableArray.hpp"
@@ -517,6 +518,13 @@ class HeapShared: AllStatic {
   static void write_subgraph_info_table() NOT_CDS_JAVA_HEAP_RETURN;
   static void serialize(SerializeClosure* soc) NOT_CDS_JAVA_HEAP_RETURN;
   static bool initialize_enum_klass(InstanceKlass* k, TRAPS) NOT_CDS_JAVA_HEAP_RETURN_(false);
+
+  // Returns the address of a heap object when it's mapped at the
+  // runtime requested address. See comments in archiveBuilder.hpp.
+  static address to_requested_address(address dumptime_addr) NOT_CDS_JAVA_HEAP_RETURN_(NULL);
+  static oop to_requested_address(oop dumptime_oop) {
+    return cast_to_oop(to_requested_address(cast_from_oop<address>(dumptime_oop)));
+  }
 };
 
 #if INCLUDE_CDS_JAVA_HEAP