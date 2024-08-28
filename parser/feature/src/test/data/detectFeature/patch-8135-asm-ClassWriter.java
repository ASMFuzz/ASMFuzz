@@ -97,6 +97,12 @@ public class ClassWriter extends ClassVisitor {
       */
     public static final int COMPUTE_FRAMES = 2;
 
+    /**
+      * The flags passed to the constructor. Must be zero or more of {@link #COMPUTE_MAXS} and {@link
+      * #COMPUTE_FRAMES}.
+      */
+    private final int flags;
+
     // Note: fields are ordered as in the ClassFile structure, and those related to attributes are
     // ordered as in Section 4.7 of the JVMS.
 
@@ -280,23 +286,39 @@ public ClassWriter(final int flags) {
       * @param classReader the {@link ClassReader} used to read the original class. It will be used to
       *     copy the entire constant pool and bootstrap methods from the original class and also to
       *     copy other fragments of original bytecode where applicable.
-      * @param flags option flags that can be used to modify the default behavior of this class.Must be
-      *     zero or more of {@link #COMPUTE_MAXS} and {@link #COMPUTE_FRAMES}. <i>These option flags do
-      *     not affect methods that are copied as is in the new class. This means that neither the
+      * @param flags option flags that can be used to modify the default behavior of this class. Must
+      *     be zero or more of {@link #COMPUTE_MAXS} and {@link #COMPUTE_FRAMES}. <i>These option flags
+      *     do not affect methods that are copied as is in the new class. This means that neither the
       *     maximum stack size nor the stack frames will be computed for these methods</i>.
       */
     public ClassWriter(final ClassReader classReader, final int flags) {
         super(/* latest api = */ Opcodes.ASM9);
+        this.flags = flags;
         symbolTable = classReader == null ? new SymbolTable(this) : new SymbolTable(this, classReader);
         if ((flags & COMPUTE_FRAMES) != 0) {
-            this.compute = MethodWriter.COMPUTE_ALL_FRAMES;
+            compute = MethodWriter.COMPUTE_ALL_FRAMES;
         } else if ((flags & COMPUTE_MAXS) != 0) {
-            this.compute = MethodWriter.COMPUTE_MAX_STACK_AND_LOCAL;
+            compute = MethodWriter.COMPUTE_MAX_STACK_AND_LOCAL;
         } else {
-            this.compute = MethodWriter.COMPUTE_NOTHING;
+            compute = MethodWriter.COMPUTE_NOTHING;
         }
     }
 
+    // -----------------------------------------------------------------------------------------------
+    // Accessors
+    // -----------------------------------------------------------------------------------------------
+
+    /**
+      * Returns true if all the given flags were passed to the constructor.
+      *
+      * @param flags some option flags. Must be zero or more of {@link #COMPUTE_MAXS} and {@link
+      *     #COMPUTE_FRAMES}.
+      * @return true if all the given flags, or more, were passed to the constructor.
+      */
+    public boolean hasFlags(final int flags) {
+        return (this.flags & flags) == flags;
+    }
+
     // -----------------------------------------------------------------------------------------------
     // Implementation of the ClassVisitor abstract class
     // -----------------------------------------------------------------------------------------------