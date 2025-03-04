@@ -0,0 +1,52 @@
+/*
+ * Copyright (C) 2022 THL A29 Limited, a Tencent company. All rights reserved.
+ * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
+ *
+ * This code is free software; you can redistribute it and/or modify it
+ * under the terms of the GNU General Public License version 2 only, as
+ * published by the Free Software Foundation.
+ *
+ * This code is distributed in the hope that it will be useful, but WITHOUT
+ * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
+ * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
+ * version 2 for more details (a copy is included in the LICENSE file that
+ * accompanied this code).
+ *
+ * You should have received a copy of the GNU General Public License version
+ * 2 along with this work; if not, write to the Free Software Foundation,
+ * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
+ *
+ * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
+ * or visit www.oracle.com if you need additional information or have any
+ * questions.
+ */
+
+/**
+ * @test
+ * bug 8286066
+ * @summary VM crash caused by unloaded FillerObject_klass
+ * @library /test/lib
+ * @requires vm.cds
+ * @run driver FillerObjectLoadTest
+ */
+
+import jdk.test.lib.process.OutputAnalyzer;
+import jdk.test.lib.process.ProcessTools;
+
+public class FillerObjectLoadTest {
+    public static void main(String... args) throws Exception {
+        ProcessBuilder pb = ProcessTools.createJavaProcessBuilder(
+                "-XX:+IgnoreUnrecognizedVMOptions", "-XX:-UseCompressedClassPointers",
+                "-XX:+UnlockExperimentalVMOptions", "-XX:+UseEpsilonGC", "-Xshare:dump",
+                "-XX:SharedArchiveFile=" + TestCommon.getNewArchiveName());
+        OutputAnalyzer analyzer = new OutputAnalyzer(pb.start());
+        analyzer.shouldHaveExitValue(0);
+
+        pb = ProcessTools.createJavaProcessBuilder(
+                "-XX:+IgnoreUnrecognizedVMOptions", "-XX:-UseCompressedClassPointers",
+                "-XX:TLABSize=2048", "-Xshare:dump",
+                "-XX:SharedArchiveFile=" + TestCommon.getNewArchiveName());
+        analyzer = new OutputAnalyzer(pb.start());
+        analyzer.shouldHaveExitValue(0);
+    }
+}