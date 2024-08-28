@@ -86,10 +86,8 @@ public ModuleRemapper(final ModuleVisitor moduleVisitor, final Remapper remapper
     /**
       * Constructs a new {@link ModuleRemapper}.
       *
-      * @param api the ASM API version supported by this remapper. Must be one of {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM4}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM5}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM6}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM7}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM8} or {@link jdk.internal.org.objectweb.asm.Opcodes#ASM9}.
+      * @param api the ASM API version supported by this remapper. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param moduleVisitor the module visitor this remapper must delegate to.
       * @param remapper the remapper to use to remap the types in the visited module.
       */