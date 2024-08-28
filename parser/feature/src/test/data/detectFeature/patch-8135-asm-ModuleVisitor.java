@@ -85,7 +85,7 @@ public abstract class ModuleVisitor {
       * @param api the ASM API version implemented by this visitor. Must be one of {@link Opcodes#ASM6}
       *     or {@link Opcodes#ASM7}.
       */
-    public ModuleVisitor(final int api) {
+    protected ModuleVisitor(final int api) {
         this(api, null);
     }
 
@@ -97,7 +97,7 @@ public ModuleVisitor(final int api) {
       * @param moduleVisitor the module visitor to which this visitor must delegate method calls. May
       *     be null.
       */
-    public ModuleVisitor(final int api, final ModuleVisitor moduleVisitor) {
+    protected ModuleVisitor(final int api, final ModuleVisitor moduleVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8
                 && api != Opcodes.ASM7