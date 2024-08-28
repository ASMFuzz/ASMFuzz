@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,17 +27,19 @@
  * @summary Tests of BigDecimal.sqrt().
  */
 
-import java.math.*;
-import java.util.*;
+import java.math.BigDecimal;
+import java.math.BigInteger;
+import java.math.MathContext;
+import java.math.RoundingMode;
+import java.util.List;
 
 import static java.math.BigDecimal.ONE;
+import static java.math.BigDecimal.TWO;
 import static java.math.BigDecimal.TEN;
 import static java.math.BigDecimal.ZERO;
 import static java.math.BigDecimal.valueOf;
 
 public class SquareRootTests {
-    private static BigDecimal TWO = new BigDecimal(2);
-
     /**
      * The value 0.1, with a scale of 1.
      */