@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Red Hat Inc.
+ * Copyright (c) 2020, 2022, Red Hat Inc.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,6 +23,7 @@
 
 /*
  * @test CgroupSubsystemFactory
+ * @bug 8287107
  * @key cgroups
  * @requires os.family == "linux"
  * @library /testlibrary /test/lib
@@ -72,6 +73,9 @@ public class CgroupSubsystemFactory {
     private Path cgroupV2SelfCgroup;
     private Path cgroupV2MntInfoMissingCgroupv2;
     private Path cgroupv1MntInfoMissingMemoryController;
+    private Path cgroupv2CgInfoNoZeroHierarchyOnlyFreezer;
+    private Path cgroupv2MntInfoNoZeroHierarchyOnlyFreezer;
+    private Path cgroupv2SelfNoZeroHierarchyOnlyFreezer;
     private String procSelfCgroupHybridContent = "11:hugetlb:/\n" +
             "10:devices:/user.slice\n" +
             "9:pids:/user.slice/user-15263.slice/user@15263.service\n" +
@@ -176,6 +180,30 @@ public class CgroupSubsystemFactory {
             "35 26 0:26 / /sys/fs/cgroup/systemd rw,nosuid,nodev,noexec,relatime - cgroup systemd rw,name=systemd\n" +
             "26 18 0:19 / /sys/fs/cgroup rw,relatime - tmpfs none rw,size=4k,mode=755\n";
 
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
     private void setup() {
         try {
             existingDirectory = Utils.createTempDirectory(CgroupSubsystemFactory.class.getSimpleName());
@@ -227,6 +255,15 @@ private void setup() {
 
             cgroupv1MountInfoJoinControllers = Paths.get(existingDirectory.toString(), "mntinfo_cgv1_join_controllers");
             Files.writeString(cgroupv1MountInfoJoinControllers, mntInfoCgroupv1JoinControllers);
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
@@ -334,6 +371,15 @@ public void testCgroupV1HybridMntInfoOrder(WhiteBox wb) {
         System.out.println("testCgroupv1HybridMntInfoOrder PASSED!");
     }
 
+    public void testNonZeroHierarchyOnlyFreezer(WhiteBox wb) {
+        String cgroups = cgroupv2CgInfoNoZeroHierarchyOnlyFreezer.toString();
+        String mountInfo = cgroupv2MntInfoNoZeroHierarchyOnlyFreezer.toString();
+        String selfCgroup = cgroupv2SelfNoZeroHierarchyOnlyFreezer.toString();
+        int retval = wb.validateCgroup(cgroups, selfCgroup, mountInfo);
+        Asserts.assertEQ(CGROUPS_V2, retval, "All V1 controllers are ignored");
+        Asserts.assertTrue(isValidCgroup(retval));
+        System.out.println("testNonZeroHierarchyOnlyFreezer PASSED!");
+    }
 
     public static void main(String[] args) throws Exception {
         WhiteBox wb = WhiteBox.getWhiteBox();
@@ -350,6 +396,7 @@ public static void main(String[] args) throws Exception {
             test.testCgroupv1MultipleCpusetMounts(wb, test.cgroupv1MntInfoDoubleCpuset);
             test.testCgroupv1MultipleCpusetMounts(wb, test.cgroupv1MntInfoDoubleCpuset2);
             test.testCgroupv1JoinControllerCombo(wb);
+            test.testNonZeroHierarchyOnlyFreezer(wb);
         } finally {
             test.teardown();
         }