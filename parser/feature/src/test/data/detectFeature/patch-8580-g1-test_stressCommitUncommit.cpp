@@ -97,12 +97,7 @@ TEST_VM(G1RegionToSpaceMapper, smallStressAdjacent) {
   G1MapperWorkers::run_task(&task);
 }
 
-#if defined(_WINDOWS)
-// See JDK-8283899.
-TEST_VM(G1RegionToSpaceMapper, DISABLED_largeStressAdjacent) {
-#else
 TEST_VM(G1RegionToSpaceMapper, largeStressAdjacent) {
-#endif
   // Fake a heap with 2m regions and create a BOT like mapper. This
   // will give a G1RegionsLargerThanCommitSizeMapper to stress.
   uint num_regions = G1MapperWorkers::MaxWorkers;