@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,7 +30,8 @@
  * into the mechanism level so that special actions can be performed for
  * different callers.
  */
-public class GSSCaller {
+public sealed class GSSCaller permits HttpCaller {
+
     public static final GSSCaller CALLER_UNKNOWN = new GSSCaller("UNKNOWN");
     public static final GSSCaller CALLER_INITIATE = new GSSCaller("INITIATE");
     public static final GSSCaller CALLER_ACCEPT = new GSSCaller("ACCEPT");