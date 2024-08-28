@@ -88,9 +88,8 @@ public FieldRemapper(final FieldVisitor fieldVisitor, final Remapper remapper) {
     /**
       * Constructs a new {@link FieldRemapper}.
       *
-      * @param api the ASM API version supported by this remapper. Must be one of {@link Opcodes#ASM4},
-      *     {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link Opcodes#ASM8}, or
-      *     {@link Opcodes#ASM9}.
+      * @param api the ASM API version supported by this remapper. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param fieldVisitor the field visitor this remapper must delegate to.
       * @param remapper the remapper to use to remap the types in the visited field.
       */