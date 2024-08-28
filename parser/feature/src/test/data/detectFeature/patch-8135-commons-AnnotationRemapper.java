@@ -108,10 +108,8 @@ public AnnotationRemapper(
     /**
       * Constructs a new {@link AnnotationRemapper}.
       *
-      * @param api the ASM API version supported by this remapper. Must be one of {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM4}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM5}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM6}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM7}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM8} or {@link jdk.internal.org.objectweb.asm.Opcodes#ASM9}.
+      * @param api the ASM API version supported by this remapper. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param annotationVisitor the annotation visitor this remapper must delegate to.
       * @param remapper the remapper to use to remap the types in the visited annotation.
       * @deprecated use {@link #AnnotationRemapper(int, String, AnnotationVisitor, Remapper)} instead.
@@ -125,10 +123,8 @@ protected AnnotationRemapper(
     /**
       * Constructs a new {@link AnnotationRemapper}.
       *
-      * @param api the ASM API version supported by this remapper. Must be one of {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM4}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM5}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM6}, {@link jdk.internal.org.objectweb.asm.Opcodes#ASM7}, {@link
-      *     jdk.internal.org.objectweb.asm.Opcodes#ASM8} or {@link jdk.internal.org.objectweb.asm.Opcodes#ASM9}.
+      * @param api the ASM API version supported by this remapper. Must be one of the {@code
+      *     ASM}<i>x</i> values in {@link Opcodes}.
       * @param descriptor the descriptor of the visited annotation. May be {@literal null}.
       * @param annotationVisitor the annotation visitor this remapper must delegate to.
       * @param remapper the remapper to use to remap the types in the visited annotation.