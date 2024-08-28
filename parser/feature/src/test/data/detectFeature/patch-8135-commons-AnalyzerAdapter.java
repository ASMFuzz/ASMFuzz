@@ -157,9 +157,8 @@ public AnalyzerAdapter(
     /**
       * Constructs a new {@link AnalyzerAdapter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param owner the owner's class name.
       * @param access the method's access flags (see {@link Opcodes}).
       * @param name the method's name.
@@ -275,15 +274,15 @@ public void visitIntInsn(final int opcode, final int operand) {
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
-        super.visitVarInsn(opcode, var);
+    public void visitVarInsn(final int opcode, final int varIndex) {
+        super.visitVarInsn(opcode, varIndex);
         boolean isLongOrDouble =
                 opcode == Opcodes.LLOAD
                         || opcode == Opcodes.DLOAD
                         || opcode == Opcodes.LSTORE
                         || opcode == Opcodes.DSTORE;
-        maxLocals = Math.max(maxLocals, var + (isLongOrDouble ? 2 : 1));
-        execute(opcode, var, null);
+        maxLocals = Math.max(maxLocals, varIndex + (isLongOrDouble ? 2 : 1));
+        execute(opcode, varIndex, null);
     }
 
     @Override
@@ -431,10 +430,10 @@ public void visitLdcInsn(final Object value) {
     }
 
     @Override
-    public void visitIincInsn(final int var, final int increment) {
-        super.visitIincInsn(var, increment);
-        maxLocals = Math.max(maxLocals, var + 1);
-        execute(Opcodes.IINC, var, null);
+    public void visitIincInsn(final int varIndex, final int increment) {
+        super.visitIincInsn(varIndex, increment);
+        maxLocals = Math.max(maxLocals, varIndex + 1);
+        execute(Opcodes.IINC, varIndex, null);
     }
 
     @Override