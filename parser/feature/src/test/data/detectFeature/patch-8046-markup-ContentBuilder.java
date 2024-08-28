@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,7 +28,6 @@
 import java.io.IOException;
 import java.io.Writer;
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 import java.util.Objects;
 
@@ -38,7 +37,7 @@
  * A sequence of Content nodes.
  */
 public class ContentBuilder extends Content {
-    protected List<Content> contents = Collections.emptyList();
+    protected List<Content> contents = List.of();
 
     public ContentBuilder() { }
 