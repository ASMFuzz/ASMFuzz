@@ -65,10 +65,15 @@ private StackStreamFactory() {}
     // lazily add subclasses when they are loaded.
     private static final Set<Class<?>> stackWalkImplClasses = init();
 
-    private static final int SMALL_BATCH       = 8;
+    // Minimum batch size for any walker. The shortest walk is for getCallerClass,
+    // which would need to skip a few of StackWalker own frames.
+    private static final int MIN_BATCH_SIZE    = 4;
+
+    // Heuristic sizes to balance the stack walk costs, for both smaller and
+    // larger stacks.
+    private static final int SMALL_BATCH       = MIN_BATCH_SIZE;
     private static final int BATCH_SIZE        = 32;
     private static final int LARGE_BATCH_SIZE  = 256;
-    private static final int MIN_BATCH_SIZE    = SMALL_BATCH;
 
     // These flags must match the values maintained in the VM
     @Native private static final int DEFAULT_MODE              = 0x0;