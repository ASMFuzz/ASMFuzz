@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -241,29 +241,45 @@ public X500Name(String commonName, String organizationUnit,
                     String organizationName, String localityName,
                     String stateName, String country)
     throws IOException {
-        names = new RDN[6];
-        /*
-         * NOTE:  it's only on output that little-endian
-         * ordering is used.
-         */
-        names[5] = new RDN(1);
-        names[5].assertion[0] = new AVA(commonName_oid,
-                new DerValue(commonName));
-        names[4] = new RDN(1);
-        names[4].assertion[0] = new AVA(orgUnitName_oid,
-                new DerValue(organizationUnit));
-        names[3] = new RDN(1);
-        names[3].assertion[0] = new AVA(orgName_oid,
-                new DerValue(organizationName));
-        names[2] = new RDN(1);
-        names[2].assertion[0] = new AVA(localityName_oid,
-                new DerValue(localityName));
-        names[1] = new RDN(1);
-        names[1].assertion[0] = new AVA(stateName_oid,
-                new DerValue(stateName));
-        names[0] = new RDN(1);
-        names[0].assertion[0] = new AVA(countryName_oid,
-                new DerValue(country));
+        RDN name;
+        List<RDN> list = new ArrayList<>(6);
+        if (country != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(countryName_oid,
+                    new DerValue(country));
+            list.add(name);
+        }
+        if (stateName != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(stateName_oid,
+                    new DerValue(stateName));
+            list.add(name);
+        }
+        if (localityName != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(localityName_oid,
+                    new DerValue(localityName));
+            list.add(name);
+        }
+        if (organizationName != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(orgName_oid,
+                    new DerValue(organizationName));
+            list.add(name);
+        }
+        if (organizationUnit != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(orgUnitName_oid,
+                    new DerValue(organizationUnit));
+            list.add(name);
+        }
+        if (commonName != null) {
+            name = new RDN(1);
+            name.assertion[0] = new AVA(commonName_oid,
+                    new DerValue(commonName));
+            list.add(name);
+        }
+        names = list.toArray(new RDN[0]);
     }
 
     /**