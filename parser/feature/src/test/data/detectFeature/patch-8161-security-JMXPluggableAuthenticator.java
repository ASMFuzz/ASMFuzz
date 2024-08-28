@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -133,11 +133,8 @@ public LoginContext run() throws LoginException {
                 }
             }
 
-        } catch (LoginException le) {
-            authenticationFailure("authenticate", le);
-
-        } catch (SecurityException se) {
-            authenticationFailure("authenticate", se);
+        } catch (LoginException | SecurityException e) {
+            authenticationFailure("authenticate", e);
         }
     }
 