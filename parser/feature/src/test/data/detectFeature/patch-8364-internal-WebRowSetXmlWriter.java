@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -625,7 +625,7 @@ public boolean writeData(RowSetInternal caller) {
 
     /**
      * This function has been added for the processing of special characters
-     * lik <,>,'," and & in the data to be serialized. These have to be taken
+     * like <,>,'," and & in the data to be serialized. These have to be taken
      * of specifically or else there will be parsing error while trying to read
      * the contents of the XML file.
      **/