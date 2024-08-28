@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,7 +31,6 @@
 import java.time.format.DateTimeFormatter;
 import java.util.ArrayList;
 import java.util.Arrays;
-import java.util.Collections;
 import java.util.Date;
 import java.util.List;
 import java.util.Locale;
@@ -61,12 +60,12 @@ public class Head extends Content {
     private String generator;
     private boolean showTimestamp;
     private DocPath mainStylesheet;
-    private List<DocPath> additionalStylesheets = Collections.emptyList();
+    private List<DocPath> additionalStylesheets = List.of();
     private boolean index;
     private Script mainBodyScript;
     private final List<Script> scripts;
     // Scripts added via --add-script option
-    private List<DocPath> additionalScripts = Collections.emptyList();
+    private List<DocPath> additionalScripts = List.of();
     private final List<Content> extraContent;
     private boolean addDefaultScript = true;
     private DocPath canonicalLink;