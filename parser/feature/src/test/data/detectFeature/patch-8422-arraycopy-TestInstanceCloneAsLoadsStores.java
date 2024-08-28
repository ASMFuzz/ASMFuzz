@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug 6700100 8156760 8248226
+ * @bug 6700100 8156760 8248226 8285301
  * @summary small instance clone as loads/stores
  * @library /
  *
@@ -42,6 +42,10 @@
  *                   -XX:CompileCommand=dontinline,compiler.arraycopy.TestInstanceCloneAsLoadsStores::m*
  *                   -XX:+IgnoreUnrecognizedVMOptions -XX:-ReduceInitialCardMarks -XX:-ReduceBulkZeroing
  *                   compiler.arraycopy.TestInstanceCloneAsLoadsStores
+ * @run main/othervm -XX:-BackgroundCompilation -XX:-UseOnStackReplacement
+ *                   -XX:CompileCommand=dontinline,compiler.arraycopy.TestInstanceCloneAsLoadsStores::m*
+ *                   -XX:+UnlockExperimentalVMOptions -XX:+AlwaysAtomicAccesses
+ *                   compiler.arraycopy.TestInstanceCloneAsLoadsStores
  */
 
 package compiler.arraycopy;