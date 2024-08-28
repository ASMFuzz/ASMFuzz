@@ -59,6 +59,15 @@ public void testSlices(VarHandle handle, int lo, int hi, int[] values) {
         }
     }
 
+    @Test(dataProvider = "slices")
+    public void testSliceBadIndex(VarHandle handle, int lo, int hi, int[] values) {
+        try (MemorySession session = MemorySession.openConfined()) {
+            MemorySegment segment = MemorySegment.allocateNative(LAYOUT, session);
+            assertThrows(() -> handle.get(segment, lo, 0));
+            assertThrows(() -> handle.get(segment, 0, hi));
+        }
+    }
+
     static void checkSlice(MemorySegment segment, VarHandle handle, long i_max, long j_max, int... values) {
         int index = 0;
         for (long i = 0 ; i < i_max ; i++) {