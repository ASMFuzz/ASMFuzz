@@ -191,9 +191,8 @@ public SerialVersionUIDAdder(final ClassVisitor classVisitor) {
     /**
       * Constructs a new {@link SerialVersionUIDAdder}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param classVisitor a {@link ClassVisitor} to which this visitor will delegate calls.
       */
     protected SerialVersionUIDAdder(final int api, final ClassVisitor classVisitor) {