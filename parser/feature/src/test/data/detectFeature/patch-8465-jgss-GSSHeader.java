@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -280,7 +280,7 @@ private int getLength(int lenByte, InputStream in) throws IOException {
     /**
      * Put the encoding of the length in the specified stream.
      *
-     * @params len the length of the attribute.
+     * @param len the length of the attribute.
      * @param out the outputstream to write the length to
      * @return the number of bytes written
      * @exception IOException on writing errors.