@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -243,9 +243,7 @@ public boolean setHeaders(HttpURLConnection conn, HeaderParser p, String raw) {
             }
             conn.setAuthenticationProperty(getHeaderName(), response);
             return true;
-        } catch (IOException e) {
-            return false;
-        } catch (GeneralSecurityException e) {
+        } catch (IOException | GeneralSecurityException e) {
             return false;
         }
     }