@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -3923,7 +3923,7 @@ public int compareTo(BigInteger val) {
      *
      * @param val BigInteger whose magnitude array to be compared.
      * @return -1, 0 or 1 as this magnitude array is less than, equal to or
-     *         greater than the magnitude aray for the specified BigInteger's.
+     *         greater than the magnitude array for the specified BigInteger's.
      */
     final int compareMagnitude(BigInteger val) {
         int[] m1 = mag;