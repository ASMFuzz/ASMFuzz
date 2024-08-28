@@ -36,6 +36,7 @@
 import java.util.List;
 import java.util.Map;
 import java.util.Optional;
+import java.util.Objects;
 import java.util.function.Consumer;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
@@ -108,9 +109,9 @@ static CgroupMetrics create() {
         Map<String, CgroupInfo> infos = result.getInfos();
         if (result.isCgroupV2()) {
             // For unified it doesn't matter which controller we pick.
-            CgroupInfo anyController = infos.get(MEMORY_CTRL);
-            CgroupSubsystem subsystem = CgroupV2Subsystem.getInstance(anyController);
-            return subsystem != null ? new CgroupMetrics(subsystem) : null;
+            CgroupInfo anyController = infos.values().iterator().next();
+            CgroupSubsystem subsystem = CgroupV2Subsystem.getInstance(Objects.requireNonNull(anyController));
+            return new CgroupMetrics(subsystem);
         } else {
             CgroupV1Subsystem subsystem = CgroupV1Subsystem.getInstance(infos);
             return subsystem != null ? new CgroupV1MetricsImpl(subsystem) : null;