@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -118,7 +118,7 @@ protected abstract void engineInit(Key key, AlgorithmParameterSpec params,
      * @param key the key for this phase. For example, in the case of
      * Diffie-Hellman between 2 parties, this would be the other party's
      * Diffie-Hellman public key.
-     * @param lastPhase flag which indicates whether or not this is the last
+     * @param lastPhase flag which indicates whether this is the last
      * phase of this key agreement.
      *
      * @return the (intermediate) key resulting from this phase, or null if