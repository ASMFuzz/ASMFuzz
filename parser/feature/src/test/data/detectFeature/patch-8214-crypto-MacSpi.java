@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -104,7 +104,7 @@ protected abstract void engineInit(Key key,
      * @since 1.5
      */
     protected void engineUpdate(ByteBuffer input) {
-        if (input.hasRemaining() == false) {
+        if (!input.hasRemaining()) {
             return;
         }
         if (input.hasArray()) {