@@ -61,6 +61,8 @@ public static void main(String[] args) throws Exception {
             testMemorySoftLimit("500m", "524288000");
             testMemorySoftLimit("1g", "1073741824");
 
+            testMemorySwapLimit("100m", "100m");
+
             // Add extra 10 Mb to allocator limit, to be sure to cause OOM
             testOOM("256m", 256 + 10);
 
@@ -175,4 +177,17 @@ private static void testOperatingSystemMXBeanAwareness(String memoryAllocation,
         }
     }
 
+    private static void testMemorySwapLimit(String dockerMemSwapLimit, String initialHeapSize) throws Exception {
+        Common.logNewTestCase("Check initial heap size with memory and swap limit");
+
+        DockerRunOptions opts = Common.newOpts(imageName, "CheckInitialHeapSize")
+            .addDockerOpts("--memory", dockerMemSwapLimit, "--memory-swap", dockerMemSwapLimit)
+            .addJavaOptsAppended("-Xms" + initialHeapSize);
+
+        OutputAnalyzer out = DockerTestUtils.dockerRunJava(opts);
+        out.shouldContain("Error occurred during initialization of VM")
+           .shouldContain("Initial heap size set to a larger value than the container memory & swap limit");
+
+    }
+
 }