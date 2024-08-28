@@ -134,7 +134,7 @@ public State next() {
     private int bufferIndex;
     private State state = State.HEADER;
     private byte[] currentByteArray;
-    private int typeId;
+    private long typeId;
     private int typeIdshift;
     private int sizeShift;
     private int payLoadSize;
@@ -258,7 +258,7 @@ private void processEventSize() throws IOException {
 
         eventFieldSize++;
         byte b = nextByte(false);
-        long v = (b & 0x7FL);
+        int v = (b & 0x7F);
         payLoadSize += (v << sizeShift);
         if (b >= 0) {
             if (payLoadSize == 0) {