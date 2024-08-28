@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -304,7 +304,7 @@ public synchronized Integer[] removeNotificationListener(ObjectName name) {
      * and the thread used to fetch notifis will be stopped, a new thread can be
      * created only after the method <code>postReconnection</code> is called.
      *
-     * It is caller's responsiblity to not re-call this method before calling
+     * It is caller's responsibility to not re-call this method before calling
      * <code>postReconnection</code>.
      */
     public synchronized ClientListenerInfo[] preReconnection() throws IOException {
@@ -561,7 +561,7 @@ private void doRun() {
             if (nr == null) {
                 if (logger.traceOn()) {
                     logger.trace("NotifFetcher-run",
-                            "Recieved null object as notifs, stops fetching because the "
+                            "Received null object as notifs, stops fetching because the "
                                     + "notification server is terminated.");
                 }
             }
@@ -792,7 +792,7 @@ private synchronized void setState(int newState) {
 
     /*
      * Called to decide whether need to start a thread for fetching notifs.
-     * <P>The parameter reconnected will decide whether to initilize the clientSequenceNumber,
+     * <P>The parameter reconnected will decide whether to initialize the clientSequenceNumber,
      * initilaizing the clientSequenceNumber means to ignore all notifications arrived before.
      * If it is reconnected, we will not initialize in order to get all notifications arrived
      * during the reconnection. It may cause the newly registered listeners to receive some