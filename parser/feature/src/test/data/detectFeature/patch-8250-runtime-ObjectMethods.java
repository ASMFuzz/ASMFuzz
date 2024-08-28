@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -331,7 +331,7 @@ private static MethodHandle makeToString(MethodHandles.Lookup lookup,
      * Chops the getters into smaller chunks according to the maximum number of slots
      * StringConcatFactory::makeConcatWithConstants can chew
      * @param getters the current getters
-     * @return chunks that wont surpass the maximum number of slots StringConcatFactory::makeConcatWithConstants can chew
+     * @return chunks that won't surpass the maximum number of slots StringConcatFactory::makeConcatWithConstants can chew
      */
     private static List<List<MethodHandle>> split(MethodHandle[] getters) {
         List<List<MethodHandle>> splits = new ArrayList<>();