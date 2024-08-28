@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,6 +39,9 @@
  * <strong>NOTE: This class is obsolete.  New implementations should
  * implement the Map interface, rather than extending this class.</strong>
  *
+ * @param <K> the type of keys
+ * @param <V> the type of mapped values
+ *
  * @see     java.util.Map
  * @see     java.lang.Object#equals(java.lang.Object)
  * @see     java.lang.Object#hashCode()