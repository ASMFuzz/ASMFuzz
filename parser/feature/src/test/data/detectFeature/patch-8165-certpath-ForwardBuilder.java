@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -59,7 +59,7 @@
  * @author      Yassir Elley
  * @author      Sean Mullan
  */
-class ForwardBuilder extends Builder {
+final class ForwardBuilder extends Builder {
 
     private static final Debug debug = Debug.getInstance("certpath");
     private final Set<X509Certificate> trustedCerts;