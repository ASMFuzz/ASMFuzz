@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -82,7 +82,10 @@ public static void main(String[] args) throws Exception {
         Date d1 = c.s().getPrivateCredentials(KerberosTicket.class).iterator().next().getAuthTime();
 
         // 6s is longer than half of 10s
-        Thread.sleep(6000);
+        Date expiring = new Date(d1.getTime() + 6000);
+        while (new Date().before(expiring)) {
+            Thread.sleep(500);
+        }
 
         // The second login uses the cache
         c = Context.fromJAAS("second");