@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -683,7 +683,7 @@ public void close() throws IOException {}
      *                      the mark position becomes invalid.
      * @see     java.io.InputStream#reset()
      */
-    public synchronized void mark(int readlimit) {}
+    public void mark(int readlimit) {}
 
     /**
      * Repositions this stream to the position at the time the
@@ -729,7 +729,7 @@ public synchronized void mark(int readlimit) {}
      * @see     java.io.InputStream#mark(int)
      * @see     java.io.IOException
      */
-    public synchronized void reset() throws IOException {
+    public void reset() throws IOException {
         throw new IOException("mark/reset not supported");
     }
 