@@ -92,18 +92,18 @@ public abstract class SignatureVisitor {
     public static final char INSTANCEOF = '=';
 
     /**
-      * The ASM API version implemented by this visitor. The value of this field must be one of {@link
-      * Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * The ASM API version implemented by this visitor. The value of this field must be one of the
+      * {@code ASM}<i>x</i> values in {@link Opcodes}.
       */
     protected final int api;
 
     /**
       * Constructs a new {@link SignatureVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
-    public SignatureVisitor(final int api) {
+    protected SignatureVisitor(final int api) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7