@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -71,7 +71,7 @@ public final class NTLMException extends GeneralSecurityException {
      * Constructs an NTLMException object.
      * @param errorCode the error code, which can be retrieved by
      * the {@link #errorCode() } method.
-     * @param msg the string message, which can be retrived by
+     * @param msg the string message, which can be retrieved by
      * the {@link Exception#getMessage() } method.
      */
     public NTLMException(int errorCode, String msg) {