@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -337,6 +337,10 @@ public static boolean filtered(Event event) {
         if (event.toString().contains("JFR request timer"))
             return true;
 
+        // Filter out any carrier thread that starts while running the test.
+        if (event.toString().contains("ForkJoinPool"))
+            return true;
+
         return false;
     }
 