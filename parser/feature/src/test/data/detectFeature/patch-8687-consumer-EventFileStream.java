@@ -31,7 +31,6 @@
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.Comparator;
-import java.util.Objects;
 import jdk.jfr.consumer.RecordedEvent;
 
 /**
@@ -47,7 +46,7 @@ public final class EventFileStream extends AbstractEventStream {
     private RecordedEvent[] cacheSorted;
 
     public EventFileStream(@SuppressWarnings("removal") AccessControlContext acc, Path file) throws IOException {
-        super(acc, null, Collections.emptyList());
+        super(acc, Collections.emptyList());
         this.input = new RecordingInput(file.toFile(), FileAccess.UNPRIVILEGED);
         this.input.setStreamed();
     }
@@ -73,6 +72,11 @@ public void close() {
         }
     }
 
+    @Override
+    protected boolean isRecording() {
+        return false;
+    }
+
     @Override
     protected void process() throws IOException {
         Dispatcher disp = dispatcher();
@@ -85,18 +89,17 @@ protected void process() throws IOException {
             end = disp.endNanos;
         }
 
-        currentParser = new ChunkParser(input, disp.parserConfiguration, parserState);
+        currentParser = new ChunkParser(input, disp.parserConfiguration, parserState());
         while (!isClosed()) {
             onMetadata(currentParser);
             if (currentParser.getStartNanos() > end) {
                 close();
                 return;
             }
             disp = dispatcher();
-            disp.parserConfiguration.filterStart = start;
-            disp.parserConfiguration.filterEnd = end;
-            currentParser.updateConfiguration(disp.parserConfiguration, true);
-            if (disp.parserConfiguration.isOrdered()) {
+            var ranged  = disp.parserConfiguration.withRange(start, end);
+            currentParser.updateConfiguration(ranged, true);
+            if (disp.parserConfiguration.ordered()) {
                 processOrdered(disp);
             } else {
                 processUnordered(disp);