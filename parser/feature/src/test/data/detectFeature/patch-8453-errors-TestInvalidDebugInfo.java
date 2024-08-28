@@ -97,7 +97,7 @@ private void test(VirtualObject[] vobj, JavaValue[] values, JavaKind[] slotKinds
         BytecodeFrame frame = new BytecodeFrame(null, dummyMethod, 0, false, false, values, slotKinds, locals, stack, locks);
         DebugInfo info = new DebugInfo(frame, vobj);
         info.setReferenceMap(new HotSpotReferenceMap(new Location[0], new Location[0], new int[0], 8));
-        installEmptyCode(new Site[]{new Infopoint(0, info, InfopointReason.SAFEPOINT)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], deoptRescueSlot);
+        installEmptyCode(new Site[]{new Infopoint(0, info, InfopointReason.SAFEPOINT)}, new Assumption[0], new Comment[0], 8, new DataPatch[0], deoptRescueSlot);
     }
 
     @Test(expected = NullPointerException.class)