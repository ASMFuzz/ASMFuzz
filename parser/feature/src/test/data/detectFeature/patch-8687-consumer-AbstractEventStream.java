@@ -59,19 +59,14 @@ public abstract class AbstractEventStream implements EventStream {
     @SuppressWarnings("removal")
     private final AccessControlContext accessControllerContext;
     private final StreamConfiguration streamConfiguration = new StreamConfiguration();
-    protected final PlatformRecording recording;
     private final List<Configuration> configurations;
-
+    private final ParserState parserState = new ParserState();
     private volatile Thread thread;
     private Dispatcher dispatcher;
-
-    protected final ParserState parserState = new ParserState();
-
     private boolean daemon = false;
 
-    AbstractEventStream(@SuppressWarnings("removal") AccessControlContext acc, PlatformRecording recording, List<Configuration> configurations) throws IOException {
+    AbstractEventStream(@SuppressWarnings("removal") AccessControlContext acc, List<Configuration> configurations) throws IOException {
         this.accessControllerContext = Objects.requireNonNull(acc);
-        this.recording = recording;
         this.configurations = configurations;
     }
 
@@ -215,6 +210,8 @@ public final void awaitTermination(Duration timeout) throws InterruptedException
 
     protected abstract void process() throws IOException;
 
+    protected abstract boolean isRecording();
+
     protected final void closeParser() {
         parserState.close();
     }
@@ -223,6 +220,10 @@ protected final boolean isClosed() {
         return parserState.isClosed();
     }
 
+    protected final ParserState parserState() {
+        return parserState;
+    }
+
     public final void startAsync(long startNanos) {
         startInternal(startNanos);
         Runnable r = () -> run(accessControllerContext);
@@ -254,7 +255,7 @@ private void startInternal(long startNanos) {
             if (streamConfiguration.started) {
                 throw new IllegalStateException("Event stream can only be started once");
             }
-            if (recording != null && streamConfiguration.startTime == null) {
+            if (isRecording() && streamConfiguration.startTime == null) {
                 streamConfiguration.setStartNanos(startNanos);
             }
             streamConfiguration.setStarted(true);