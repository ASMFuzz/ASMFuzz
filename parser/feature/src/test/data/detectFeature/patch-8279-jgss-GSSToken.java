@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -203,10 +203,6 @@ public static final void readFully(InputStream is,
         }
     }
 
-    public static final void debug(String str) {
-        System.err.print(str);
-    }
-
     public static final  String getHexBytes(byte[] bytes) {
         return getHexBytes(bytes, 0, bytes.length);
     }