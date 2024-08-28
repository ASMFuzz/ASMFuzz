@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -240,14 +240,10 @@ public final byte[] getEncoded() {
         byte[] retVal = null;
         try {
             retVal = ticket.asn1Encode();
-        } catch (Asn1Exception e) {
+        } catch (Asn1Exception | IOException e) {
             if (DEBUG) {
                 System.out.println(e);
             }
-        } catch (IOException ioe) {
-            if (DEBUG) {
-                System.out.println(ioe);
-            }
         }
         return retVal;
     }