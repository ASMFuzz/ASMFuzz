@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,7 +32,7 @@
  * The representation uses 16 signed long values.
  */
 
-public class IntegerPolynomial448 extends IntegerPolynomial {
+public final class IntegerPolynomial448 extends IntegerPolynomial {
 
     private static final int POWER = 448;
     private static final int NUM_LIMBS = 16;