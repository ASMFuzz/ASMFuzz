@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -195,7 +195,7 @@ public abstract ServerSocket createServerSocket(int port)
 
 
 //
-// The default factory has NO intelligence.  In fact it's not clear
+// The default factory has NO intelligence.  In fact, it's not clear
 // what sort of intelligence servers need; the onus is on clients,
 // who have to know how to tunnel etc.
 //