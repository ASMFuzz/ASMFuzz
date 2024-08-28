@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -45,7 +45,7 @@
  * @since 1.8
  */
 
-public class Krb5ProxyCredential
+final class Krb5ProxyCredential
     implements Krb5CredElement {
 
     public final Krb5InitCredential self;   // the middle server