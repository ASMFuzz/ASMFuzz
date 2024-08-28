@@ -143,6 +143,10 @@ public static Optional<CgroupTypeResult> determineType(String mountInfo,
             }
             CgroupInfo info = CgroupInfo.fromCgroupsLine(line);
             switch (info.getName()) {
+            // Only the following controllers are important to Java. All
+            // other controllers (such as freezer) are ignored and
+            // are not considered in the checks below for
+            // anyCgroupsV1Controller/anyCgroupsV2Controller.
             case CPU_CTRL:      infos.put(CPU_CTRL, info); break;
             case CPUACCT_CTRL:  infos.put(CPUACCT_CTRL, info); break;
             case CPUSET_CTRL:   infos.put(CPUSET_CTRL, info); break;
@@ -220,6 +224,12 @@ public static Optional<CgroupTypeResult> determineType(String mountInfo,
      */
     private static void setCgroupV2Path(Map<String, CgroupInfo> infos,
                                         String[] tokens) {
+        String name = tokens[1];
+        if (!name.equals("")) {
+            // This must be a v1 controller that we have ignored (e.g., freezer)
+            assert infos.get(name) == null;
+            return;
+        }
         int hierarchyId = Integer.parseInt(tokens[0]);
         String cgroupPath = tokens[2];
         for (CgroupInfo info: infos.values()) {