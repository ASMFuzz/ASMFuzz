@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2018 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -44,6 +44,7 @@
 import java.io.IOException;
 import java.nio.ByteBuffer;
 import java.nio.channels.FileChannel;
+import java.lang.ref.Reference;
 
 public class ClassLoaderHierarchyTest {
 
@@ -93,6 +94,10 @@ public void run(CommandExecutor executor) throws ClassNotFoundException {
         output.shouldMatch("Bill.*TestClassLoader");
         output.shouldContain("TestClass2");
         output.shouldContain("Hidden Classes:");
+
+        Reference.reachabilityFence(unnamed_cl);
+        Reference.reachabilityFence(named_cl);
+        Reference.reachabilityFence(named_child_cl);
     }
 
     static class TestClassLoader extends ClassLoader {
@@ -163,4 +168,3 @@ class TestClass2 {
         r.run();
     }
 }
-