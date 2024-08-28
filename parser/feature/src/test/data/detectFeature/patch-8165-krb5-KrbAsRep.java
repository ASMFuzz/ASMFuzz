@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -44,7 +44,7 @@
  * This class encapsulates a AS-REP message that the KDC sends to the
  * client.
  */
-class KrbAsRep extends KrbKdcRep {
+final class KrbAsRep extends KrbKdcRep {
 
     private ASRep rep;  // The AS-REP message
     private Credentials creds;  // The Credentials provide by the AS-REP