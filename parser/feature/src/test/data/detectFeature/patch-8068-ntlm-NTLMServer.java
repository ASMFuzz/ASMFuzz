@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,7 +28,6 @@
 import com.sun.security.ntlm.NTLMException;
 import com.sun.security.ntlm.Server;
 import java.io.IOException;
-import java.security.GeneralSecurityException;
 import java.util.Map;
 import java.util.Random;
 import javax.security.auth.callback.Callback;
@@ -153,9 +152,7 @@ public char[] getPassword(String ntdomain, String username) {
                         char[] passwd = pcb.getPassword();
                         pcb.clearPassword();
                         return passwd;
-                    } catch (IOException ioe) {
-                        return null;
-                    } catch (UnsupportedCallbackException uce) {
+                    } catch (IOException | UnsupportedCallbackException e) {
                         return null;
                     }
                 }