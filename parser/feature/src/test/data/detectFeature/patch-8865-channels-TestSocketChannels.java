@@ -54,6 +54,7 @@
 public class TestSocketChannels extends AbstractChannelsTest {
 
     static final Class<IllegalStateException> ISE = IllegalStateException.class;
+    static final Class<WrongThreadException> WTE = WrongThreadException.class;
 
     @Test(dataProvider = "closeableSessions")
     public void testBasicIOWithClosedSegment(Supplier<MemorySession> sessionSupplier)
@@ -151,7 +152,7 @@ public void testIOOnConfinedFromAnotherThread(Supplier<MemorySession> sessionSup
             );
             for (var ioOp : ioOps) {
                 AtomicReference<Exception> exception = new AtomicReference<>();
-                Runnable task = () -> exception.set(expectThrows(ISE, ioOp));
+                Runnable task = () -> exception.set(expectThrows(WTE, ioOp));
                 var t = new Thread(task);
                 t.start();
                 t.join();