@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,6 +40,7 @@
  * table for each class encountered at a message send call site,
  * it can use a {@code ClassValue} to cache information needed to
  * perform the message send quickly, for each class encountered.
+ * @param <T> the type of the derived value
  * @author John Rose, JSR 292 EG
  * @since 1.7
  */