@@ -1016,24 +1016,27 @@ class ArchiveBuilder::CDSMapLogger : AllStatic {
 #undef _LOG_PREFIX
 
   // Log information about a region, whose address at dump time is [base .. top). At
-  // runtime, this region will be mapped to runtime_base.  runtime_base is 0 if this
+  // runtime, this region will be mapped to requested_base. requested_base is 0 if this
   // region will be mapped at os-selected addresses (such as the bitmap region), or will
   // be accessed with os::read (the header).
-  static void log_region(const char* name, address base, address top, address runtime_base) {
+  //
+  // Note: across -Xshare:dump runs, base may be different, but requested_base should
+  // be the same as the archive contents should be deterministic.
+  static void log_region(const char* name, address base, address top, address requested_base) {
     size_t size = top - base;
-    base = runtime_base;
-    top = runtime_base + size;
+    base = requested_base;
+    top = requested_base + size;
     log_info(cds, map)("[%-18s " PTR_FORMAT " - " PTR_FORMAT " " SIZE_FORMAT_W(9) " bytes]",
                        name, p2i(base), p2i(top), size);
   }
 
+#if INCLUDE_CDS_JAVA_HEAP
   // open and closed archive regions
   static void log_heap_regions(const char* which, GrowableArray<MemRegion> *regions) {
-#if INCLUDE_CDS_JAVA_HEAP
     for (int i = 0; i < regions->length(); i++) {
       address start = address(regions->at(i).start());
       address end = address(regions->at(i).end());
-      log_region(which, start, end, start);
+      log_region(which, start, end, to_requested(start));
 
       while (start < end) {
         size_t byte_size;
@@ -1042,34 +1045,37 @@ class ArchiveBuilder::CDSMapLogger : AllStatic {
         if (original_oop != NULL) {
           ResourceMark rm;
           log_info(cds, map)(PTR_FORMAT ": @@ Object %s",
-                             p2i(start), original_oop->klass()->external_name());
+                             p2i(to_requested(start)), original_oop->klass()->external_name());
           byte_size = original_oop->size() * BytesPerWord;
         } else if (archived_oop == HeapShared::roots()) {
           // HeapShared::roots() is copied specially so it doesn't exist in
           // HeapShared::OriginalObjectTable. See HeapShared::copy_roots().
-          log_info(cds, map)(PTR_FORMAT ": @@ Object HeapShared:roots (ObjArray)",
-                             p2i(start));
+          log_info(cds, map)(PTR_FORMAT ": @@ Object HeapShared::roots (ObjArray)",
+                             p2i(to_requested(start)));
           byte_size = objArrayOopDesc::object_size(HeapShared::roots()->length()) * BytesPerWord;
         } else {
           // We have reached the end of the region
           break;
         }
         address oop_end = start + byte_size;
-        log_data(start, oop_end, start, /*is_heap=*/true);
+        log_data(start, oop_end, to_requested(start), /*is_heap=*/true);
         start = oop_end;
       }
       if (start < end) {
         log_info(cds, map)(PTR_FORMAT ": @@ Unused heap space " SIZE_FORMAT " bytes",
-                           p2i(start), size_t(end - start));
-        log_data(start, end, start, /*is_heap=*/true);
+                           p2i(to_requested(start)), size_t(end - start));
+        log_data(start, end, to_requested(start), /*is_heap=*/true);
       }
     }
-#endif
   }
+  static address to_requested(address p) {
+    return HeapShared::to_requested_address(p);
+  }
+#endif
 
   // Log all the data [base...top). Pretend that the base address
-  // will be mapped to runtime_base at run-time.
-  static void log_data(address base, address top, address runtime_base, bool is_heap = false) {
+  // will be mapped to requested_base at run-time.
+  static void log_data(address base, address top, address requested_base, bool is_heap = false) {
     assert(top >= base, "must be");
 
     LogStreamHandle(Trace, cds, map) lsh;
@@ -1080,7 +1086,7 @@ class ArchiveBuilder::CDSMapLogger : AllStatic {
         // longs and doubles will be split into two words.
         unitsize = sizeof(narrowOop);
       }
-      os::print_hex_dump(&lsh, base, top, unitsize, 32, runtime_base);
+      os::print_hex_dump(&lsh, base, top, unitsize, 32, requested_base);
     }
   }
 
@@ -1114,12 +1120,14 @@ class ArchiveBuilder::CDSMapLogger : AllStatic {
     log_region("bitmap", address(bitmap), bitmap_end, 0);
     log_data((address)bitmap, bitmap_end, 0);
 
+#if INCLUDE_CDS_JAVA_HEAP
     if (closed_heap_regions != NULL) {
       log_heap_regions("closed heap region", closed_heap_regions);
     }
     if (open_heap_regions != NULL) {
       log_heap_regions("open heap region", open_heap_regions);
     }
+#endif
 
     log_info(cds, map)("[End of CDS archive map]");
   }