@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -48,7 +48,9 @@
  * @build jdk.jpackage.test.*
  * @modules jdk.jpackage/jdk.jpackage.internal
  * @compile AddLShortcutTest.java
- * @run main/othervm/timeout=540 -Xmx512m jdk.jpackage.test.Main
+ * @run main/othervm/timeout=540 -Xmx512m
+ *  --add-opens jdk.jpackage/jdk.jpackage.internal=ALL-UNNAMED
+ *  jdk.jpackage.test.Main
  *  --jpt-run=AddLShortcutTest
  */
 