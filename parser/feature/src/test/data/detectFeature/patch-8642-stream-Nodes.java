@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -2055,14 +2055,14 @@ public void compute() {
                 else {
                     task.setPendingCount(task.node.getChildCount() - 1);
 
-                    int size = 0;
+                    long size = 0;
                     int i = 0;
                     for (;i < task.node.getChildCount() - 1; i++) {
-                        K leftTask = task.makeChild(i, task.offset + size);
+                        K leftTask = task.makeChild(i, (int) (task.offset + size));
                         size += leftTask.node.count();
                         leftTask.fork();
                     }
-                    task = task.makeChild(i, task.offset + size);
+                    task = task.makeChild(i, (int) (task.offset + size));
                 }
             }
         }