@@ -80,14 +80,20 @@ private static CgroupV1Subsystem initSubSystem(Map<String, CgroupInfo> infos) {
             switch (info.getName()) {
             case "memory": {
                 if (info.getMountRoot() != null && info.getMountPoint() != null) {
-                    CgroupV1MemorySubSystemController controller = new CgroupV1MemorySubSystemController(info.getMountRoot(), info.getMountPoint());
-                    controller.setPath(info.getCgroupPath());
-                    boolean isHierarchial = getHierarchical(controller);
-                    controller.setHierarchical(isHierarchial);
-                    boolean isSwapEnabled = getSwapEnabled(controller);
-                    controller.setSwapEnabled(isSwapEnabled);
-                    subsystem.setMemorySubSystem(controller);
-                    anyActiveControllers = true;
+                    try {
+                        CgroupV1MemorySubSystemController controller = new CgroupV1MemorySubSystemController(info.getMountRoot(), info.getMountPoint());
+                        controller.setPath(info.getCgroupPath());
+                        boolean isHierarchial = getHierarchical(controller);
+                        controller.setHierarchical(isHierarchial);
+                        boolean isSwapEnabled = getSwapEnabled(controller);
+                        controller.setSwapEnabled(isSwapEnabled);
+                        subsystem.setMemorySubSystem(controller);
+                        anyActiveControllers = true;
+                    } catch (NullPointerException npe) {
+                        // disable the memory controller, as hierarchical or
+                        // swap enabled look-up threw NPE when trying to find interface
+                        // files
+                    }
                 }
                 break;
             }