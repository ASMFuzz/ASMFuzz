@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,8 +25,8 @@
  * @test
  * @bug 8227046
  * @summary reflection test for sealed classes
- * @compile --enable-preview -source ${jdk.version} SealedClassesReflectionTest.java
- * @run testng/othervm --enable-preview SealedClassesReflectionTest
+ * @compile SealedClassesReflectionTest.java
+ * @run testng/othervm SealedClassesReflectionTest
  */
 
 import java.lang.annotation.*;