@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -69,6 +69,7 @@
  * instance is accessible; after a thread goes away, all of its copies of
  * thread-local instances are subject to garbage collection (unless other
  * references to these copies exist).
+ * @param <T> the type of the thread local's value
  *
  * @author  Josh Bloch and Doug Lea
  * @since   1.2