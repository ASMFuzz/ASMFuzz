@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,6 +39,6 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm/native -agentlib:allthr001 nsk.jvmti.GetAllThreads.allthr001 5
+ * @run main/othervm/native -agentlib:allthr001=printdump nsk.jvmti.GetAllThreads.allthr001 5
  */
 