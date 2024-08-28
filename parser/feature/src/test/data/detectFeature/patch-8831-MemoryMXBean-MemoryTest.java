@@ -79,6 +79,16 @@ public class MemoryTest {
     // - Metaspace
     // - Compressed Class Space (if compressed class pointers are used)
 
+    // Hotspot VM 19 removes Compressed Class Space pool as it's a part of Metaspace
+    // It expected to have the following memory pools:
+    // - HEAP      G1 Eden Space
+    // - HEAP      G1 Old Gen
+    // - HEAP      G1 Survivor Space
+    // - NON_HEAP  CodeHeap 'non-nmethods' (between one and three depending on the -XX:SegmentedCodeCache option)
+    // - NON_HEAP  Metaspace
+    // - NON_HEAP  CodeHeap 'profiled nmethods'
+    // - NON_HEAP  CodeHeap 'non-profiled nmethods'
+
     private static int[] expectedMinNumPools = new int[2];
     private static int[] expectedMaxNumPools = new int[2];
     private static int expectedNumGCMgrs;