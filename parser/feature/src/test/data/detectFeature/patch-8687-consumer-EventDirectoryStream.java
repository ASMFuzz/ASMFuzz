@@ -41,7 +41,6 @@
 import jdk.jfr.internal.PlatformRecording;
 import jdk.jfr.internal.SecuritySupport;
 import jdk.jfr.internal.Utils;
-import jdk.jfr.internal.consumer.ChunkParser.ParserConfiguration;
 
 /**
  * Implementation of an {@code EventStream}} that operates against a directory
@@ -54,7 +53,7 @@ public final class EventDirectoryStream extends AbstractEventStream {
 
     private final RepositoryFiles repositoryFiles;
     private final FileAccess fileAccess;
-
+    private final PlatformRecording recording;
     private ChunkParser currentParser;
     private long currentChunkStartNanos;
     private RecordedEvent[] sortedCache;
@@ -70,7 +69,8 @@ public EventDirectoryStream(
             PlatformRecording recording,
             List<Configuration> configurations,
             boolean allowSubDirectories) throws IOException {
-        super(acc, recording, configurations);
+        super(acc, configurations);
+        this.recording = recording;
         if (p != null && SecuritySupport.PRIVILEGED == fileAccess) {
             throw new SecurityException("Priviliged file access not allowed with potentially malicious Path implementation");
         }
@@ -134,7 +134,7 @@ protected void processRecursionSafe() throws IOException {
         Dispatcher lastDisp = null;
         Dispatcher disp = dispatcher();
         Path path;
-        boolean validStartTime = recording != null || disp.startTime != null;
+        boolean validStartTime = isRecording() || disp.startTime != null;
         if (validStartTime) {
             path = repositoryFiles.firstPath(disp.startNanos, true);
         } else {
@@ -146,7 +146,7 @@ protected void processRecursionSafe() throws IOException {
         currentChunkStartNanos = repositoryFiles.getTimestamp(path);
         try (RecordingInput input = new RecordingInput(path.toFile(), fileAccess)) {
             input.setStreamed();
-            currentParser = new ChunkParser(input, disp.parserConfiguration, parserState);
+            currentParser = new ChunkParser(input, disp.parserConfiguration, parserState());
             long segmentStart = currentParser.getStartNanos() + currentParser.getChunkDuration();
             long filterStart = validStartTime ? disp.startNanos : segmentStart;
             long filterEnd = disp.endTime != null ? disp.endNanos : Long.MAX_VALUE;
@@ -156,13 +156,11 @@ protected void processRecursionSafe() throws IOException {
                 while (!isClosed() && !currentParser.isChunkFinished()) {
                     disp = dispatcher();
                     if (disp != lastDisp) {
-                        ParserConfiguration pc = disp.parserConfiguration;
-                        pc.filterStart = filterStart;
-                        pc.filterEnd = filterEnd;
-                        currentParser.updateConfiguration(pc, true);
+                        var ranged = disp.parserConfiguration.withRange(filterStart, filterEnd);
+                        currentParser.updateConfiguration(ranged, true);
                         lastDisp = disp;
                     }
-                    if (disp.parserConfiguration.isOrdered()) {
+                    if (disp.parserConfiguration.ordered()) {
                         processOrdered(disp);
                     } else {
                         processUnordered(disp);
@@ -208,12 +206,16 @@ protected void processRecursionSafe() throws IOException {
     }
 
     private boolean isLastChunk() {
-        if (recording == null) {
+        if (!isRecording()) {
             return false;
         }
         return recording.getFinalChunkStartNanos() >= currentParser.getStartNanos();
     }
 
+    protected boolean isRecording() {
+        return recording != null;
+    }
+
     private void processOrdered(Dispatcher c) throws IOException {
         if (sortedCache == null) {
             sortedCache = new RecordedEvent[100_000];