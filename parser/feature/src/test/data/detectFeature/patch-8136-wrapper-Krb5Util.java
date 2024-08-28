@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 package sun.security.jgss.wrapper;
 
 import org.ietf.jgss.*;
+import java.lang.ref.Cleaner;
 import javax.security.auth.kerberos.ServicePermission;
 
 /**
@@ -33,6 +34,8 @@
  * @since 1.6
  */
 class Krb5Util {
+    // A cleaner, shared within this module.
+    static final Cleaner cleaner = Cleaner.create();
 
     // Return the Kerberos TGS principal name using the domain
     // of the specified <code>name</code>