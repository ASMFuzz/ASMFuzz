@@ -199,7 +199,7 @@ public MemorySessionImpl sessionImpl() {
     @ForceInline
     public final void checkValidState() {
         if (owner != null && owner != Thread.currentThread()) {
-            throw new IllegalStateException("Attempted access outside owning thread");
+            throw new WrongThreadException("Attempted access outside owning thread");
         }
         if (state < OPEN) {
             throw ScopedMemoryAccess.ScopedAccessError.INSTANCE;
@@ -213,7 +213,7 @@ public final void checkValidState() {
      */
     public final void checkValidStateSlow() {
         if (owner != null && Thread.currentThread() != owner) {
-            throw new IllegalStateException("Attempted access outside owning thread");
+            throw new WrongThreadException("Attempted access outside owning thread");
         } else if (!isAlive()) {
             throw new IllegalStateException("Already closed");
         }