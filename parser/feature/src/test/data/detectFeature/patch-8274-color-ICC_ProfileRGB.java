@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,7 +58,7 @@
  * To transform from a device profile color space to the CIEXYZ Profile
  * Connection Space, each device color component is first linearized by a lookup
  * through the corresponding tone reproduction curve (TRC). The resulting linear
- * RGB components are converted to the CIEXYZ PCS using a a 3x3 matrix
+ * RGB components are converted to the CIEXYZ PCS using a 3x3 matrix
  * constructed from the RGB colorants.
  * <pre>
  *