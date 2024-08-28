@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,7 +31,7 @@
  * A special kind of GSSCaller, which origins from HTTP/Negotiate and contains
  * info about what triggers the JGSS calls.
  */
-public class HttpCaller extends GSSCaller {
+public final class HttpCaller extends GSSCaller {
     private final HttpCallerInfo hci;
 
     public HttpCaller(HttpCallerInfo hci) {