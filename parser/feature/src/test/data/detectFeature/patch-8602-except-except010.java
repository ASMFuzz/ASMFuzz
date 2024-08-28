@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,6 +58,7 @@
  *     JDK 1.3 classic VM for Sparc may crash (core dump) due to the known bug:
  *         #4245057 (P2/S3) VM crashes when heap is exhausted
  *
+ * @requires vm.opt.DeoptimizeALot != true
  * @run main/othervm -Xms50M -Xmx200M nsk.stress.except.except010
  */
 