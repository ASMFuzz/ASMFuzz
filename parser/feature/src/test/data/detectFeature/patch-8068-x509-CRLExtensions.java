@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -168,9 +168,7 @@ else if (objs[i] instanceof Extension)
                 tmp = seq;
 
             out.write(tmp.toByteArray());
-        } catch (IOException e) {
-            throw new CRLException("Encoding error: " + e.toString());
-        } catch (CertificateException e) {
+        } catch (IOException | CertificateException e) {
             throw new CRLException("Encoding error: " + e.toString());
         }
     }