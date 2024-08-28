@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -117,9 +117,9 @@ public List<String> getMetaKeywords(PackageElement packageElement) {
      */
     public List<String> getMetaKeywordsForModule(ModuleElement mdle) {
         if (options.keywords()) {
-            return Arrays.asList(mdle.getQualifiedName() + " " + "module");
+            return List.of(mdle.getQualifiedName() + " " + "module");
         } else {
-            return Collections.emptyList();
+            return List.of();
         }
     }
 