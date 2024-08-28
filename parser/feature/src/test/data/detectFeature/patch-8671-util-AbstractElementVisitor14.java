@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -64,10 +64,10 @@ protected AbstractElementVisitor14(){
      * @implSpec Visits a {@code RecordComponentElement} in a manner defined by a
      * subclass.
      *
-     * @param t  {@inheritDoc}
+     * @param e  {@inheritDoc}
      * @param p  {@inheritDoc}
      * @return   {@inheritDoc}
      */
     @Override
-    public abstract R visitRecordComponent(RecordComponentElement t, P p);
+    public abstract R visitRecordComponent(RecordComponentElement e, P p);
 }