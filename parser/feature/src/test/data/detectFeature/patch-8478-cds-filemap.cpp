@@ -251,8 +251,10 @@ void FileMapHeader::populate(FileMapInfo *info, size_t core_region_alignment,
       _heap_begin = CompressedOops::begin();
       _heap_end = CompressedOops::end();
     } else {
-      _heap_begin = (address)G1CollectedHeap::heap()->reserved().start();
-      _heap_end = (address)G1CollectedHeap::heap()->reserved().end();
+      address start = (address)G1CollectedHeap::heap()->reserved().start();
+      address end = (address)G1CollectedHeap::heap()->reserved().end();
+      _heap_begin = HeapShared::to_requested_address(start);
+      _heap_end = HeapShared::to_requested_address(end);
     }
   }
   _compressed_oops = UseCompressedOops;