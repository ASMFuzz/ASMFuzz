@@ -69,9 +69,8 @@
 public abstract class FieldVisitor {
 
     /**
-      * The ASM API version implemented by this visitor. The value of this field must be one of {@link
-      * Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      * Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * The ASM API version implemented by this visitor. The value of this field must be one of the
+      * {@code ASM}<i>x</i> values in {@link Opcodes}.
       */
     protected final int api;
 
@@ -81,24 +80,22 @@ public abstract class FieldVisitor {
     /**
       * Constructs a new {@link FieldVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7}, {@link
-      *     Opcodes#ASM8} or {@link Opcodes#ASM9}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
-    public FieldVisitor(final int api) {
+    protected FieldVisitor(final int api) {
         this(api, null);
     }
 
     /**
       * Constructs a new {@link FieldVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6}, {@link Opcodes#ASM7} or {@link
-      *     Opcodes#ASM8}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param fieldVisitor the field visitor to which this visitor must delegate method calls. May be
       *     null.
       */
-    public FieldVisitor(final int api, final FieldVisitor fieldVisitor) {
+    protected FieldVisitor(final int api, final FieldVisitor fieldVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7