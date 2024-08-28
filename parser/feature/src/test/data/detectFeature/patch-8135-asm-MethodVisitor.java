@@ -83,8 +83,8 @@ public abstract class MethodVisitor {
     private static final String REQUIRES_ASM5 = "This feature requires ASM5";
 
     /**
-      * The ASM API version implemented by this visitor. The value of this field must be one of {@link
-      * Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * The ASM API version implemented by this visitor. The value of this field must be one of the
+      * {@code ASM}<i>x</i> values in {@link Opcodes}.
       */
     protected final int api;
 
@@ -96,22 +96,22 @@ public abstract class MethodVisitor {
     /**
       * Constructs a new {@link MethodVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
-    public MethodVisitor(final int api) {
+    protected MethodVisitor(final int api) {
         this(api, null);
     }
 
     /**
       * Constructs a new {@link MethodVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param methodVisitor the method visitor to which this visitor must delegate method calls. May
       *     be null.
       */
-    public MethodVisitor(final int api, final MethodVisitor methodVisitor) {
+    protected MethodVisitor(final int api, final MethodVisitor methodVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7
@@ -379,12 +379,12 @@ public void visitIntInsn(final int opcode, final int operand) {
       *
       * @param opcode the opcode of the local variable instruction to be visited. This opcode is either
       *     ILOAD, LLOAD, FLOAD, DLOAD, ALOAD, ISTORE, LSTORE, FSTORE, DSTORE, ASTORE or RET.
-      * @param var the operand of the instruction to be visited. This operand is the index of a local
-      *     variable.
+      * @param varIndex the operand of the instruction to be visited. This operand is the index of a
+      *     local variable.
       */
-    public void visitVarInsn(final int opcode, final int var) {
+    public void visitVarInsn(final int opcode, final int varIndex) {
         if (mv != null) {
-            mv.visitVarInsn(opcode, var);
+            mv.visitVarInsn(opcode, varIndex);
         }
     }
 
@@ -582,12 +582,12 @@ public void visitLdcInsn(final Object value) {
     /**
       * Visits an IINC instruction.
       *
-      * @param var index of the local variable to be incremented.
+      * @param varIndex index of the local variable to be incremented.
       * @param increment amount to increment the local variable by.
       */
-    public void visitIincInsn(final int var, final int increment) {
+    public void visitIincInsn(final int varIndex, final int increment) {
         if (mv != null) {
-            mv.visitIincInsn(var, increment);
+            mv.visitIincInsn(varIndex, increment);
         }
     }
 