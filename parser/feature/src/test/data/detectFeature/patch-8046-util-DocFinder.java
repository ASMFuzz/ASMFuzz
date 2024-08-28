@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -197,7 +197,7 @@ public static class Output {
         /**
          * The inherited documentation.
          */
-        public List<? extends DocTree> inlineTags = Collections.emptyList();
+        public List<? extends DocTree> inlineTags = List.of();
 
         /**
          * False if documentation could not be inherited.