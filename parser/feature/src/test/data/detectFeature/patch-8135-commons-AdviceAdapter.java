@@ -130,8 +130,8 @@ public abstract class AdviceAdapter extends GeneratorAdapter implements Opcodes
     /**
       * Constructs a new {@link AdviceAdapter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param methodVisitor the method visitor to which this adapter delegates calls.
       * @param access the method's access flags (see {@link Opcodes}).
       * @param name the method's name.
@@ -359,8 +359,8 @@ public void visitInsn(final int opcode) {
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
-        super.visitVarInsn(opcode, var);
+    public void visitVarInsn(final int opcode, final int varIndex) {
+        super.visitVarInsn(opcode, varIndex);
         if (isConstructor && !superClassConstructorCalled) {
             switch (opcode) {
                 case ILOAD:
@@ -373,7 +373,7 @@ public void visitVarInsn(final int opcode, final int var) {
                     pushValue(OTHER);
                     break;
                 case ALOAD:
-                    pushValue(var == 0 ? UNINITIALIZED_THIS : OTHER);
+                    pushValue(varIndex == 0 ? UNINITIALIZED_THIS : OTHER);
                     break;
                 case ASTORE:
                 case ISTORE: