@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -130,6 +130,9 @@
  * and operation mixes, this class will yield better performance than
  * {@link HashMap}, which uses <i>chaining</i> rather than linear-probing.
  *
+ * @param <K> the type of keys maintained by this map
+ * @param <V> the type of mapped values
+ *
  * @see     System#identityHashCode(Object)
  * @see     Object#hashCode()
  * @see     Collection