@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -52,6 +52,7 @@
  * performed using the path obtained by resolving the given relative path
  * against the <i>original path</i> of the directory (irrespective of if the
  * directory is moved since it was opened).
+ * @param <T> The type of element returned by the iterator
  *
  * @since   1.7
  */