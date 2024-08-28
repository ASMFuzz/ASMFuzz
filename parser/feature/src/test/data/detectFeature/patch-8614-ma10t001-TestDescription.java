@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,8 +39,8 @@
  * @library /vmTestbase
  *          /test/lib
  * @run main/othervm/native
- *      -agentlib:ma10t001=-waittime=5
- *      -agentlib:ma10t001a=-waittime=5
+ *      -agentlib:ma10t001=-waittime=5,-verbose
+ *      -agentlib:ma10t001a=-waittime=5,-verbose
  *      nsk.jvmti.scenarios.multienv.MA10.ma10t001
  */
 