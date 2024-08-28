@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,8 +28,8 @@
  * @library /test/lib
  * @modules java.compiler
  * @build jdk.test.lib.compiler.CompilerUtils jdk.test.lib.compiler.ModuleInfoMaker TestSecurityManagerChecks
- * @run main/othervm -Djava.security.manager=allow --enable-preview TestSecurityManagerChecks named
- * @run main/othervm -Djava.security.manager=allow --enable-preview TestSecurityManagerChecks unnamed
+ * @run main/othervm -Djava.security.manager=allow TestSecurityManagerChecks named
+ * @run main/othervm -Djava.security.manager=allow TestSecurityManagerChecks unnamed
  */
 
 import java.io.IOException;