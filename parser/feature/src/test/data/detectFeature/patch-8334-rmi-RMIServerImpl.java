@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -414,7 +414,7 @@ public synchronized void close() throws IOException {
         // Loop to close all clients
         while (true) {
             synchronized (clientList) {
-                if (debug) logger.debug("close","droping dead references");
+                if (debug) logger.debug("close","dropping dead references");
                 dropDeadReferences();
 
                 if (debug) logger.debug("close","client count: "+clientList.size());