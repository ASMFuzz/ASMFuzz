@@ -52,9 +52,8 @@ MutableSpace::~MutableSpace() {
   delete _mangler;
 }
 
-void MutableSpace::numa_setup_pages(MemRegion mr, bool clear_space) {
+void MutableSpace::numa_setup_pages(MemRegion mr, size_t page_size, bool clear_space) {
   if (!mr.is_empty()) {
-    size_t page_size = UseLargePages ? alignment() : os::vm_page_size();
     HeapWord *start = align_up(mr.start(), page_size);
     HeapWord *end =   align_down(mr.end(), page_size);
     if (end > start) {
@@ -113,14 +112,14 @@ void MutableSpace::initialize(MemRegion mr,
     }
     assert(mr.contains(head) && mr.contains(tail), "Sanity");
 
+    size_t page_size = alignment();
+
     if (UseNUMA) {
-      numa_setup_pages(head, clear_space);
-      numa_setup_pages(tail, clear_space);
+      numa_setup_pages(head, page_size, clear_space);
+      numa_setup_pages(tail, page_size, clear_space);
     }
 
     if (AlwaysPreTouch) {
-      size_t page_size = UseLargePages ? os::large_page_size() : os::vm_page_size();
-
       PretouchTask::pretouch("ParallelGC PreTouch head", (char*)head.start(), (char*)head.end(),
                              page_size, pretouch_workers);
 