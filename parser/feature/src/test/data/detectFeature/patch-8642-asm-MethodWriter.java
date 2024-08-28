@@ -1244,7 +1244,7 @@ public void visitLabel(final Label label) {
                     // one place, but this does not work for labels which have not been visited yet.
                     // Therefore, when we detect here two labels having the same bytecode offset, we need to
                     // - consolidate the state scattered in these two instances into the canonical instance:
-                    currentBasicBlock.flags |= (label.flags & Label.FLAG_JUMP_TARGET);
+                    currentBasicBlock.flags |= (short) (label.flags & Label.FLAG_JUMP_TARGET);
                     // - make sure the two instances share the same Frame instance (the implementation of
                     // {@link Label#getCanonicalInstance} relies on this property; here label.frame should be
                     // null):
@@ -1260,7 +1260,7 @@ public void visitLabel(final Label label) {
             if (lastBasicBlock != null) {
                 if (label.bytecodeOffset == lastBasicBlock.bytecodeOffset) {
                     // Same comment as above.
-                    lastBasicBlock.flags |= (label.flags & Label.FLAG_JUMP_TARGET);
+                    lastBasicBlock.flags |= (short) (label.flags & Label.FLAG_JUMP_TARGET);
                     // Here label.frame should be null.
                     label.frame = lastBasicBlock.frame;
                     currentBasicBlock = lastBasicBlock;
@@ -2424,4 +2424,3 @@ final void collectAttributePrototypes(final Attribute.Set attributePrototypes) {
         attributePrototypes.addAttributes(firstCodeAttribute);
     }
 }
-