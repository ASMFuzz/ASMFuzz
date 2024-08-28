@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -427,7 +427,7 @@ static void loadSystemColorsForCDE(int[] systemColors) throws Exception  {
 
         for (int i=0;i<8;i++) {
             temp = bfr.readLine();
-            color = temp.substring(1,temp.length());
+            color = temp.substring(1);
             r = Integer.parseInt(color.substring(0, 4), 16) >> 8;
             g = Integer.parseInt(color.substring(4, 8), 16) >> 8;
             b = Integer.parseInt(color.substring(8, 12), 16) >> 8;