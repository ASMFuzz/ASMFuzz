@@ -72,8 +72,8 @@
 public abstract class ClassVisitor {
 
     /**
-      * The ASM API version implemented by this visitor. The value of this field must be one of {@link
-      * Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * The ASM API version implemented by this visitor. The value of this field must be one of the
+      * {@code ASM}<i>x</i> values in {@link Opcodes}.
       */
     protected final int api;
 
@@ -83,23 +83,22 @@ public abstract class ClassVisitor {
     /**
       * Constructs a new {@link ClassVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
-    public ClassVisitor(final int api) {
+    protected ClassVisitor(final int api) {
         this(api, null);
     }
 
     /**
       * Constructs a new {@link ClassVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param classVisitor the class visitor to which this visitor must delegate method calls. May be
       *     null.
       */
-    public ClassVisitor(final int api, final ClassVisitor classVisitor) {
+    protected ClassVisitor(final int api, final ClassVisitor classVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7