@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
@@ -32,7 +32,7 @@
 /**
  * This class makes an select statement act like an result tree fragment.
  *
- * @LastModified: Oct 2017
+ * @LastModified: Apr 2022
  */
 public class XRTreeFragSelectWrapper extends XRTreeFrag implements Cloneable
 {
@@ -152,7 +152,7 @@ public int rtf()
    */
   public DTMIterator asNodeIterator()
   {
-    throw new RuntimeException(XSLMessages.createXPATHMessage(XPATHErrorResources.ER_RTF_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER, null)); //"asNodeIterator() not supported by XRTreeFragSelectWrapper!");
+    throw new RuntimeException(XSLMessages.createXPATHMessage(XPATHErrorResources.ER_ASNODEITERATOR_NOT_SUPPORTED_XRTREEFRAGSELECTWRAPPER, null)); //"asNodeIterator() not supported by XRTreeFragSelectWrapper!");
   }
 
 }