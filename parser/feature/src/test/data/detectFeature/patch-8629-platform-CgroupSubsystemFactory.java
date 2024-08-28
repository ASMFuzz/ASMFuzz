@@ -112,7 +112,13 @@ static CgroupMetrics create() {
             CgroupSubsystem subsystem = CgroupV2Subsystem.getInstance(anyController);
             return subsystem != null ? new CgroupMetrics(subsystem) : null;
         } else {
-            CgroupV1Subsystem subsystem = CgroupV1Subsystem.getInstance(infos);
+            CgroupV1Subsystem subsystem = null;
+            try {
+                subsystem = CgroupV1Subsystem.getInstance(infos);
+            } catch (NullPointerException e) {
+                Logger logger = System.getLogger("jdk.internal.platform");
+                logger.log(Level.DEBUG, "Creating cgroupv1 instance threw NPE. Metrics disabled.");
+            }
             return subsystem != null ? new CgroupV1MetricsImpl(subsystem) : null;
         }
     }