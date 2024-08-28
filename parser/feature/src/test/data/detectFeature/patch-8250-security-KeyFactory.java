@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -295,7 +295,7 @@ public final String getAlgorithm() {
 
     /**
      * Update the active KeyFactorySpi of this class and return the next
-     * implementation for failover. If no more implemenations are
+     * implementation for failover. If no more implementations are
      * available, this method returns null. However, the active spi of
      * this class is never set to null.
      */