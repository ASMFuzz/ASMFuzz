@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -717,7 +717,7 @@ public byte[] getBitString(boolean tagImplicit) throws IOException {
         byte[] retval = Arrays.copyOfRange(buffer, start + 1, end);
         if (numOfPadBits != 0) {
             // get rid of the padding bits
-            retval[end - start - 2] &= (0xff << numOfPadBits);
+            retval[end - start - 2] &= (byte)((0xff << numOfPadBits));
         }
         data.pos = data.end; // Compatibility. Reach end.
         return retval;