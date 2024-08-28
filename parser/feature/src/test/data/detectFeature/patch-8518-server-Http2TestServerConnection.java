@@ -945,6 +945,11 @@ private void handlePush(OutgoingPushPromise op) throws IOException {
         nextPushStreamId += 2;
         pp.streamid(op.parentStream);
         writeFrame(pp);
+        // No need to check for END_HEADERS flag here to allow for tests to simulate bad server side
+        // behavior i.e Continuation Frames included with END_HEADERS flag set
+        for (Http2Frame cf : op.getContinuations())
+            writeFrame(cf);
+
         final InputStream ii = op.is;
         final BodyOutputStream oo = new BodyOutputStream(
                 promisedStreamid,