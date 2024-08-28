@@ -162,7 +162,7 @@ public static void main(String[] args) {
             if (gcCountNow == gcCountBefore) {
                 // We should allocate at least allocation.expectedSize
                 Asserts.assertGreaterThanOrEqual(usedMemoryAfter - usedMemoryBefore, expectedAllocationSize,
-                        "Counter of type " + memoryCounter.getClass().getSimpleName() +
+                        "Counter of type " + memoryCounter.toString() +
                                 " returned wrong allocation size");
             } else {
                 System.out.println("GC happened during allocation so the check is skipped");
@@ -184,7 +184,7 @@ public static void main(String[] args) {
             // We should free at least allocation.expectedSize * ALLOCATION_SIZE_TOLERANCE_FACTOR
             Asserts.assertGreaterThanOrEqual(usedMemoryBefore - usedMemoryAfter,
                     (long) (allocation.expectedSize * ALLOCATION_SIZE_TOLERANCE_FACTOR),
-                    "Counter of type " + memoryCounter.getClass().getSimpleName() + " returned wrong allocation size");
+                    "Counter of type " + memoryCounter.toString() + " returned wrong allocation size");
         });
     }
 }