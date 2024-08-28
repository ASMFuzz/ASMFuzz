@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,9 +26,9 @@
 package jdk.javadoc.internal.api;
 
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 import java.util.Locale;
+import java.util.Set;
 import java.util.concurrent.atomic.AtomicBoolean;
 
 import javax.tools.DocumentationTool.DocumentationTask;
@@ -67,9 +67,9 @@ public JavadocTaskImpl(Context context,
         this.context = context;
         this.docletClass = docletClass;
 
-        this.options = (options == null) ? Collections.emptySet()
+        this.options = (options == null) ? Set.of()
                 : nullCheck(options);
-        this.fileObjects = (fileObjects == null) ? Collections.emptySet()
+        this.fileObjects = (fileObjects == null) ? Set.of()
                 : nullCheck(fileObjects);
         setLocale(Locale.getDefault());
     }