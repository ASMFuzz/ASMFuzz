@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,8 +26,8 @@
  * @summary Ensure that sun.misc.Unsafe::objectFieldOffset and staticFieldOffset
  *          throw UnsupportedOperationException on Field of a hidden or record class
  * @modules jdk.unsupported
- * @compile --enable-preview -source ${jdk.version} UnsafeFieldOffsets.java
- * @run testng/othervm --enable-preview UnsafeFieldOffsets
+ * @compile UnsafeFieldOffsets.java
+ * @run testng/othervm UnsafeFieldOffsets
  */
 
 import sun.misc.Unsafe;