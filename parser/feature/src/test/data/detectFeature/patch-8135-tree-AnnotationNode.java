@@ -101,9 +101,8 @@ public AnnotationNode(final String descriptor) {
     /**
       * Constructs a new {@link AnnotationNode}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param descriptor the class descriptor of the annotation class.
       */
     public AnnotationNode(final int api, final String descriptor) {
@@ -205,8 +204,8 @@ public void visitEnd() {
       * checks that this node, and all its children recursively, do not contain elements that were
       * introduced in more recent versions of the ASM API than the given version.
       *
-      * @param api an ASM API version. Must be one of {@link Opcodes#ASM4}, {@link Opcodes#ASM5},
-      *     {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api an ASM API version. Must be one of the {@code ASM}<i>x</i> values in {@link
+      *     Opcodes}.
       */
     public void check(final int api) {
         // nothing to do