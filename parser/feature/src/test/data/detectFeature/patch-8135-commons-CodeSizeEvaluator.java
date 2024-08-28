@@ -114,18 +114,18 @@ public void visitIntInsn(final int opcode, final int operand) {
     }
 
     @Override
-    public void visitVarInsn(final int opcode, final int var) {
-        if (var < 4 && opcode != RET) {
+    public void visitVarInsn(final int opcode, final int varIndex) {
+        if (varIndex < 4 && opcode != RET) {
             minSize += 1;
             maxSize += 1;
-        } else if (var >= 256) {
+        } else if (varIndex >= 256) {
             minSize += 4;
             maxSize += 4;
         } else {
             minSize += 2;
             maxSize += 2;
         }
-        super.visitVarInsn(opcode, var);
+        super.visitVarInsn(opcode, varIndex);
     }
 
     @Override
@@ -204,15 +204,15 @@ public void visitLdcInsn(final Object value) {
     }
 
     @Override
-    public void visitIincInsn(final int var, final int increment) {
-        if (var > 255 || increment > 127 || increment < -128) {
+    public void visitIincInsn(final int varIndex, final int increment) {
+        if (varIndex > 255 || increment > 127 || increment < -128) {
             minSize += 6;
             maxSize += 6;
         } else {
             minSize += 3;
             maxSize += 3;
         }
-        super.visitIincInsn(var, increment);
+        super.visitIincInsn(varIndex, increment);
     }
 
     @Override