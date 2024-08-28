@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -47,7 +47,7 @@
  * @since   1.5
  * @author  Andreas Sterbenz
  */
-public abstract class RSAKeyPairGenerator extends KeyPairGeneratorSpi {
+abstract class RSAKeyPairGenerator extends KeyPairGeneratorSpi {
 
     private static final BigInteger SQRT_2048;
     private static final BigInteger SQRT_3072;