@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -110,7 +110,7 @@ public void run() {
                     long d = maxObjectInspectionAge();
                     if (d >= l) {
                         /* Do a full collection.  There is a remote possibility
-                         * that a full collection will occurr between the time
+                         * that a full collection will occur between the time
                          * we sample the inspection age and the time the GC
                          * actually starts, but this is sufficiently unlikely
                          * that it doesn't seem worth the more expensive JVM
@@ -177,7 +177,7 @@ private static void setLatencyTarget(long ms) {
     public static class LatencyRequest
         implements Comparable<LatencyRequest> {
 
-        /* Instance counter, used to generate unique identifers */
+        /* Instance counter, used to generate unique identifiers */
         private static long counter = 0;
 
         /* Sorted set of active latency requests */