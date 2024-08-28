@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,7 +38,6 @@ public class allthr001 {
         }
     }
 
-    native static void setSysCnt();
     native static void checkInfo(int thr_ind);
     native static int getRes();
 
@@ -64,7 +63,6 @@ public static int run(String args[], PrintStream out) {
         }
         out.println("# Waiting time = " + waitTime + " mins");
 
-        setSysCnt();
         checkInfo(0);
 
         ThreadGroup tg = new ThreadGroup("tg1");