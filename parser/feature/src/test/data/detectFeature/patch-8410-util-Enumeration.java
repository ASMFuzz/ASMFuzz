@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -49,6 +49,8 @@
  * adapt an {@code Enumeration} to an {@code Iterator} by using the
  * {@link #asIterator} method.
  *
+ * @param <E> the type of elements returned by this enumeration
+ *
  * @see     java.util.Iterator
  * @see     java.io.SequenceInputStream
  * @see     java.util.Enumeration#nextElement()