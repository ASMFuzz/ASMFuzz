@@ -110,9 +110,14 @@ public static class Bindings {
      * Are variadic arguments assigned to registers as in the standard calling
      * convention, or always passed on the stack?
      *
-     * @returns true if variadic arguments should be spilled to the stack.
+     * @return true if variadic arguments should be spilled to the stack.
+      */
+     protected abstract boolean varArgsOnStack();
+
+    /**
+     * {@return true if this ABI requires sub-slot (smaller than STACK_SLOT_SIZE) packing of arguments on the stack.}
      */
-    protected abstract boolean varArgsOnStack();
+    protected abstract boolean requiresSubSlotStackPacking();
 
     protected CallArranger() {}
 
@@ -173,8 +178,9 @@ private static boolean isInMemoryReturn(Optional<MemoryLayout> returnLayout) {
             .isPresent();
     }
 
-    static class StorageCalculator {
+    class StorageCalculator {
         private final boolean forArguments;
+        private boolean forVarArgs = false;
 
         private final int[] nRegs = new int[] { 0, 0 };
         private long stackOffset = 0;
@@ -185,8 +191,21 @@ public StorageCalculator(boolean forArguments) {
 
         VMStorage stackAlloc(long size, long alignment) {
             assert forArguments : "no stack returns";
-            alignment = Math.max(alignment, STACK_SLOT_SIZE);
-            stackOffset = Utils.alignUp(stackOffset, alignment);
+            // Implementation limit: each arg must take up at least an 8 byte stack slot (on the Java side)
+            // There is currently no way to address stack offsets that are not multiples of 8 bytes
+            // The VM can only address multiple-of-4-bytes offsets, which is also not good enough for some ABIs
+            // see JDK-8283462 and related issues
+            long stackSlotAlignment = Math.max(alignment, STACK_SLOT_SIZE);
+            long alignedStackOffset = Utils.alignUp(stackOffset, stackSlotAlignment);
+            // macos-aarch64 ABI potentially requires addressing stack offsets that are not multiples of 8 bytes
+            // Reject such call types here, to prevent undefined behavior down the line
+            // Reject if the above stack-slot-aligned offset does not match the offset the ABI really wants
+            // Except for variadic arguments, which _are_ passed at 8-byte-aligned offsets
+            if (requiresSubSlotStackPacking() && alignedStackOffset != Utils.alignUp(stackOffset, alignment)
+                    && !forVarArgs) // varargs are given a pass on all aarch64 ABIs
+                throw new UnsupportedOperationException("Call type not supported on this platform");
+
+            stackOffset = alignedStackOffset;
 
             VMStorage storage =
                 stackStorage((int)(stackOffset / STACK_SLOT_SIZE));
@@ -233,10 +252,11 @@ void adjustForVarArgs() {
             // no further arguments are allocated to registers.
             nRegs[StorageClasses.INTEGER] = MAX_REGISTER_ARGUMENTS;
             nRegs[StorageClasses.VECTOR] = MAX_REGISTER_ARGUMENTS;
+            forVarArgs = true;
         }
     }
 
-    abstract static class BindingCalculator {
+    abstract class BindingCalculator {
         protected final StorageCalculator storageCalculator;
 
         protected BindingCalculator(boolean forArguments) {
@@ -288,7 +308,7 @@ protected void spillStructBox(Binding.Builder bindings, MemoryLayout layout) {
         abstract List<Binding> getIndirectBindings();
     }
 
-    static class UnboxBindingCalculator extends BindingCalculator {
+    class UnboxBindingCalculator extends BindingCalculator {
         UnboxBindingCalculator(boolean forArguments) {
             super(forArguments);
         }
@@ -389,7 +409,7 @@ List<Binding> getBindings(Class<?> carrier, MemoryLayout layout) {
         }
     }
 
-    static class BoxBindingCalculator extends BindingCalculator{
+    class BoxBindingCalculator extends BindingCalculator {
         BoxBindingCalculator(boolean forArguments) {
             super(forArguments);
         }