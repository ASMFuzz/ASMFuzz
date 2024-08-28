@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2015, 2019, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -70,6 +70,9 @@ public class AARCH64Frame extends Frame {
   // Native frames
   private static final int NATIVE_FRAME_INITIAL_PARAM_OFFSET =  2;
 
+  private static CIntegerField ropProtectionField;
+  private static CIntegerField pacMaskField;
+
   private static VMReg fp = new VMReg(29 << 1);
 
   static {
@@ -90,8 +93,11 @@ private static synchronized void initialize(TypeDataBase db) {
     INTERPRETER_FRAME_INITIAL_SP_OFFSET           = INTERPRETER_FRAME_BCX_OFFSET - 1;
     INTERPRETER_FRAME_MONITOR_BLOCK_TOP_OFFSET    = INTERPRETER_FRAME_INITIAL_SP_OFFSET;
     INTERPRETER_FRAME_MONITOR_BLOCK_BOTTOM_OFFSET = INTERPRETER_FRAME_INITIAL_SP_OFFSET;
-  }
 
+    Type vmVersion = db.lookupType("VM_Version");
+    ropProtectionField = vmVersion.getCIntegerField("_rop_protection");
+    pacMaskField = vmVersion.getCIntegerField("_pac_mask");
+  }
 
   // an additional field beyond sp and pc:
   Address raw_fp; // frame pointer
@@ -391,7 +397,7 @@ private Frame senderForCompiledFrame(AARCH64RegisterMap map, CodeBlob cb) {
     Address senderSP = getUnextendedSP().addOffsetTo(cb.getFrameSize());
 
     // The return_address is always the word on the stack
-    Address senderPC = senderSP.getAddressAt(-1 * VM.getVM().getAddressSize());
+    Address senderPC = stripPAC(senderSP.getAddressAt(-1 * VM.getVM().getAddressSize()));
 
     // This is the saved value of FP which may or may not really be an FP.
     // It is only an FP if the sender is an interpreter frame.
@@ -445,7 +451,19 @@ public Address getLink() {
 
   // Return address:
   public Address getSenderPCAddr() { return addressOfStackSlot(RETURN_ADDR_OFFSET); }
-  public Address getSenderPC()     { return getSenderPCAddr().getAddressAt(0);      }
+  public Address getSenderPC()     { return stripPAC(getSenderPCAddr().getAddressAt(0)); }
+
+  // Remove any embedded pointer authentication code from an address.
+  private Address stripPAC(Address addr) {
+    // Really we should use the XPACI instruction to do this but we
+    // can't access that from Java so rely on the mask of PAC bits
+    // calculated by vm_version_aarch64.cpp on startup.
+    if (ropProtectionField.getValue() != 0) {
+      return addr.andWithMask(pacMaskField.getValue());
+    } else {
+      return addr;
+    }
+  }
 
   // return address of param, zero origin index.
   public Address getNativeParamAddr(int idx) {