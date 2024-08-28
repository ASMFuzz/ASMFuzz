@@ -187,9 +187,8 @@ public ClassNode() {
     /**
       * Constructs a new {@link ClassNode}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8}, or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
     public ClassNode(final int api) {
         super(api);
@@ -334,8 +333,8 @@ public void visitEnd() {
       * that this node, and all its children recursively, do not contain elements that were introduced
       * in more recent versions of the ASM API than the given version.
       *
-      * @param api an ASM API version. Must be one of {@link Opcodes#ASM4}, {@link Opcodes#ASM5},
-      *     {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api an ASM API version. Must be one of the {@code ASM}<i>x</i> values in {@link
+      *     Opcodes}.
       */
     public void check(final int api) {
         if (api < Opcodes.ASM9 && permittedSubclasses != null) {