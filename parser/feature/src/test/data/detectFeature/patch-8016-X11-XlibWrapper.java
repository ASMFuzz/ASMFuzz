@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -524,13 +524,6 @@ static native void XConvertCase(long keysym,
     static native void XChangeActivePointerGrab(long display, int mask,
                                                 long cursor, long time);
 
-    /*
-      int (*XSynchronize(Display *display, Bool onoff))();
-          display   Specifies the connection to the X server.
-          onoff     Specifies a Boolean value that indicates whether to enable or disable synchronization.
-     */
-    static native int XSynchronize(long display, boolean onoff);
-
     /**
      * Extracts an X event that can be processed in a secondary loop.
      * Should only be called on the toolkit thread.