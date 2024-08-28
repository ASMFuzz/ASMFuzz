@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -125,10 +125,7 @@ private static ZoneInfo getZoneInfo0(String zoneId) {
             if (zi != null) {
                 return zi;
             }
-            String zid = zoneId;
-            if (aliases.containsKey(zoneId)) {
-                zid = aliases.get(zoneId);
-            }
+            String zid = aliases.getOrDefault(zoneId, zoneId);
             int index = Arrays.binarySearch(regions, zid);
             if (index < 0) {
                 return null;
@@ -335,7 +332,7 @@ private static void load(DataInputStream dis) throws ClassNotFoundException, IOE
             }
         }
         // remove the following ids from the map, they
-        // are exclued from the "old" ZoneInfo
+        // are excluded from the "old" ZoneInfo
         zones.remove("ROC");
         for (int i = 0; i < versionCount; i++) {
             int aliasCount = dis.readShort();