@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2001, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -33,8 +33,8 @@
  * A LogHandler represents snapshots and update records as serializable
  * objects.
  *
- * This implementation does not know how to create an initial snaphot or
- * apply an update to a snapshot.  The client must specifiy these methods
+ * This implementation does not know how to create an initial snapshot or
+ * apply an update to a snapshot.  The client must specify these methods
  * via a subclass.
  *
  * @see ReliableLog
@@ -61,7 +61,7 @@ public LogHandler() {}
 
     /**
      * Writes the snapshot object to a stream.  This callback is
-     * invoked when the client calls the snaphot method of ReliableLog.
+     * invoked when the client calls the snapshot method of ReliableLog.
      * @param out the output stream
      * @param value the snapshot
      * @exception Exception can raise any exception