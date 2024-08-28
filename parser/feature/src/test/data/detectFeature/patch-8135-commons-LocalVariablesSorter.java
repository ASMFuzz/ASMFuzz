@@ -122,9 +122,8 @@ public LocalVariablesSorter(
     /**
       * Constructs a new {@link LocalVariablesSorter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param access access flags of the adapted method.
       * @param descriptor the method's descriptor (see {@link Type}).
       * @param methodVisitor the method visitor to which this adapter delegates calls.
@@ -140,7 +139,7 @@ protected LocalVariablesSorter(
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
+    public void visitVarInsn(final int opcode, final int varIndex) {
         Type varType;
         switch (opcode) {
             case Opcodes.LLOAD:
@@ -167,12 +166,12 @@ public void visitVarInsn(final int opcode, final int var) {
             default:
                 throw new IllegalArgumentException("Invalid opcode " + opcode);
         }
-        super.visitVarInsn(opcode, remap(var, varType));
+        super.visitVarInsn(opcode, remap(varIndex, varType));
     }
 
     @Override
-    public void visitIincInsn(final int var, final int increment) {
-        super.visitIincInsn(remap(var, Type.INT_TYPE), increment);
+    public void visitIincInsn(final int varIndex, final int increment) {
+        super.visitIincInsn(remap(varIndex, Type.INT_TYPE), increment);
     }
 
     @Override
@@ -354,11 +353,11 @@ private void setFrameLocal(final int local, final Object type) {
         remappedLocalTypes[local] = type;
     }
 
-    private int remap(final int var, final Type type) {
-        if (var + type.getSize() <= firstLocal) {
-            return var;
+    private int remap(final int varIndex, final Type type) {
+        if (varIndex + type.getSize() <= firstLocal) {
+            return varIndex;
         }
-        int key = 2 * var + type.getSize() - 1;
+        int key = 2 * varIndex + type.getSize() - 1;
         int size = remappedVariableIndices.length;
         if (key >= size) {
             int[] newRemappedVariableIndices = new int[Math.max(2 * size, key + 1)];