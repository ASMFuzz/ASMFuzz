@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -204,7 +204,7 @@ public void close() throws IOException {
      * @see     java.io.FilterInputStream#reset()
      */
     @Override
-    public synchronized void mark(int readlimit) {
+    public void mark(int readlimit) {
         in.mark(readlimit);
     }
 
@@ -230,7 +230,7 @@ public synchronized void mark(int readlimit) {
      * @see        java.io.FilterInputStream#mark(int)
      */
     @Override
-    public synchronized void reset() throws IOException {
+    public void reset() throws IOException {
         in.reset();
     }
 