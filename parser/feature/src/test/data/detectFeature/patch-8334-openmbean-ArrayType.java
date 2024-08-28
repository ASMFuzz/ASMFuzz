@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -139,7 +139,7 @@ public class ArrayType<T> extends OpenType<T> {
     private transient Integer  myHashCode = null;       // As this instance is immutable, these two values
     private transient String   myToString = null;       // need only be calculated once.
 
-    // indexes refering to columns in the PRIMITIVE_ARRAY_TYPES table.
+    // indexes referring to columns in the PRIMITIVE_ARRAY_TYPES table.
     private static final int PRIMITIVE_WRAPPER_NAME_INDEX = 0;
     private static final int PRIMITIVE_TYPE_NAME_INDEX = 1;
     private static final int PRIMITIVE_TYPE_KEY_INDEX  = 2;
@@ -664,7 +664,7 @@ boolean isAssignableFrom(OpenType<?> ot) {
     }
 
 
-    /* *** Methods overriden from class Object *** */
+    /* *** Methods overridden from class Object *** */
 
     /**
      * Compares the specified {@code obj} parameter with this