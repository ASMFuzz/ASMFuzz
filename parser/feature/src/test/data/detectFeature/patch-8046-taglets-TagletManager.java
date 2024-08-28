@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -29,7 +29,6 @@
 import java.io.IOException;
 import java.io.PrintStream;
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.EnumMap;
 import java.util.EnumSet;
 import java.util.HashSet;
@@ -234,7 +233,7 @@ public void initTagletPath(JavaFileManager fileManager) throws IOException {
                 }
                 sfm.setLocation(TAGLET_PATH, paths);
             } else if (!sfm.hasLocation(TAGLET_PATH)) {
-                sfm.setLocation(TAGLET_PATH, Collections.emptyList());
+                sfm.setLocation(TAGLET_PATH, List.of());
             }
         } else if (tagletPath != null) {
             messages.error("doclet.not_standard_file_manager");