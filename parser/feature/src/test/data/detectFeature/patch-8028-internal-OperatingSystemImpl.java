@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -93,7 +93,8 @@ public double getContainerCpuLoad() {
                 int totalCPUs = getHostOnlineCpuCount0();
                 int containerCPUs = getAvailableProcessors();
                 // scale the total host load to the actual container cpus
-                hostTicks = hostTicks * containerCPUs / totalCPUs;
+                double scaleFactor = ((double) containerCPUs) / totalCPUs;
+                hostTicks = (long) (hostTicks * scaleFactor);
                 return getUsageDividesTotal(cpuUsageSupplier().getAsLong(), hostTicks);
             } else {
                 // If CPU quotas and shares are not active then find the average load for