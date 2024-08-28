@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug      8225055 8239804 8246774 8258338 8261976 8275199
+ * @bug      8225055 8239804 8246774 8258338 8261976 8275199 8285939
  * @summary  Record types
  * @library  /tools/lib ../../lib
  * @modules jdk.javadoc/jdk.javadoc.internal.tool
@@ -605,4 +605,41 @@ public record Point(int x, int y) implements java.io.Serializable { }""");
                     </ul>
                     </section>""");
     }
+
+    @Test
+    public void testPackageTree(Path base) throws IOException {
+        Path src = base.resolve("src");
+        tb.writeJavaFiles(src,
+                """
+                    package p;
+                    /**
+                     * A point.
+                     * @param x the x coord
+                     * @param y the y coord
+                     */
+                    public record Point(int x, int y) { }""");
+
+        javadoc("-d", base.resolve("out").toString(),
+                "-quiet", "-noindex", "--no-platform-links",
+                "-sourcepath", src.toString(),
+                "p");
+        checkExit(Exit.OK);
+
+        checkOutput("p/package-tree.html", true,
+                """
+                    <section class="hierarchy">
+                    <h2 title="Record Class Hierarchy">Record Class Hierarchy</h2>
+                    <ul>
+                    <li class="circle">java.lang.Object
+                    <ul>
+                    <li class="circle">java.lang.Record
+                    <ul>
+                    <li class="circle">p.<a href="Point.html" class="type-name-link" title="class in p">Point</a></li>
+                    </ul>
+                    </li>
+                    </ul>
+                    </li>
+                    </ul>
+                    </section>""");
+    }
 }