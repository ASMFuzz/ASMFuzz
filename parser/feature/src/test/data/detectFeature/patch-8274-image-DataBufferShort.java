@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,7 +35,8 @@
 
 package java.awt.image;
 
-import static sun.java2d.StateTrackable.State.*;
+import static sun.java2d.StateTrackable.State.STABLE;
+import static sun.java2d.StateTrackable.State.UNTRACKABLE;
 
 /**
  * This class extends {@code DataBuffer} and stores data internally as shorts.
@@ -81,7 +82,7 @@ public DataBufferShort(int size) {
      * banks all of which are the specified size.
      *
      * @param size The size of the banks in the {@code DataBuffer}.
-     * @param numBanks The number of banks in the a {@code DataBuffer}.
+     * @param numBanks The number of banks in the {@code DataBuffer}.
      */
     public DataBufferShort(int size, int numBanks) {
         super(STABLE, TYPE_SHORT,size,numBanks);