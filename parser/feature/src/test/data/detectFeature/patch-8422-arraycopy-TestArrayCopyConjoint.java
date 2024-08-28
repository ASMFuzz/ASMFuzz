@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,30 +26,32 @@
 
 /**
  * @test
- * @bug 8251871
+ * @bug 8251871 8285301
  * @summary Optimize arrayCopy using AVX-512 masked instructions.
  *
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=0 -XX:MaxVectorSize=32 -XX:+UnlockDiagnosticVMOptions
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=0 -XX:MaxVectorSize=64
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=32 -XX:+UnlockDiagnosticVMOptions -XX:MaxVectorSize=32 -XX:+UnlockDiagnosticVMOption
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=32 -XX:+UnlockDiagnosticVMOptions -XX:MaxVectorSize=64
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=64 -XX:MaxVectorSize=64
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=32 -XX:+UnlockDiagnosticVMOptions -XX:MaxVectorSize=32 -XX:+UnlockDiagnosticVMOption -XX:ArrayCopyLoadStoreMaxElem=16
  *      compiler.arraycopy.TestArrayCopyConjoint
- * @run main/othervm/timeout=600 -XX:-TieredCompilation  -Xbatch -XX:+IgnoreUnrecognizedVMOptions
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+IgnoreUnrecognizedVMOptions
  *      -XX:UseAVX=3 -XX:+UnlockDiagnosticVMOptions -XX:ArrayOperationPartialInlineSize=64 -XX:MaxVectorSize=64 -XX:ArrayCopyLoadStoreMaxElem=16
  *      compiler.arraycopy.TestArrayCopyConjoint
+ * @run main/othervm/timeout=600 -XX:-TieredCompilation -Xbatch -XX:+UnlockExperimentalVMOptions -XX:+AlwaysAtomicAccesses
+ *      compiler.arraycopy.TestArrayCopyConjoint
  *
  */
 