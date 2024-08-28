@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -80,7 +80,7 @@
  * @since 1.4
  */
 
-public class GSSNameImpl implements GSSName {
+public final class GSSNameImpl implements GSSName {
 
     /**
      * The old Oid used in RFC 2853. Now supported as