@@ -542,7 +542,7 @@ getAllThreads(PacketInputStream *in, PacketOutputStream *out)
         jthread *theVThreads;
 
         theThreads = allThreads(&threadCount);
-        if (gdata->enumerateVThreads) {
+        if (gdata->includeVThreads) {
             theVThreads = threadControl_allVThreads(&vthreadCount);
         } else {
             theVThreads = NULL;