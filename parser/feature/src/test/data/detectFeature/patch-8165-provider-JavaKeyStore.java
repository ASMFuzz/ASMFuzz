@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -54,7 +54,7 @@
  * @since 1.2
  */
 
-public abstract class JavaKeyStore extends KeyStoreSpi {
+public abstract sealed class JavaKeyStore extends KeyStoreSpi {
 
     // regular JKS
     public static final class JKS extends JavaKeyStore {