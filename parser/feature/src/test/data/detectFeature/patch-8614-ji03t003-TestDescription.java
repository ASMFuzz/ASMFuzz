@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -41,6 +41,6 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm/native -agentlib:ji03t003 nsk.jvmti.scenarios.jni_interception.JI03.ji03t003
+ * @run main/othervm/native -agentlib:ji03t003=-verbose nsk.jvmti.scenarios.jni_interception.JI03.ji03t003 -verbose
  */
 