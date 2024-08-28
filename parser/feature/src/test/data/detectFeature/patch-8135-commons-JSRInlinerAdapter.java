@@ -146,9 +146,8 @@ public JSRInlinerAdapter(
     /**
       * Constructs a new {@link JSRInlinerAdapter}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param methodVisitor the method visitor to send the resulting inlined method code to, or <code>
       *     null</code>.
       * @param access the method's access flags (see {@link Opcodes}). This parameter also indicates if