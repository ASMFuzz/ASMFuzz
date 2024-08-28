@@ -476,7 +476,8 @@ public Object[][] getContents() {
              "    -connect <connector-name>:<name1>=<value1>,...\n" +
              "                      connect to target VM using named connector with listed argument values\n" +
              "    -dbgtrace [flags] print info for debugging {0}\n" +
-             "    -trackvthreads    track virtual threads as they are created\n" +
+             "    -trackallthreads  Track all threads, including virtual threads.\n" +
+             "                      Virtual threads are a preview feature of the Java platform.\n" +
              "    -tclient          run the application in the HotSpot(TM) Client Compiler\n" +
              "    -tserver          run the application in the HotSpot(TM) Server Compiler\n" +
              "    -R<option>        forward <option> to debuggee process if launched by jdb, otherwise ignored\n" +