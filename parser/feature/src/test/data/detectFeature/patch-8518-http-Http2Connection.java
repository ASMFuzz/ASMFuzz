@@ -761,7 +761,7 @@ void processFrame(Http2Frame frame) throws IOException {
             }
 
             Stream<?> stream = getStream(streamid);
-            if (stream == null) {
+            if (stream == null && pushContinuationState == null) {
                 // Should never receive a frame with unknown stream id
 
                 if (frame instanceof HeaderFrame) {
@@ -801,7 +801,11 @@ void processFrame(Http2Frame frame) throws IOException {
             if (pushContinuationState != null) {
                 if (frame instanceof ContinuationFrame cf) {
                     try {
-                        handlePushContinuation(stream, cf);
+                        if (streamid == pushContinuationState.pushContFrame.streamid())
+                            handlePushContinuation(stream, cf);
+                        else
+                            protocolError(ErrorFrame.PROTOCOL_ERROR, "Received a Continuation Frame with an " +
+                                    "unexpected stream id");
                     } catch (UncheckedIOException e) {
                         debug.log("Error handling Push Promise with Continuation: " + e.getMessage(), e);
                         protocolError(ErrorFrame.PROTOCOL_ERROR, e.getMessage());
@@ -888,8 +892,6 @@ private <T> void handlePushContinuation(Stream<T> parent, ContinuationFrame cf)
 
     private <T> void completePushPromise(int promisedStreamid, Stream<T> parent, HttpHeaders headers)
             throws IOException {
-        // Perhaps the following checks could be moved to handlePushPromise()
-        // to reset the PushPromise stream earlier?
         HttpRequestImpl parentReq = parent.request;
         if (promisedStreamid != nextPushStream) {
             resetStream(promisedStreamid, ResetFrame.PROTOCOL_ERROR);