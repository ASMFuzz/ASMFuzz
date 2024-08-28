@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -33,6 +33,7 @@
  * computations that do not throw checked exceptions; computations that
  * throw checked exceptions must use {@code PrivilegedExceptionAction}
  * instead.
+ * @param <T> the type of the result of running the computation
  *
  * @since 1.2
  * @see AccessController