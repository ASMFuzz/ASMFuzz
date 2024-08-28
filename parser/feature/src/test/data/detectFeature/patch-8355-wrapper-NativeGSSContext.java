@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -237,7 +237,7 @@ private byte[] retrieveToken(InputStream is, int mechTokenLen)
     // Constructor for imported context
     // Warning: called by NativeUtil.c
     NativeGSSContext(long pCtxt, GSSLibStub stub) throws GSSException {
-        assert(pContext != 0);
+        assert(pCtxt != 0);
         pContext = pCtxt;
         cStub = stub;
 