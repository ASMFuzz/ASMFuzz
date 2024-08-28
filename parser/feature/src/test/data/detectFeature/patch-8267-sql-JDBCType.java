@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -209,9 +209,9 @@ public enum JDBCType implements SQLType {
     private final Integer type;
 
     /**
-     * Constructor to specify the data type value from {@code Types) for
+     * Constructor to specify the data type value from {@code Types} for
      * this data type.
-     * @param type The value from {@code Types) for this data type
+     * @param type The value from {@code Types} for this data type
      */
     JDBCType(final Integer type) {
         this.type = type;