@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,12 +25,10 @@
 
 package java.security;
 
-import java.security.*;
-import java.util.Enumeration;
-import java.util.Hashtable;
-import java.util.StringTokenizer;
 import sun.security.util.SecurityConstants;
 
+import java.util.Enumeration;
+
 /**
  * The AllPermission is a permission that implies all other permissions.
  * <p>