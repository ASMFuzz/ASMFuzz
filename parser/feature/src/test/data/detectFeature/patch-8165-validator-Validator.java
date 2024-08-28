@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -83,7 +83,7 @@
  *
  * @author Andreas Sterbenz
  */
-public abstract class Validator {
+public abstract sealed class Validator permits PKIXValidator, SimpleValidator {
 
     static final X509Certificate[] CHAIN0 = {};
 