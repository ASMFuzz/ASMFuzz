@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -50,12 +50,13 @@
 
 /*
  * @test
+ * @bug 8287107
  * @key cgroups
  * @requires os.family == "linux"
  * @modules java.base/jdk.internal.platform
  *          java.base/jdk.internal.platform.cgroupv1
  * @library /test/lib
- * @run junit/othervm TestCgroupSubsystemFactory
+ * @run junit/othervm -esa TestCgroupSubsystemFactory
  */
 public class TestCgroupSubsystemFactory {
 
@@ -79,6 +80,9 @@ public class TestCgroupSubsystemFactory {
     private Path cgroupv1CgroupsOnlyCPUCtrl;
     private Path cgroupv1SelfCgroupsOnlyCPUCtrl;
     private Path cgroupv1MountInfoCgroupsOnlyCPUCtrl;
+    private Path cgroupv2CgInfoNoZeroHierarchyOnlyFreezer;
+    private Path cgroupv2MntInfoNoZeroHierarchyOnlyFreezer;
+    private Path cgroupv2SelfNoZeroHierarchyOnlyFreezer;
     private String mntInfoEmpty = "";
     private String cgroupsNonZeroJoinControllers =
             "#subsys_name hierarchy num_cgroups enabled\n" +
@@ -219,6 +223,30 @@ public class TestCgroupSubsystemFactory {
             "0::/user.slice/user-1000.slice/user@1000.service/apps.slice/apps-org.gnome.Terminal.slice/vte-spawn-3c00b338-5b65-439f-8e97-135e183d135d.scope\n";
     private String cgroupv2SelfCgroupContent = "0::/user.slice/user-1000.slice/session-2.scope";
 
+    // We have a mix of V1 and V2 controllers, but none of the V1 controllers
+    // are used by Java, so the JDK should start in V2 mode.
+    private String cgroupsNonZeroHierarchyOnlyFreezer =
+            "#subsys_name hierarchy  num_cgroups  enabled\n" +
+            "cpuset  0  171  1\n" +
+            "cpu  0  171  1\n" +
+            "cpuacct  0  171  1\n" +
+            "blkio  0  171  1\n" +
+            "memory  0  171  1\n" +
+            "devices  0  171  1\n" +
+            "freezer  1  1  1\n" +
+            "net_cls  0  171  1\n" +
+            "perf_event  0  171  1\n" +
+            "net_prio  0  171  1\n" +
+            "hugetlb  0  171  1\n" +
+            "pids  0  171  1\n" +
+            "rdma  0  171  1\n" +
+            "misc  0  171  1\n";
+    private String cgroupv1SelfOnlyFreezerContent = "1:freezer:/\n" +
+            "0::/user.slice/user-1000.slice/session-2.scope";
+    private String mntInfoOnlyFreezerInV1 =
+            "32 23 0:27 / /sys/fs/cgroup rw,nosuid,nodev,noexec,relatime shared:9 - cgroup2 cgroup2 rw,nsdelegate,memory_recursiveprot\n" +
+            "911 32 0:47 / /sys/fs/cgroup/freezer rw,relatime shared:476 - cgroup freezer rw,freezer\n";
+
     @Before
     public void setup() {
         try {
@@ -277,6 +305,15 @@ public void setup() {
 
             cgroupv1MountInfoCgroupsOnlyCPUCtrl = Paths.get(existingDirectory.toString(), "self_mountinfo_cpu_only_controller");
             Files.writeString(cgroupv1MountInfoCgroupsOnlyCPUCtrl, mntInfoCpuOnly);
+
+            cgroupv2CgInfoNoZeroHierarchyOnlyFreezer = Paths.get(existingDirectory.toString(), "cgroups_cgv2_non_zero_only_freezer");
+            Files.writeString(cgroupv2CgInfoNoZeroHierarchyOnlyFreezer, cgroupsNonZeroHierarchyOnlyFreezer);
+
+            cgroupv2SelfNoZeroHierarchyOnlyFreezer = Paths.get(existingDirectory.toString(), "self_cgroup_non_zero_only_freezer");
+            Files.writeString(cgroupv2SelfNoZeroHierarchyOnlyFreezer, cgroupv1SelfOnlyFreezerContent);
+
+            cgroupv2MntInfoNoZeroHierarchyOnlyFreezer = Paths.get(existingDirectory.toString(), "self_mountinfo_cgv2_non_zero_only_freezer");
+            Files.writeString(cgroupv2MntInfoNoZeroHierarchyOnlyFreezer, mntInfoOnlyFreezerInV1);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
@@ -403,6 +440,26 @@ public void testZeroHierarchyCgroupsV1() throws IOException {
         assertTrue("zero hierarchy ids with no mounted controllers => empty result", result.isEmpty());
     }
 
+    @Test
+    public void testNonZeroHierarchyOnlyFreezer() throws IOException {
+        String cgroups = cgroupv2CgInfoNoZeroHierarchyOnlyFreezer.toString();
+        String mountInfo = cgroupv2MntInfoNoZeroHierarchyOnlyFreezer.toString();
+        String selfCgroup = cgroupv2SelfNoZeroHierarchyOnlyFreezer.toString();
+        Optional<CgroupTypeResult> result = CgroupSubsystemFactory.determineType(mountInfo, cgroups, selfCgroup);
+
+        assertTrue("Expected non-empty cgroup result", result.isPresent());
+        CgroupTypeResult res = result.get();
+
+        assertTrue("if all mounted v1 controllers are ignored, we should user cgroups v2", res.isCgroupV2());
+        CgroupInfo memoryInfo = res.getInfos().get("memory");
+        assertEquals("/user.slice/user-1000.slice/session-2.scope", memoryInfo.getCgroupPath());
+        CgroupInfo cpuInfo = res.getInfos().get("cpu");
+        assertEquals(memoryInfo.getCgroupPath(), cpuInfo.getCgroupPath());
+        assertEquals(memoryInfo.getMountPoint(), cpuInfo.getMountPoint());
+        assertEquals(memoryInfo.getMountRoot(), cpuInfo.getMountRoot());
+        assertEquals("/sys/fs/cgroup", cpuInfo.getMountPoint());
+    }
+
     @Test
     public void testZeroHierarchyCgroupsV2() throws IOException {
         String cgroups = cgroupv2CgInfoZeroHierarchy.toString();