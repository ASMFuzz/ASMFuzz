@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,13 +58,13 @@ public class GuardedObject implements java.io.Serializable {
      * The object we are guarding.
      */
     @SuppressWarnings("serial") // Not statically typed as Serializable
-    private Object object;
+    private final Object object;
 
     /**
      * The guard object.
      */
     @SuppressWarnings("serial") // Not statically typed as Serializable
-    private Guard guard;
+    private final Guard guard;
 
     /**
      * Constructs a GuardedObject using the specified object and guard.