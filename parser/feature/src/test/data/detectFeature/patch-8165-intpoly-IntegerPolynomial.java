@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -61,7 +61,14 @@
  *
  */
 
-public abstract class IntegerPolynomial implements IntegerFieldModuloP {
+public abstract sealed class IntegerPolynomial implements IntegerFieldModuloP
+    permits IntegerPolynomial1305, IntegerPolynomial25519,
+            IntegerPolynomial448, IntegerPolynomialP256,
+            IntegerPolynomialP384, IntegerPolynomialP521,
+            IntegerPolynomialModBinP, P256OrderField,
+            P384OrderField, P521OrderField,
+            sun.security.util.math.intpoly.Curve25519OrderField,
+            sun.security.util.math.intpoly.Curve448OrderField {
 
     protected static final BigInteger TWO = BigInteger.valueOf(2);
 