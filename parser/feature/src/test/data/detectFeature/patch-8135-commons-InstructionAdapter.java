@@ -93,9 +93,8 @@ public InstructionAdapter(final MethodVisitor methodVisitor) {
     /**
       * Constructs a new {@link InstructionAdapter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param methodVisitor the method visitor to which this adapter delegates calls.
       */
     protected InstructionAdapter(final int api, final MethodVisitor methodVisitor) {
@@ -456,40 +455,40 @@ public void visitIntInsn(final int opcode, final int operand) {
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
+    public void visitVarInsn(final int opcode, final int varIndex) {
         switch (opcode) {
             case Opcodes.ILOAD:
-                load(var, Type.INT_TYPE);
+                load(varIndex, Type.INT_TYPE);
                 break;
             case Opcodes.LLOAD:
-                load(var, Type.LONG_TYPE);
+                load(varIndex, Type.LONG_TYPE);
                 break;
             case Opcodes.FLOAD:
-                load(var, Type.FLOAT_TYPE);
+                load(varIndex, Type.FLOAT_TYPE);
                 break;
             case Opcodes.DLOAD:
-                load(var, Type.DOUBLE_TYPE);
+                load(varIndex, Type.DOUBLE_TYPE);
                 break;
             case Opcodes.ALOAD:
-                load(var, OBJECT_TYPE);
+                load(varIndex, OBJECT_TYPE);
                 break;
             case Opcodes.ISTORE:
-                store(var, Type.INT_TYPE);
+                store(varIndex, Type.INT_TYPE);
                 break;
             case Opcodes.LSTORE:
-                store(var, Type.LONG_TYPE);
+                store(varIndex, Type.LONG_TYPE);
                 break;
             case Opcodes.FSTORE:
-                store(var, Type.FLOAT_TYPE);
+                store(varIndex, Type.FLOAT_TYPE);
                 break;
             case Opcodes.DSTORE:
-                store(var, Type.DOUBLE_TYPE);
+                store(varIndex, Type.DOUBLE_TYPE);
                 break;
             case Opcodes.ASTORE:
-                store(var, OBJECT_TYPE);
+                store(varIndex, OBJECT_TYPE);
                 break;
             case Opcodes.RET:
-                ret(var);
+                ret(varIndex);
                 break;
             default:
                 throw new IllegalArgumentException();
@@ -686,8 +685,8 @@ public void visitLdcInsn(final Object value) {
     }
 
     @Override
-    public void visitIincInsn(final int var, final int increment) {
-        iinc(var, increment);
+    public void visitIincInsn(final int varIndex, final int increment) {
+        iinc(varIndex, increment);
     }
 
     @Override
@@ -816,16 +815,16 @@ public void cconst(final ConstantDynamic constantDynamic) {
         mv.visitLdcInsn(constantDynamic);
     }
 
-    public void load(final int var, final Type type) {
-        mv.visitVarInsn(type.getOpcode(Opcodes.ILOAD), var);
+    public void load(final int varIndex, final Type type) {
+        mv.visitVarInsn(type.getOpcode(Opcodes.ILOAD), varIndex);
     }
 
     public void aload(final Type type) {
         mv.visitInsn(type.getOpcode(Opcodes.IALOAD));
     }
 
-    public void store(final int var, final Type type) {
-        mv.visitVarInsn(type.getOpcode(Opcodes.ISTORE), var);
+    public void store(final int varIndex, final Type type) {
+        mv.visitVarInsn(type.getOpcode(Opcodes.ISTORE), varIndex);
     }
 
     public void astore(final Type type) {
@@ -916,8 +915,8 @@ public void xor(final Type type) {
         mv.visitInsn(type.getOpcode(Opcodes.IXOR));
     }
 
-    public void iinc(final int var, final int increment) {
-        mv.visitIincInsn(var, increment);
+    public void iinc(final int varIndex, final int increment) {
+        mv.visitIincInsn(varIndex, increment);
     }
 
     /**
@@ -1060,8 +1059,8 @@ public void jsr(final Label label) {
         mv.visitJumpInsn(Opcodes.JSR, label);
     }
 
-    public void ret(final int var) {
-        mv.visitVarInsn(Opcodes.RET, var);
+    public void ret(final int varIndex) {
+        mv.visitVarInsn(Opcodes.RET, varIndex);
     }
 
     public void tableswitch(final int min, final int max, final Label dflt, final Label... labels) {