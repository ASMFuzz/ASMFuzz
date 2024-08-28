@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -69,7 +69,7 @@ public KeyStoreBuilderParameters(List<Builder> parameters) {
         }
 
         this.parameters = Collections.unmodifiableList(
-            new ArrayList<Builder>(parameters));
+            new ArrayList<>(parameters));
     }
 
     /**