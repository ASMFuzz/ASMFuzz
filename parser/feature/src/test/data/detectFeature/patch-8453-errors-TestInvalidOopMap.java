@@ -67,7 +67,7 @@ private void test(ReferenceMap refMap) {
         BytecodePosition pos = new BytecodePosition(null, dummyMethod, 0);
         DebugInfo info = new DebugInfo(pos);
         info.setReferenceMap(refMap);
-        installEmptyCode(new Site[]{new Infopoint(0, info, InfopointReason.SAFEPOINT)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], StackSlot.get(null, 0, true));
+        installEmptyCode(new Site[]{new Infopoint(0, info, InfopointReason.SAFEPOINT)}, new Assumption[0], new Comment[0], 8, new DataPatch[0], StackSlot.get(null, 0, true));
     }
 
     @Test(expected = NullPointerException.class)