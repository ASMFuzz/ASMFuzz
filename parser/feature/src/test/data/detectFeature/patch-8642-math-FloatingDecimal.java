@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -834,7 +834,7 @@ static int estimateDecExp(long fractBits, int binExp) {
             }
         }
 
-        private static int insignificantDigits(int insignificant) {
+        private static int insignificantDigits(long insignificant) {
             int i;
             for ( i = 0; insignificant >= 10L; i++ ) {
                 insignificant /= 10L;