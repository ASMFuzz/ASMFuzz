@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -300,7 +300,7 @@ ATTRIBUTE_ALIGNED(64) jubyte StubRoutines::aarch64::_adler_table[] = {
 ATTRIBUTE_ALIGNED(64) juint StubRoutines::aarch64::_npio2_hw[] = {
     // first, various coefficient values: 0.5, invpio2, pio2_1, pio2_1t, pio2_2,
     // pio2_2t, pio2_3, pio2_3t
-    // This is a small optimization wich keeping double[8] values in int[] table
+    // This is a small optimization which keeping double[8] values in int[] table
     // to have less address calculation instructions
     //
     // invpio2:  53 bits of 2/pi (enough for cases when trigonometric argument is small)