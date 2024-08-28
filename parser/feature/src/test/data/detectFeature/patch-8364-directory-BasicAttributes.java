@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -76,7 +76,7 @@ public class BasicAttributes implements Attributes {
     private boolean ignoreCase = false;
 
     // The 'key' in attrs is stored in the 'right case'.
-    // If ignoreCase is true, key is aways lowercase.
+    // If ignoreCase is true, key is always lowercase.
     // If ignoreCase is false, key is stored as supplied by put().
     // %%% Not declared "private" due to bug 4064984.
     transient Hashtable<String,Attribute> attrs = new Hashtable<>(11);