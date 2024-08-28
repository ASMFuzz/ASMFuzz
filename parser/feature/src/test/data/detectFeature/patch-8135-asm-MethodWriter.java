@@ -498,7 +498,8 @@ final class MethodWriter extends MethodVisitor {
 
     /**
       * Indicates what must be computed. Must be one of {@link #COMPUTE_ALL_FRAMES}, {@link
-      * #COMPUTE_INSERTED_FRAMES}, {@link #COMPUTE_MAX_STACK_AND_LOCAL} or {@link #COMPUTE_NOTHING}.
+      * #COMPUTE_INSERTED_FRAMES}, {@link COMPUTE_MAX_STACK_AND_LOCAL_FROM_FRAMES}, {@link
+      * #COMPUTE_MAX_STACK_AND_LOCAL} or {@link #COMPUTE_NOTHING}.
       */
     private final int compute;
 
@@ -936,26 +937,26 @@ public void visitIntInsn(final int opcode, final int operand) {
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
+    public void visitVarInsn(final int opcode, final int varIndex) {
         lastBytecodeOffset = code.length;
         // Add the instruction to the bytecode of the method.
-        if (var < 4 && opcode != Opcodes.RET) {
+        if (varIndex < 4 && opcode != Opcodes.RET) {
             int optimizedOpcode;
             if (opcode < Opcodes.ISTORE) {
-                optimizedOpcode = Constants.ILOAD_0 + ((opcode - Opcodes.ILOAD) << 2) + var;
+                optimizedOpcode = Constants.ILOAD_0 + ((opcode - Opcodes.ILOAD) << 2) + varIndex;
             } else {
-                optimizedOpcode = Constants.ISTORE_0 + ((opcode - Opcodes.ISTORE) << 2) + var;
+                optimizedOpcode = Constants.ISTORE_0 + ((opcode - Opcodes.ISTORE) << 2) + varIndex;
             }
             code.putByte(optimizedOpcode);
-        } else if (var >= 256) {
-            code.putByte(Constants.WIDE).put12(opcode, var);
+        } else if (varIndex >= 256) {
+            code.putByte(Constants.WIDE).put12(opcode, varIndex);
         } else {
-            code.put11(opcode, var);
+            code.put11(opcode, varIndex);
         }
         // If needed, update the maximum stack size and number of locals, and stack map frames.
         if (currentBasicBlock != null) {
             if (compute == COMPUTE_ALL_FRAMES || compute == COMPUTE_INSERTED_FRAMES) {
-                currentBasicBlock.frame.execute(opcode, var, null, null);
+                currentBasicBlock.frame.execute(opcode, varIndex, null, null);
             } else {
                 if (opcode == Opcodes.RET) {
                     // No stack size delta.
@@ -977,9 +978,9 @@ public void visitVarInsn(final int opcode, final int var) {
                     || opcode == Opcodes.DLOAD
                     || opcode == Opcodes.LSTORE
                     || opcode == Opcodes.DSTORE) {
-                currentMaxLocals = var + 2;
+                currentMaxLocals = varIndex + 2;
             } else {
-                currentMaxLocals = var + 1;
+                currentMaxLocals = varIndex + 1;
             }
             if (currentMaxLocals > maxLocals) {
                 maxLocals = currentMaxLocals;
@@ -1339,21 +1340,21 @@ public void visitLdcInsn(final Object value) {
     }
 
     @Override
-    public void visitIincInsn(final int var, final int increment) {
+    public void visitIincInsn(final int varIndex, final int increment) {
         lastBytecodeOffset = code.length;
         // Add the instruction to the bytecode of the method.
-        if ((var > 255) || (increment > 127) || (increment < -128)) {
-            code.putByte(Constants.WIDE).put12(Opcodes.IINC, var).putShort(increment);
+        if ((varIndex > 255) || (increment > 127) || (increment < -128)) {
+            code.putByte(Constants.WIDE).put12(Opcodes.IINC, varIndex).putShort(increment);
         } else {
-            code.putByte(Opcodes.IINC).put11(var, increment);
+            code.putByte(Opcodes.IINC).put11(varIndex, increment);
         }
         // If needed, update the maximum stack size and number of locals, and stack map frames.
         if (currentBasicBlock != null
                 && (compute == COMPUTE_ALL_FRAMES || compute == COMPUTE_INSERTED_FRAMES)) {
-            currentBasicBlock.frame.execute(Opcodes.IINC, var, null, null);
+            currentBasicBlock.frame.execute(Opcodes.IINC, varIndex, null, null);
         }
         if (compute != COMPUTE_NOTHING) {
-            int currentMaxLocals = var + 1;
+            int currentMaxLocals = varIndex + 1;
             if (currentMaxLocals > maxLocals) {
                 maxLocals = currentMaxLocals;
             }