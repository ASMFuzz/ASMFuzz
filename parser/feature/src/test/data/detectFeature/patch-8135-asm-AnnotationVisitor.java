@@ -70,8 +70,8 @@
 public abstract class AnnotationVisitor {
 
     /**
-      * The ASM API version implemented by this visitor. The value of this field must be one of {@link
-      * Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * The ASM API version implemented by this visitor. The value of this field must be one of the
+      * {@code ASM}<i>x</i> values in {@link Opcodes}.
       */
     protected final int api;
 
@@ -84,22 +84,22 @@ public abstract class AnnotationVisitor {
     /**
       * Constructs a new {@link AnnotationVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       */
-    public AnnotationVisitor(final int api) {
+    protected AnnotationVisitor(final int api) {
         this(api, null);
     }
 
     /**
       * Constructs a new {@link AnnotationVisitor}.
       *
-      * @param api the ASM API version implemented by this visitor. Must be one of {@link
-      *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
+      * @param api the ASM API version implemented by this visitor. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param annotationVisitor the annotation visitor to which this visitor must delegate method
       *     calls. May be {@literal null}.
       */
-    public AnnotationVisitor(final int api, final AnnotationVisitor annotationVisitor) {
+    protected AnnotationVisitor(final int api, final AnnotationVisitor annotationVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7