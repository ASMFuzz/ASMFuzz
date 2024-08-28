@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -451,8 +451,8 @@ public void moveToInsertRow() throws SQLException {
 
    /**
      * This is explanation for the overriding of the updateXXX functions.
-     * These functions have been overriden to ensure that only correct
-     * values that pass the criteria for the filter are actaully inserted.
+     * These functions have been overridden to ensure that only correct
+     * values that pass the criteria for the filter are actually inserted.
      * The evaluation of whether a particular value passes the criteria
      * of the filter is done using the evaluate function in the Predicate
      * interface.