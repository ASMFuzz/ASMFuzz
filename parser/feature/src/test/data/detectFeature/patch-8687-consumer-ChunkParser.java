@@ -50,30 +50,17 @@
  */
 public final class ChunkParser {
 
-    public static final class ParserConfiguration {
-        private final boolean reuse;
-        private final boolean ordered;
-        private final ParserFilter eventFilter;
-        private final ChunkWriter chunkWriter;
-
-        long filterStart;
-        long filterEnd;
-
-        public ParserConfiguration(long filterStart, long filterEnd, boolean reuse, boolean ordered, ParserFilter filter, ChunkWriter chunkWriter) {
-            this.filterStart = filterStart;
-            this.filterEnd = filterEnd;
-            this.reuse = reuse;
-            this.ordered = ordered;
-            this.eventFilter = filter;
-            this.chunkWriter = chunkWriter;
-        }
+    public record ParserConfiguration(long filterStart, long filterEnd, boolean reuse,  boolean ordered, ParserFilter filter, ChunkWriter chunkWriter) {
 
         public ParserConfiguration() {
             this(0, Long.MAX_VALUE, false, false, ParserFilter.ACCEPT_ALL, null);
         }
 
-        public boolean isOrdered() {
-            return ordered;
+        ParserConfiguration withRange(long filterStart, long filterEnd) {
+            if (filterStart == this.filterStart && filterEnd == this.filterEnd) {
+                return this;
+            }
+            return new ParserConfiguration(filterStart, filterEnd, reuse, ordered, filter, chunkWriter);
         }
     }
 
@@ -178,7 +165,7 @@ void updateConfiguration(ParserConfiguration configuration, boolean resetEventCa
                 ep.setReuse(configuration.reuse);
                 ep.setFilterStart(configuration.filterStart);
                 ep.setFilterEnd(configuration.filterEnd);
-                long threshold = configuration.eventFilter.getThreshold(name);
+                long threshold = configuration.filter().getThreshold(name);
                 if (threshold >= 0) {
                     ep.setEnabled(true);
                     ep.setThresholdNanos(threshold);