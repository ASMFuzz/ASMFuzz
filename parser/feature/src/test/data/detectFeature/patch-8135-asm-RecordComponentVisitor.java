@@ -85,7 +85,7 @@ public abstract class RecordComponentVisitor {
       * @param api the ASM API version implemented by this visitor. Must be one of {@link Opcodes#ASM8}
       *     or {@link Opcodes#ASM9}.
       */
-    public RecordComponentVisitor(final int api) {
+    protected RecordComponentVisitor(final int api) {
         this(api, null);
     }
 
@@ -96,7 +96,7 @@ public RecordComponentVisitor(final int api) {
       * @param recordComponentVisitor the record component visitor to which this visitor must delegate
       *     method calls. May be null.
       */
-    public RecordComponentVisitor(
+    protected RecordComponentVisitor(
             final int api, final RecordComponentVisitor recordComponentVisitor) {
         if (api != Opcodes.ASM9
                 && api != Opcodes.ASM8