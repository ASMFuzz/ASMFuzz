@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
 /**
  * Reference queues, to which registered reference objects are appended by the
  * garbage collector after the appropriate reachability changes are detected.
+ * @param<T> the type of the reference object
  *
  * @author   Mark Reinhold
  * @since    1.2