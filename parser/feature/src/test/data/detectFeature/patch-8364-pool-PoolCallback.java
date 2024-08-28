@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -43,7 +43,7 @@
  */
 public interface PoolCallback {
     /**
-     * Releases a useable connection back to the pool.
+     * Releases a usable connection back to the pool.
      *
      * @param conn The connection to release.
      * @return true if the connection released; false if the connection