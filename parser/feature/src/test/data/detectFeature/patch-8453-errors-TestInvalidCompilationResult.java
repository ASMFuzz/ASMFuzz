@@ -85,9 +85,12 @@ public boolean equals(Object obj) {
         }
     }
 
+    // DataSectionAlignment value matches the alignment sizeof(jdouble) of the CodeBuffer::SECT_CONSTS code section
+    static final int validDataSectionAlignment = 8;
+
     @Test(expected = JVMCIError.class)
     public void testInvalidAssumption() {
-        installEmptyCode(new Site[0], new Assumption[]{new InvalidAssumption()}, new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[0], new Assumption[]{new InvalidAssumption()}, new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
@@ -97,101 +100,101 @@ public void testInvalidAlignment() {
 
     @Test(expected = NullPointerException.class)
     public void testNullDataPatchInDataSection() {
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{null}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{null}, null);
     }
 
     @Test(expected = NullPointerException.class)
     public void testNullReferenceInDataSection() {
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{new DataPatch(0, null)}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{new DataPatch(0, null)}, null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidDataSectionReference() {
         DataSectionReference ref = new DataSectionReference();
         ref.setOffset(0);
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{new DataPatch(0, ref)}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{new DataPatch(0, ref)}, null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidNarrowMethodInDataSection() {
         HotSpotConstant c = (HotSpotConstant) dummyMethod.getEncoding();
         ConstantReference ref = new ConstantReference((VMConstant) c.compress());
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{new DataPatch(0, ref)}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{new DataPatch(0, ref)}, null);
     }
 
     @Test(expected = NullPointerException.class)
     public void testNullConstantInDataSection() {
         ConstantReference ref = new ConstantReference(null);
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{new DataPatch(0, ref)}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{new DataPatch(0, ref)}, null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidConstantInDataSection() {
         ConstantReference ref = new ConstantReference(new InvalidVMConstant());
-        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], 16, new DataPatch[]{new DataPatch(0, ref)}, null);
+        installEmptyCode(new Site[0], new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[]{new DataPatch(0, ref)}, null);
     }
 
     @Test(expected = NullPointerException.class)
     public void testNullReferenceInCode() {
-        installEmptyCode(new Site[]{new DataPatch(0, null)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new DataPatch(0, null)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = NullPointerException.class)
     public void testNullConstantInCode() {
         ConstantReference ref = new ConstantReference(null);
-        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidConstantInCode() {
         ConstantReference ref = new ConstantReference(new InvalidVMConstant());
-        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidReference() {
         InvalidReference ref = new InvalidReference();
-        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testOutOfBoundsDataSectionReference() {
         DataSectionReference ref = new DataSectionReference();
         ref.setOffset(0x1000);
-        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new DataPatch(0, ref)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidMark() {
-        installEmptyCode(new Site[]{new Mark(0, new Object())}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new Mark(0, new Object())}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidMarkInt() {
-        installEmptyCode(new Site[]{new Mark(0, -1)}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{new Mark(0, -1)}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = NullPointerException.class)
     public void testNullSite() {
-        installEmptyCode(new Site[]{null}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{null}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInfopointMissingDebugInfo() {
         Infopoint info = new Infopoint(0, null, InfopointReason.METHOD_START);
-        installEmptyCode(new Site[]{info}, new Assumption[0], new Comment[0], 16, new DataPatch[0], null);
+        installEmptyCode(new Site[]{info}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], null);
     }
 
     @Test(expected = JVMCIError.class)
     public void testSafepointMissingDebugInfo() {
         Infopoint info = new Infopoint(0, null, InfopointReason.SAFEPOINT);
         StackSlot deoptRescueSlot = StackSlot.get(null, 0, true);
-        installEmptyCode(new Site[]{info}, new Assumption[0], new Comment[0], 16, new DataPatch[0], deoptRescueSlot);
+        installEmptyCode(new Site[]{info}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], deoptRescueSlot);
     }
 
     @Test(expected = JVMCIError.class)
     public void testInvalidDeoptRescueSlot() {
         StackSlot deoptRescueSlot = StackSlot.get(null, -1, false);
-        installEmptyCode(new Site[]{}, new Assumption[0], new Comment[0], 16, new DataPatch[0], deoptRescueSlot);
+        installEmptyCode(new Site[]{}, new Assumption[0], new Comment[0], validDataSectionAlignment, new DataPatch[0], deoptRescueSlot);
     }
 }