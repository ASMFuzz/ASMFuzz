@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat, Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -43,6 +43,7 @@
 import jdk.internal.platform.CgroupSubsystemFactory.CgroupTypeResult;
 import jdk.internal.platform.CgroupV1MetricsImpl;
 import jdk.internal.platform.cgroupv1.CgroupV1Subsystem;
+import jdk.internal.platform.cgroupv1.CgroupV1SubsystemController;
 import jdk.internal.platform.Metrics;
 import jdk.test.lib.Utils;
 import jdk.test.lib.util.FileUtils;
@@ -72,8 +73,10 @@ public class TestCgroupSubsystemFactory {
     private Path cgroupv1MntInfoDoubleCpusets;
     private Path cgroupv1MntInfoDoubleCpusets2;
     private Path cgroupv1MntInfoColonsHierarchy;
+    private Path cgroupv1MntInfoPrefix;
     private Path cgroupv1SelfCgroup;
     private Path cgroupv1SelfColons;
+    private Path cgroupv1SelfPrefix;
     private Path cgroupv2SelfCgroup;
     private Path cgroupv1SelfCgroupJoinCtrl;
     private Path cgroupv1CgroupsOnlyCPUCtrl;
@@ -166,6 +169,7 @@ public class TestCgroupSubsystemFactory {
             "42 30 0:38 / /sys/fs/cgroup/cpuset rw,nosuid,nodev,noexec,relatime shared:14 - cgroup none rw,seclabel,cpuset\n" +
             "43 30 0:39 / /sys/fs/cgroup/blkio rw,nosuid,nodev,noexec,relatime shared:15 - cgroup none rw,seclabel,blkio\n" +
             "44 30 0:40 / /sys/fs/cgroup/freezer rw,nosuid,nodev,noexec,relatime shared:16 - cgroup none rw,seclabel,freezer\n";
+    private String mntInfoPrefix = "941 931 0:36 /user.slice/user-1000.slice/session-50.scope /sys/fs/cgroup/memory ro,nosuid,nodev,noexec,relatime - cgroup cgroup rw,seclabel,memory\n";
     private String cgroupsNonZeroHierarchy =
             "#subsys_name hierarchy   num_cgroups enabled\n" +
             "cpuset  9   1   1\n" +
@@ -217,6 +221,7 @@ public class TestCgroupSubsystemFactory {
             "2:cpu,cpuacct:/\n" +
             "1:name=systemd:/user.slice/user-1000.slice/user@1000.service/apps.slice/apps-org.gnome.Terminal.slice/vte-spawn-3c00b338-5b65-439f-8e97-135e183d135d.scope\n" +
             "0::/user.slice/user-1000.slice/user@1000.service/apps.slice/apps-org.gnome.Terminal.slice/vte-spawn-3c00b338-5b65-439f-8e97-135e183d135d.scope\n";
+    private  String cgroupv1SelfPrefixContent = "9:memory:/user.slice/user-1000.slice/session-3.scope\n";
     private String cgroupv2SelfCgroupContent = "0::/user.slice/user-1000.slice/session-2.scope";
 
     @Before
@@ -257,12 +262,18 @@ public void setup() {
             cgroupv1MntInfoColonsHierarchy = Paths.get(existingDirectory.toString(), "mountinfo_colons");
             Files.writeString(cgroupv1MntInfoColonsHierarchy, mntInfoColons);
 
+            cgroupv1MntInfoPrefix = Paths.get(existingDirectory.toString(), "mountinfo-prefix");
+            Files.writeString(cgroupv1MntInfoPrefix, mntInfoPrefix);
+
             cgroupv1SelfCgroup = Paths.get(existingDirectory.toString(), "self_cgroup_cgv1");
             Files.writeString(cgroupv1SelfCgroup, cgroupv1SelfCgroupContent);
 
             cgroupv1SelfColons = Paths.get(existingDirectory.toString(), "self_colons_cgv1");
             Files.writeString(cgroupv1SelfColons, cgroupv1SelfColonsContent);
 
+            cgroupv1SelfPrefix = Paths.get(existingDirectory.toString(), "self_prefix_cgv1");
+            Files.writeString(cgroupv1SelfPrefix, cgroupv1SelfPrefixContent);
+
             cgroupv2SelfCgroup = Paths.get(existingDirectory.toString(), "self_cgroup_cgv2");
             Files.writeString(cgroupv2SelfCgroup, cgroupv2SelfCgroupContent);
 
@@ -393,6 +404,27 @@ public void testColonsCgroupsV1() throws IOException {
         assertEquals(memoryInfo.getMountRoot(), memoryInfo.getCgroupPath());
     }
 
+    @Test
+    public void testMountPrefixCgroupsV1() throws IOException {
+        String cgroups = cgroupv1CgInfoNonZeroHierarchy.toString();
+        String mountInfo = cgroupv1MntInfoPrefix.toString();
+        String selfCgroup = cgroupv1SelfPrefix.toString();
+        Optional<CgroupTypeResult> result = CgroupSubsystemFactory.determineType(mountInfo, cgroups, selfCgroup);
+
+        assertTrue("Expected non-empty cgroup result", result.isPresent());
+        CgroupTypeResult res = result.get();
+        CgroupInfo memoryInfo = res.getInfos().get("memory");
+        assertEquals(memoryInfo.getCgroupPath(), "/user.slice/user-1000.slice/session-3.scope");
+        String expectedMountPoint = "/sys/fs/cgroup/memory";
+        assertEquals(expectedMountPoint, memoryInfo.getMountPoint());
+        CgroupV1SubsystemController cgroupv1MemoryController = new CgroupV1SubsystemController(memoryInfo.getMountRoot(), memoryInfo.getMountPoint());
+        cgroupv1MemoryController.setPath(memoryInfo.getCgroupPath());
+        String actualPath = cgroupv1MemoryController.path();
+        assertNotNull("Controller path should not have been null", actualPath);
+        String expectedPath = expectedMountPoint + "/user.slice/user-1000.slice";
+        assertEquals("Should have found the longest common path", expectedPath, actualPath);
+    }
+
     @Test
     public void testZeroHierarchyCgroupsV1() throws IOException {
         String cgroups = cgroupv1CgInfoZeroHierarchy.toString();