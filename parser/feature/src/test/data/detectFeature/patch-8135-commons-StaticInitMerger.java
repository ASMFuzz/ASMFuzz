@@ -99,9 +99,8 @@ public StaticInitMerger(final String prefix, final ClassVisitor classVisitor) {
     /**
       * Constructs a new {@link StaticInitMerger}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param prefix the prefix to use to rename the existing &lt;clinit&gt; methods.
       * @param classVisitor the class visitor to which this visitor must delegate method calls. May be
       *     null.