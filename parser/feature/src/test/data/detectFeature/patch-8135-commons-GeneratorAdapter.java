@@ -242,9 +242,8 @@ public GeneratorAdapter(
     /**
       * Constructs a new {@link GeneratorAdapter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param methodVisitor the method visitor to which this adapter delegates calls.
       * @param access the method's access flags (see {@link Opcodes}).
       * @param name the method's name.