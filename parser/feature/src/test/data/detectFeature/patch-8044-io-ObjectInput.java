@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -62,8 +62,9 @@ public Object readObject()
      * Reads into an array of bytes.  This method will
      * block until some input is available.
      * @param   b the buffer into which the data is read
-     * @return  the actual number of bytes read, -1 is
-     *          returned when the end of the stream is reached.
+     * @return  the total number of bytes read into the buffer, or
+     *          {@code -1} if there is no more data because the end of
+     *          the stream has been reached.
      * @throws  IOException If an I/O error has occurred.
      */
     public int read(byte[] b) throws IOException;
@@ -74,8 +75,9 @@ public Object readObject()
      * @param   b the buffer into which the data is read
      * @param   off the start offset of the data
      * @param   len the maximum number of bytes read
-     * @return  the actual number of bytes read, -1 is
-     *          returned when the end of the stream is reached.
+     * @return  the total number of bytes read into the buffer, or
+     *          {@code -1} if there is no more data because the end of
+     *          the stream has been reached.
      * @throws  IOException If an I/O error has occurred.
      */
     public int read(byte[] b, int off, int len) throws IOException;